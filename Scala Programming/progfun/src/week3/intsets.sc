object intsets{
  println("Welcome to scala worksheet")
  abstract class Intsets{
    def incl(x  :Int ) :Intsets
    def contains(x : Int):Boolean
    def union(otherSet : Intsets) : Intsets
  }
  object Empty extends Intsets{
    def contains(x: Int): Boolean = false
    def incl(x:Int) = new NonEmpty(x,Empty, Empty)
    def union(otherSet : Intsets) = otherSet

    override def toString: String = "."
  }
  class NonEmpty(elem : Int, left : Intsets, right : Intsets) extends Intsets {
    def contains(x: Int): Boolean =
      if (x < elem) left contains x
      else if (x > elem) right contains x
      else true

    def incl(x : Int) : Intsets =
      if( x< elem ) new NonEmpty(elem, left incl x, right)
      else if(x>elem) new NonEmpty(elem,left, right incl x)
      else this

    override def toString: String = "{" + left + elem +right + "}"

    override def union(otherSet: Intsets): Intsets = ((left union right) union otherSet) incl elem
  }
  val t1 = new NonEmpty(3, Empty, Empty)
  val t2 = t1 incl 10

  val t3 = new NonEmpty(5, Empty, Empty)
  val t4 = t3 incl 19
  val union = t2 union(t4)
}
