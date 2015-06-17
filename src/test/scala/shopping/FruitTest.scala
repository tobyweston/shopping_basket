package shopping

import org.specs2.mutable.Specification

class FruitTest extends Specification {

  "Noddy test so show I can create some fruit along with price" >> {
    Banana(51).price must_== 51
  }
}
