package dev.tobiadegbuji.donut.backend.donut_shop_backend.services

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut

import java.util.Optional

trait DonutService {
  //Basic Crud Features
  def createDonut(donut: Donut): Donut
  def getAllDonuts: java.util.List[Donut]
  def getDonutById(id: Long): Donut
  def updateAllDonuts: Unit
  def updateDonutById(id: Long): Unit
  def deleteAllDonuts: Unit
  def deleteDonutById(id: Long): Unit
}
