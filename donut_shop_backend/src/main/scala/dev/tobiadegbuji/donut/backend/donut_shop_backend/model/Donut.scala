package dev.tobiadegbuji.donut.backend.donut_shop_backend.model
import javax.persistence.{Entity, GeneratedValue, GenerationType, Id}

@Entity
class Donut(donutName: String, donutPrice: Double, donutType: DonutType, donutCalories: Int){

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private var id: Long = _
  private var name = donutName
  private var price = donutPrice
  private var donut_type = donutType
  private var calories = donutCalories

}
