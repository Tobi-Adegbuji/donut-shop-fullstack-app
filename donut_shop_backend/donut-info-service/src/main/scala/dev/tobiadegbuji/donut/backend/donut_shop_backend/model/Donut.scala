package dev.tobiadegbuji.donut.backend.donut_shop_backend.model

import org.hibernate.annotations.{Cascade, CascadeType}

import scala.beans.BeanProperty
import javax.persistence.{Column, Entity, EnumType, Enumerated, GeneratedValue, GenerationType, Id, OneToOne}

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

  @Cascade(Array(CascadeType.ALL))
  @OneToOne
  var nutrition: Nutrition = _

  override def toString: String = s"$id: $name"

  def this(id: Long, name: String, price: Double, donutType: DonutType, nutrition: Nutrition) {
    this()
    this.id = id
    this.name = name
    this.price = price
    this.donutType = donutType
    this.nutrition = nutrition
  }
}



