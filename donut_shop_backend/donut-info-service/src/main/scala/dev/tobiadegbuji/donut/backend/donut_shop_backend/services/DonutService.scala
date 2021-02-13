package dev.tobiadegbuji.donut.backend.donut_shop_backend.services

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut

import java.util.Optional

trait DonutService {
  //Basic Crud Features
  def saveDonut(donut: Donut): Donut
  def getAllDonuts: java.util.List[Donut]
  def getDonutById(id: Long): Donut
  def updateAllDonuts: Unit
  def updateDonut(donut: Donut): Donut
  def deleteAllDonuts: Unit
  def deleteDonutById(id: Long): Unit
}
