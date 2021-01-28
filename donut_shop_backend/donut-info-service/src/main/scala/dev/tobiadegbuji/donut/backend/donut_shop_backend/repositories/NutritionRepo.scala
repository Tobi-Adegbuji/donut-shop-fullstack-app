package dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Nutrition
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
trait NutritionRepo extends JpaRepository[Nutrition, Long]{

}
