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
      new Nutrition(245),
      new Nutrition(350),
      new Nutrition(500),
      new Nutrition(400),
      new Nutrition(75),
      new Nutrition(320),
      new Nutrition(220),
    ).foreach(nutrition => nutritionService.createNutrition(nutrition))


    val nutrition = (id: Long) => nutritionService.getNutritionById(id)

    //Bootstrap Donut data
    List(
      new Donut("Chocolate Jelly Glazed", 3.69,DonutType.JELLY, nutrition(1)),
      new Donut("Original Glazed", 1.50,DonutType.YEAST, nutrition(2)),
      new Donut("Vanilla Swirl Cake", 4.99,DonutType.CAKE, nutrition(3)),
      new Donut("Lemon Filled Donut", 2.99,DonutType.BOSTON_CREAM, nutrition(4)),
      new Donut("Cinnamon Churro", 0.99,DonutType.CHURRO, nutrition(5)),
      new Donut("Plain Donut", 1.39,DonutType.YEAST, nutrition(6)),
      new Donut("Sprinkled Glaze Donut", 2.59,DonutType.YEAST, nutrition(7))
    ).foreach(donut => donutService.createDonut(donut))



  }

  def run(args: ApplicationArguments) = bootstrap()
}
