package dev.tobiadegbuji.donut.backend.donut_shop_backend.services

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Nutrition

trait NutritionService {
  def createNutrition(nutrition: Nutrition)
  def getNutritionById(id: Long): Nutrition
}
