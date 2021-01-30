//package dev.tobiadegbuji.donut.backend.donut_shop_backend.repository
//
//import dev.tobiadegbuji.donut.backend.donut_shop_backend.prototype.DonutPrototype
//import dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories.DonutRepo
//import org.assertj.core.api.Assertions.assertThat
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Component
//
//@Component
//class DonutRepoTest {
//
//    var donutRepo: DonutRepo =
//
//    fun DonutRepoTest(donutRepo: DonutRepo){
//
//    }
//
//    @Test
//    fun findDonutByName(): Unit  {
//        donutRepo?.save(DonutPrototype.aDonut())
//        val foundDonut = donutRepo?.findDonutByName(DonutPrototype.aDonut().name)
//        assertThat(foundDonut).isNotNull()
//        assertThat(foundDonut?.name).isEqualTo(DonutPrototype.aDonut().name)
//    }
//
//}