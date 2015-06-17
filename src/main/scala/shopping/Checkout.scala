package shopping

object Checkout {

  def price(items: Seq[Fruit]): Int = {
    val discounts = items.distinct.map(_.discountFor(items))
    items.map(_.price).sum - discounts.sum
  }
}
