package week3

/**
  * Created by aneesha on 3/8/16.
  */
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
