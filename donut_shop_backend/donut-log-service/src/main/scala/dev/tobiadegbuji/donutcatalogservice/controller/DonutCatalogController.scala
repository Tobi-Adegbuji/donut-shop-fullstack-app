package dev.tobiadegbuji.donutcatalogservice.controller

import dev.tobiadegbuji.donutcatalogservice.model.CatalogItem
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, RequestMapping, RestController}
import java.util

@RestController
@RequestMapping(Array("/v1/catalog"))
class DonutCatalogController {

  @GetMapping(Array("/{userId}"))
  def getCatalog(@PathVariable userId: Long): util.List[CatalogItem] = {
    var list = new util.ArrayList[CatalogItem]
    list.add(new CatalogItem("Glazed Donut", "Test",3))
    list
  }



}
