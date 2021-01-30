package dev.tobiadegbuji.donut.backend.donut_shop_backend.repository

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.{Donut, DonutType, Nutrition}
import dev.tobiadegbuji.donut.backend.donut_shop_backend.prototype.DonutPrototype
import dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories.{DonutRepo, NutritionRepo}
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner

import scala.beans.BeanProperty

@ExtendWith(Array(classOf[SpringExtension]))
@DataJpaTest
class DonutRepoTest(@Autowired val donutRepo:DonutRepo, @Autowired val nutritionRepo: NutritionRepo){

  @Test
  def shouldReturnDonutWhenNameIsPassed(): Unit = {
    var donut = DonutPrototype.aDonut()
    donutRepo.save(DonutPrototype.aDonut())
    val foundDonut = donutRepo.findDonutByName(DonutPrototype.aDonut().name)
    assertThat(foundDonut).isNotNull()
    assertThat(foundDonut.name).isEqualTo(DonutPrototype.aDonut().name)
  }

}
