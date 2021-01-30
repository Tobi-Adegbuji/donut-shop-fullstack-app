package dev.tobiadegbuji.donut.backend.donut_shop_backend.prototype

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.{Donut, DonutType, Nutrition}

class DonutPrototype
object DonutPrototype {
  def aDonut(): Donut = new Donut(123L,"Glazed Donut", 3.99, DonutType.YEAST, new Nutrition(0,234))
}
