import scala.reflect.runtime.universe._


object TagExamp extends App {

  def test [A : TypeTag](x: List[A]) = typeOf[A] match {
    case t if t =:= typeOf[String] => println("strings")
    case t if t <:< typeOf[Int] => println("Ints")
  }


  test (List("string"))
  test (List (1,2,3))
}

