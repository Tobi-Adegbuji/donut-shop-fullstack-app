package dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut
import org.springframework.data.jpa.repository.JpaRepository

trait DonutRepo extends JpaRepository[Donut, Long]{

}
