import FactoryLogger.logger

object Calculator extends App{
  sealed trait Calculator {
    def performCalculation:Int
  }
  class Add(a:Int,b:Int) extends Calculator {
    override def performCalculation: Int ={
      a + b
    }
  }
  class Subtract(a:Int,b:Int) extends Calculator {
    override def performCalculation: Int ={
      a-b
    }
  }
  class Multiply(a:Int,b:Int) extends Calculator {
    override def performCalculation: Int ={
      a*b
    }
  }
  class Divide(a:Int,b:Int) extends Calculator {
    override def performCalculation: Int ={
      if(b!=0) {
        a/b
      }
      else {
        0
      }
    }
  }

  val add = new Add(4, 1)
  val subtract = new Subtract(4, 1)
  val multiply = new Multiply(4, 1)
  val divide = new Divide(4, 1)

  logger.info("Sum is {}",add.performCalculation)
  logger.info("Difference is {}",subtract.performCalculation)
  logger.info("Product is {}",multiply.performCalculation)
  logger.info("Division is {}",divide.performCalculation)
}

