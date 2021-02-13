package dev.tobiadegbuji.donut.backend.donut_shop_backend.services
import dev.tobiadegbuji.donut.backend.donut_shop_backend.exception.ResourceNotFoundException
import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut
import dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories.DonutRepo
import lombok.Builder
import org.apache.logging.log4j.Logger
import org.springframework.stereotype.Service

import java.util.List

@Service
class DonutServiceImpl(donutRepo: DonutRepo, awsS3Service: AWSS3Service) extends DonutService {


  override def saveDonut(donut: Donut) = donutRepo.save(donut)

  override def getAllDonuts: List[Donut] = {
    val donutList = donutRepo.findAll
//    log.info("All Donuts have been retrieved.")
    donutList
  }

  override def getDonutById(id: Long) = {
    val donutOptional = donutRepo.findById(id)
    if(!donutOptional.isPresent)
      throw new ResourceNotFoundException(id, "Donut")
    else donutOptional.get
  }

  override def updateAllDonuts: Unit = ???

  override def updateDonut(donut: Donut): Donut = {
    donut
  }

  override def deleteAllDonuts: Unit = ???

  override def deleteDonutById(id: Long): Unit = ???
}
