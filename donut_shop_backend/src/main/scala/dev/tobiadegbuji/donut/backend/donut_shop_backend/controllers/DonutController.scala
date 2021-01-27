package dev.tobiadegbuji.donut.backend.donut_shop_backend.controllers

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut
import dev.tobiadegbuji.donut.backend.donut_shop_backend.services.DonutService
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, PostMapping, RequestBody, RestController}

@RestController
class DonutController(donutService: DonutService) {

  @GetMapping(Array("/v1/donut"))
  val getAllDonuts = () => donutService.getAllDonuts()

  @GetMapping(Array("/v1/donut/{id}"))
  def getDonut(@PathVariable id: Long) = donutService.getDonutById(id)

  @PostMapping(Array("/v1/donut"))
  def createDonut(@RequestBody donut: Donut) = donutService.createDonut(donut)





}
