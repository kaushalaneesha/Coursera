import week4.Succ

object rationals{
  println("Welcome to rational")
  val x = new Rational(1,3)
  println(x.num)
  val y = new Rational(5,7)
  x.add(y)
  val z= new Rational(3,0)
  x.add(y).mul(z)
  y.add(y)
}

class Rational(x: Int, y: Int){
  require(y!=0, "Illegal argument")
  def num = x
  def denom = y

  def this(x:Int) = this(x,1)

  def add(that : Rational) =
    new Rational(
      num*that.denom + denom*that.num,
      denom*that.denom)

  def sub(that : Rational) =
    new Rational(
      num*that.denom - denom*that.num,
      denom*that.denom)

  def mul(that : Rational) =
    new Rational(
      num*that.num,denom*that.denom)

  def neg = {
    new Rational(-num,denom)
  }

  override def toString= num + " / " +denom
}

1+2