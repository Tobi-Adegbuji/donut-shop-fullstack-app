package dev.tobiadegbuji.donut.backend.donut_shop_backend.model
import javax.persistence.{Column, Entity, GeneratedValue, GenerationType, Id}

@Entity
 class Donut(name: String, donutPrice: Double, donutType: DonutType, donutCalories: Int){

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private var id: Long = _
  private var donutName = name
  private var price = donutPrice
  private var donut_type = donutType
  private var calories = donutCalories

  //Default Constructor REQUIRED for JPA
  def this() = this("",0,DonutType.YEAST,0)


}
