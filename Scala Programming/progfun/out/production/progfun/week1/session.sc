1+2
def abs(x:Double) = if(x<0) -x else x

def sqrt(x:Double) = {

  //Nested functions only accessable from inside
  def sqrtIter(guess:Double) : Double =
    if(isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  def isGoodEnough(guess:Double) : Boolean =
    abs(guess * guess - x) / x < 0.001

  def improve(guess:Double) : Double =
    (guess+ x/guess)/2

  sqrtIter(1.0)
}

sqrt(2)
sqrt(1e-6)