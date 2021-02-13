package dev.tobiadegbuji.donut.backend.donut_shop_backend.controllers

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut
import dev.tobiadegbuji.donut.backend.donut_shop_backend.services.DonutService
import lombok.extern.slf4j.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation._
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import javax.validation.Valid

@RestController
@RequestMapping(Array("/v1/donut"))
class DonutController(donutService: DonutService) {


  @GetMapping
  def getAllDonuts(): java.util.List[Donut] = donutService.getAllDonuts

  @GetMapping(Array("/{id}"))
  def getDonut(@PathVariable id: Long) = {
    val donut = donutService.getDonutById(id)
    donut
  }

  @PostMapping
  def createDonut(@Valid @RequestBody donut: Donut) = {
    val d = donutService.createDonut(donut)
    //Adds location to response header along with a 210 created status code
    val uri = ServletUriComponentsBuilder.fromCurrentRequest().path(s"/${d.getId}")
      .buildAndExpand(d.getId).toUri
    ResponseEntity.created(uri).build()
  }


}
