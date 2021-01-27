package dev.tobiadegbuji.donut.backend.donut_shop_backend.controllers

import org.springframework.web.bind.annotation.{GetMapping, RestController}

@RestController
class DonutController(donutService: DonutService) {

  @GetMapping("/v1/donut")
  val getAllDonuts = () =>

}
