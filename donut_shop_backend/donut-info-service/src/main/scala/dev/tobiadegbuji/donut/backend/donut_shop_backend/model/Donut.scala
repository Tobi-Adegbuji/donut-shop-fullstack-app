package dev.tobiadegbuji.donut.backend.donut_shop_backend.model

import org.hibernate.annotations.{Cascade, CascadeType}
import org.hibernate.validator.constraints.Currency

import scala.beans.BeanProperty
import javax.persistence.{Column, Entity, EnumType, Enumerated, GeneratedValue, GenerationType, Id, OneToOne}
import javax.validation.constraints.{Max, NotEmpty, Size}

@Entity
class Donut {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Long = _

  @Size(min = 5, max = 50, message = "Donut Name must bee between 5 and 50 characters")
  @NotEmpty(message = "Donut Name cannot be null or empty")
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



