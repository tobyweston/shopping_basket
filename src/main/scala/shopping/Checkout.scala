package shopping

object Checkout {

  def price(items: Seq[Fruit]): Int = {
    items.foldLeft(0)(_ + _.price)
  }
}
