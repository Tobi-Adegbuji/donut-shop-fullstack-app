package dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
trait DonutRepo extends JpaRepository[Donut, Long]{
  def findDonutByName:String
}
