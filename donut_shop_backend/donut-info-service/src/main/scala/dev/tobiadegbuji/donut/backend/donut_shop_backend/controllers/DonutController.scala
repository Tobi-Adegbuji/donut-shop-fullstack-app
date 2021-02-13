package dev.tobiadegbuji.donut.backend.donut_shop_backend.controllers

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut
import dev.tobiadegbuji.donut.backend.donut_shop_backend.services.{AWSS3Service, DonutService}
import lombok.extern.slf4j.Slf4j
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation._
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import javax.validation.Valid

@RestController
@RequestMapping(Array("api/v1/donut"))
class DonutController(donutService: DonutService, awsS3Service: AWSS3Service) {


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

  @PutMapping(Array{"/uploadImage"})
  def uploadDonutImage(@RequestPart(value = "file") multipartFile: MultipartFile): ResponseEntity[String] ={
    awsS3Service.uploadFile(multipartFile)
    new ResponseEntity[String]("", HttpStatus.CREATED)
  }

}
