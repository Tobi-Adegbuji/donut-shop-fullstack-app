package dev.tobiadegbuji.donut.backend.donut_shop_backend.services
import dev.tobiadegbuji.donut.backend.donut_shop_backend.exception.ResourceNotFoundException
import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Nutrition
import dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories.NutritionRepo
import org.springframework.stereotype.Service

@Service
class NutritionServiceImpl(nutritionRepo: NutritionRepo) extends NutritionService {

  override def createNutrition(nutrition: Nutrition): Unit = nutritionRepo.save(nutrition)

  override def getNutritionById(id: Long) = {

    val optionalNutrition= nutritionRepo.findById(id)

    if (optionalNutrition.isPresent)  optionalNutrition.get
    else  throw new ResourceNotFoundException(id, "Nutrition")
  }
}
