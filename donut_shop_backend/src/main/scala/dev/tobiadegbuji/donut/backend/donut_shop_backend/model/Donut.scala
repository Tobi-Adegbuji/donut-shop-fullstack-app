package dev.tobiadegbuji.donut.backend.donut_shop_backend.model

import scala.beans.BeanProperty
import javax.persistence.{Entity, EnumType, Enumerated, GeneratedValue, GenerationType, Id}

@Entity
class Donut {

  def this(name: String, price: Double, donutType: DonutType, calories: Int) {
    this()
    this.name = name
    this.price = price
    this.donutType = donutType
    this.calories = calories
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var name: String = _

  @BeanProperty
  var price: Double = _

  @BeanProperty
  var donutType: DonutType = _

  @BeanProperty
  var calories: Int = _

  override def toString: String = s"$id: $name"
}



