package dev.tobiadegbuji.donut.backend.donut_shop_backend.services
import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.Donut
import dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories.DonutRepo
import org.springframework.stereotype.Service

@Service
class DonutServiceImpl(donutRepo: DonutRepo) extends DonutService {
  override def createDonut(donut: Donut): Unit = ???

  override def getAllDonuts(): java.util.List[Donut] = donutRepo.findAll()

  override def getDonutById(id: Long): Donut = donutRepo.findById(id).get()

  override def updateAllDonuts(): Unit = ???

  override def updateDonutById(id: Long): Unit = ???

  override def deleteAllDonuts(): Unit = ???

  override def deleteDonutById(): Unit = ???
}
