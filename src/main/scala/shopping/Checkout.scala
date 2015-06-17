package shopping

object Checkout {

  def price(items: Seq[Fruit]): Int = {
    items.map(_.price).sum
  }
}
