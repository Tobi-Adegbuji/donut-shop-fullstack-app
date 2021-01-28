package dev.tobiadegbuji.donut.backend.donut_shop_backend.model

import scala.beans.BeanProperty
import javax.persistence.{Entity, EnumType, Enumerated, GeneratedValue, GenerationType, Id, OneToOne}

@Entity
class Donut {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var name: String = _

  @BeanProperty
  var price: Double = _

  @Enumerated(EnumType.STRING)
  @BeanProperty
  var donutType: DonutType = _

  @OneToOne
  var nutrition: Nutrition = _

  override def toString: String = s"$id: $name"

  def this(name: String, price: Double, donutType: DonutType, nutrition: Nutrition) {
    this()
    this.name = name
    this.price = price
    this.donutType = donutType
    this.nutrition = nutrition
  }
}



