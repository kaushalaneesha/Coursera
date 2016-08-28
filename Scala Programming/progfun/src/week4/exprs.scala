package week4

/**
  * Created by aneesha on 7/8/16.
  */
object exprs {
  def show(e: Expr) : String= e match {
    case Number(n) => n.toString
    case Sum(l,r) => show(l) + " + " +  show(r)
  }
  show(Sum(Number(44),Number(1)))
}
