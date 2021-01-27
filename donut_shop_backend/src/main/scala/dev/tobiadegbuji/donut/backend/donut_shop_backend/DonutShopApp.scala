package dev.tobiadegbuji.donut.backend.donut_shop_backend

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class DonutShopApp

object DonutShopApp extends App{
  SpringApplication.run(classOf[DonutShopApp], args:_*)
}
