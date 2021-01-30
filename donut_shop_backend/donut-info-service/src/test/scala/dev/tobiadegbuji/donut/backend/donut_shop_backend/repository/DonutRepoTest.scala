package dev.tobiadegbuji.donut.backend.donut_shop_backend.repository

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut
import dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories.DonutRepo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner

@ExtendWith(classOf[SpringRunner])
@DataJpaTest
class DonutRepoTest (donutRepo: DonutRepo){

  @Test
  def findDonutByName(): Unit = {
      val donut = new Donut("Spic")
  }

}
