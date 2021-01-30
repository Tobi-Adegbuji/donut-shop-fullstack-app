package dev.tobiadegbuji.donutcatalogservice.model


class CatalogItem {

  var name: String = _
  var description: String = _
  var rating: Int = _

  def this(name: String, description: String, rating: Int ) = {
    this()
    this.name = name
    this.description = description
    this.rating = rating
  }


}
