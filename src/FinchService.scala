import com.twitter.finagle.http.{Request, Response}
import com.twitter.finagle.{Http, ListeningServer, Service}
import com.twitter.finagle.stats.Counter
import com.twitter.server.TwitterServer
import com.twitter.util.Await

import io.finch._

object FinchServer extends TwitterServer {

	
val counter: Counter = statsReceiver.counter("count")
val port: Flag[Int] = flag("port", 8081, "TCP port")


    // GET /user/:name
  val username: Endpoint[String] = get("user" / string) { name: String => Ok(s"user, $name!")
	counter.incr()

   // GET /user/:name?family="siavashi"
  val family: RequestReader[String] = paramOption("family").withDefault("")
  val user: Endpoint[String] = get("user" / string ? family) { (name: String, family: String) =>
      Ok(s"user, $family$name!")
    }


	
val Endpoints: Service[Request, Response] = (username :+: family ).toService
	
	
def main(): Unit = {
    val server: ListeningServer = Http.server
    .withStatsReceiver(statsReceiver)
    .serve(s":${port()}", Endpoints)

    onExit { server.close() }

    Await.ready(adminHttpServer)
  }
	
	
}
