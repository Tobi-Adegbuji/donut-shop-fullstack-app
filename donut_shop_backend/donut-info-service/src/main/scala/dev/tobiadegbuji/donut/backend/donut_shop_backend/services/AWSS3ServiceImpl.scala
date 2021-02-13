package dev.tobiadegbuji.donut.backend.donut_shop_backend.services

import com.amazonaws.AmazonServiceException
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

import java.io.{File, FileOutputStream, IOException, OutputStream}
import java.time.LocalDateTime

@Service
class AWSS3ServiceImpl(private val amazonS3: AmazonS3, @Value("${aws.s3.bucket}") private val bucketName: String) extends AWSS3Service {

  private val log = org.slf4j.LoggerFactory.getLogger(classOf[AWSS3ServiceImpl])

  private var tempFileKey: String = null

  @Async //Ensures method is executed in another thread
  override def uploadFile(multiPartFile: MultipartFile): Unit = {
    try {
      val file: File = convertMultiPartFileToFile(multiPartFile)
      log.info(s"File Upload in progress for: ${file.getName}")
      uploadFileToS3Bucket(bucketName, file)
      log.info(s"File upload complete for: ${file.getName}")

      if (file.delete) log.info(s"Local file with name ${file.getName} was successfully deleted")
      else log.error(s"Local file with name ${file.getName} was NOT deleted")
    }
    catch {
      case e: AmazonServiceException =>
        log.info("File Upload failed")
        log.error("Error= {} while uploading file", e.getMessage)
    }
  }

  private def convertMultiPartFileToFile(multipartFile: MultipartFile): File = {
    val file: File = new File(multipartFile.getOriginalFilename)
    var outputStream: OutputStream = null
    try {
       outputStream = new FileOutputStream(file)
      outputStream.write(multipartFile.getBytes)
    }
    catch {
      case e: IOException =>
        //throw some error
        log.info(s"Error Converting multi-part file to file: ${e.getMessage}")
    }
    finally {
      outputStream.close()
    }
    file
  }

  private def uploadFileToS3Bucket(bucketName: String, file: File): Unit = {
    val fileKey: String = LocalDateTime.now() + s"_${file.getName}"
    log.info(s"Uploading file with name: $fileKey")
    val putObjectRequest: PutObjectRequest = new PutObjectRequest(bucketName, fileKey, file)
    amazonS3.putObject(putObjectRequest)
    tempFileKey = fileKey
  }

  def getS3ObjectURL(): String = {
    s"https://donut-app-bucket.s3.amazonaws.com/$tempFileKey"
  }


}
