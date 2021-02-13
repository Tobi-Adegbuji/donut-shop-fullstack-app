package dev.tobiadegbuji.donut.backend.donut_shop_backend.services

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut
import org.springframework.web.multipart.MultipartFile

trait DonutService {
  //Basic Crud Features
  def saveDonut(donut: Donut): Donut
  def getAllDonuts: java.util.List[Donut]
  def getDonutById(id: Long): Donut
  def updateDonutImageById(id: Long, multipartFile: MultipartFile): String
  def updateAllDonuts: Unit
  def updateDonut(donut: Donut): Donut
  def deleteAllDonuts: Unit
  def deleteDonutById(id: Long): Unit
}
