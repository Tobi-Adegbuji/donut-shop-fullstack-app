package dev.tobiadegbuji.donut.backend.donut_shop_backend.services

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut

trait DonutService {
  //Basic Crud Features
  def createDonut()
  def getAllDonuts(donut: Donut)
  def getDonutById(id: Long)
  def updateAllDonuts()
  def updateDonutById(id: Long)
  def deleteAllDonuts()
}
