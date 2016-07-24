package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = if(c==r || c==0) 1 else pascal(c,r-1) + pascal(c-1,r-1)

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def balanceIter(chars : List[Char],numOpens : Int) : Boolean = {
      if(numOpens<0 || (chars.isEmpty && numOpens!=0)) false
      else if(chars.isEmpty) true
      else {
        val tail = chars.tail
        val head = chars.head
        if (head.equals('(')) balanceIter(tail,numOpens+1)
        else if(head.equals(')')) balanceIter(tail,numOpens-1)
        else balanceIter(tail,numOpens)
      }
    }
    balanceIter(chars,0)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    val coinsSorted = coins.sortWith(_<_)
    if(money<=0 || coinsSorted.isEmpty) 0 else if(money==coinsSorted.head) 1
    else countChange(money-coinsSorted.head,coinsSorted) + countChange(money,coinsSorted.tail)
  }
}
