
object Main {

  object BarCodes {
    opaque type BarCode = String
    
    object BarCode {
      def mkBarCode(code: String): Either[String, BarCode] = {
        Either.cond(
          code.matches("\\d-\\d{6}-\\d{6}"),
          code,
          s"The given code $code has not the right format"
        )   
      }
    }
    
    extension (b: BarCode) {
      def country: Char = b.head
    }
    
    val barCode: BarCode = "8-000137-001620"
  }
  
  // Won't compile
  // val anotherBarCode: BarCode = "8-000137-001620"
  
  def main(args: Array[String]): Unit = {
    val code = BarCodes.BarCode.mkBarCode("8-000137-001620")
    println(code)
  }
}
