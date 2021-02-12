package dev.tobiadegbuji.donut.backend.donut_shop_backend.services
import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Nutrition
import dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories.NutritionRepo
import org.springframework.stereotype.{Component, Service}

@Service
class NutritionServiceImpl(nutritionRepo: NutritionRepo) extends NutritionService {
  override def createNutrition(nutrition: Nutrition): Unit = nutritionRepo.save(nutrition)
  override def getNutritionById(id: Long) = nutritionRepo.findById(id).get()
}
