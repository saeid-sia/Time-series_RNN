
object Decorator {

  def add(a: Int, b: Int) = a + b
  def subtract(a: Int, b: Int) = a - b
  def multiply(a: Int, b: Int) = a * b
  def divide(a: Int, b: Int) = a / b

  def wraper(calcFn: (Int, Int) => Int) =
    (a: Int, b: Int) => {
      val result = calcFn(a, b)
      println("Result is: " + result)
      result
    }

  val loggingAdd = wraper(add)
  val loggingSubtract = wraper(subtract)
  val loggingMultiply = wraper(multiply)
  val loggingDivide = wraper(divide)

}
