package dev.tobiadegbuji.donut.backend.donut_shop_backend.model

import javax.persistence.{Entity, GeneratedValue, GenerationType, Id}
import scala.beans.BeanProperty

@Entity
class Nutrition {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var calories: Int = _

  def this(id: Int, calories: Int) = {
    this()
    this.calories = calories
  }


}
