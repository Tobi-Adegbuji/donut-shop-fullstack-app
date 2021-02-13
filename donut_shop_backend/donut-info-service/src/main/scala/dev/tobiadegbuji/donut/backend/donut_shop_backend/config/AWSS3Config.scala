package dev.tobiadegbuji.donut.backend.donut_shop_backend.config

import com.amazonaws.auth.{AWSStaticCredentialsProvider, BasicAWSCredentials}
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}
import lombok.extern.slf4j.Slf4j
import org.apache.http.client.CredentialsProvider
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration
import org.springframework.context.annotation.{Bean, Configuration}

@Slf4j
@EnableAutoConfiguration(exclude = Array{classOf[ContextInstanceDataAutoConfiguration]})
@Configuration
class AWSS3Config (@Value("${cloud.aws.credentials.access-key}") val accessKeyId: String, @Value("${cloud.aws.credentials.secret-key}") val secretAccessKey: String,
                   @Value("${cloud.aws.region.static}") val region: String){

  @Bean
  def retrieveAWSS3Client(): AmazonS3 = {

    val basicAWSCredentials: BasicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey)

     AmazonS3ClientBuilder
      .standard()
       .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
       .withRegion(region)
      .build()
  }


}
