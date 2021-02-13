package dev.tobiadegbuji.donut.backend.donut_shop_backend.services

import org.springframework.web.multipart.MultipartFile

trait AWSS3Service {

  def uploadFile(multiPartFile: MultipartFile)
  def getS3ObjectURL(): String
}
