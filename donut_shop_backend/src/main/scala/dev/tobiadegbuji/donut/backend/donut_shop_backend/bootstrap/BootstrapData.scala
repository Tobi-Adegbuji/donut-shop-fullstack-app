package dev.tobiadegbuji.donut.backend.donut_shop_backend.bootstrap

import org.springframework.boot.{ApplicationArguments, ApplicationRunner, CommandLineRunner}
import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.{Donut, DonutType}
import dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories.DonutRepo
import org.springframework.stereotype.Component

@Component
class BootstrapData(donutRepo: DonutRepo) extends ApplicationRunner{

  //Create list of donuts and persist them to database
  val bootstrap = () => {

    List(
      new Donut("Chocolate Jelly Glazed", 3.69,DonutType.JELLY, 245),
      new Donut("Original Glazed", 1.50,DonutType.YEAST, 350),
      new Donut("Vanilla Swirl Cake", 4.99,DonutType.CAKE, 500),
      new Donut("Lemon Filled Donut", 2.99,DonutType.BOSTON_CREAM, 400),
      new Donut("Cinnamon Churro", 0.99,DonutType.CHURRO, 75),
      new Donut("Plain Donut", 1.39,DonutType.YEAST, 320),
      new Donut("Sprinkled Glaze Donut", 2.59,DonutType.YEAST, 220)
    ).foreach(donut => donutRepo.save(donut))



  }

  def run(args: ApplicationArguments) = bootstrap()
}
