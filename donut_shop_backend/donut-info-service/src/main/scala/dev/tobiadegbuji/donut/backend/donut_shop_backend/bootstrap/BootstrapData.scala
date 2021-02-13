package dev.tobiadegbuji.donut.backend.donut_shop_backend.bootstrap

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.{Donut, DonutType, Nutrition}
import dev.tobiadegbuji.donut.backend.donut_shop_backend.services.{DonutService, NutritionService}
import org.springframework.boot.{ApplicationArguments, ApplicationRunner}
import org.springframework.stereotype.Component

@Component
class BootstrapData(donutService: DonutService, nutritionService: NutritionService) extends ApplicationRunner{



  //Create list of donuts and persist them to database
  val bootstrap = () => {

    //Bootstrap Nutrition data
    List(
      new Nutrition(1,245),
      new Nutrition(2,350),
      new Nutrition(3,500),
      new Nutrition(4,400),
      new Nutrition(5,75),
      new Nutrition(6,320),
      new Nutrition(7,220),
    ).foreach(nutrition => nutritionService.createNutrition(nutrition))


    val nutrition = (id: Long) => nutritionService.getNutritionById(id)

    //Bootstrap Donut data
    List(
      new Donut(1,"Chocolate Jelly Glazed", 3.69,DonutType.JELLY, nutrition(1)),
      new Donut(2,"Original Glazed", 1.50,DonutType.YEAST, nutrition(2)),
      new Donut(3,"Vanilla Swirl Cake", 4.99,DonutType.CAKE, nutrition(3)),
      new Donut(4,"Lemon Filled Donut", 2.99,DonutType.BOSTON_CREAM, nutrition(4)),
      new Donut(5,"Cinnamon Churro", 0.99,DonutType.CHURRO, nutrition(5)),
      new Donut(6,"Plain Donut", 1.39,DonutType.YEAST, nutrition(6)),
      new Donut(7, "Sprinkled Glaze Donut", 2.59,DonutType.YEAST, nutrition(7))
    ).foreach(donut => donutService.saveDonut(donut))



  }

  def run(args: ApplicationArguments) = bootstrap()
}
