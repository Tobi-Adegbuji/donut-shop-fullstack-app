package dev.tobiadegbuji.donut.backend.donut_shop_backend.services
import dev.tobiadegbuji.donut.backend.donut_shop_backend.exception.ResourceNotFoundException
import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut
import dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories.DonutRepo
import org.apache.logging.log4j.Logger
import org.springframework.stereotype.Service

import java.util.List

@Service
class DonutServiceImpl(donutRepo: DonutRepo) extends DonutService {


  override def createDonut(donut: Donut) = donutRepo.save(donut)

  override def getAllDonuts: List[Donut] = {
    val donutList = donutRepo.findAll()
//    log.info("All Donuts have been retrieved.")
    donutList
  }

  override def getDonutById(id: Long) = {
    val donutOptional = donutRepo.findById(id)
    if(!donutOptional.isPresent)
      throw new ResourceNotFoundException(id, "Donut")
    else donutOptional.get()
  }

  override def updateAllDonuts: Unit = ???

  override def updateDonutById(id: Long): Unit = ???

  override def deleteAllDonuts: Unit = ???

  override def deleteDonutById(id: Long): Unit = ???
}
