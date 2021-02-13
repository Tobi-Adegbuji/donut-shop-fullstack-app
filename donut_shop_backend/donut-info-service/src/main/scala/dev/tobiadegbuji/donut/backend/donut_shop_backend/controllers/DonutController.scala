package dev.tobiadegbuji.donut.backend.donut_shop_backend.controllers

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut
import dev.tobiadegbuji.donut.backend.donut_shop_backend.services.DonutService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation._
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping(Array("api/v1/donut"))
class DonutController(donutService: DonutService) {


  @GetMapping
  def getAllDonuts(): java.util.List[Donut] = donutService.getAllDonuts

  @GetMapping(Array("/{donutId}"))
  def getDonut(@PathVariable donutId: Long) = {
    val donut = donutService.getDonutById(donutId)
    donut
  }

  @PostMapping
  def postDonut(@Valid @RequestBody donut: Donut) = {
    val d = donutService.saveDonut(donut)
    //Adds location to response header along with a 210 created status code
    val uri = ServletUriComponentsBuilder
      .fromCurrentRequest().
      path(s"/${d.getId}")
      .buildAndExpand(d.getId)
      .toUri

    ResponseEntity.created(uri).build()
  }

  @PutMapping(Array{"/{donutId}/uploadImage"})
  def uploadDonutImage(@RequestPart(value = "file") multipartFile: MultipartFile, @PathVariable donutId:Long): ResponseEntity[String] ={
    val resourceUrl: String = donutService.updateDonutImageById(donutId, multipartFile)

    val uri: URI = new URI(resourceUrl)

    ResponseEntity.created(uri).build()


  }

}
