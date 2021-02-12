package dev.tobiadegbuji.donut.backend.donut_shop_backend.controllers

import dev.tobiadegbuji.donut.backend.donut_shop_backend.exception.DonutNotFoundException
import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut
import dev.tobiadegbuji.donut.backend.donut_shop_backend.services.DonutService
import lombok.extern.java.Log
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, PostMapping, RequestBody, RequestMapping, RestController}
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import javax.validation.Valid

@Slf4j
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
