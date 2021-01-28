package dev.tobiadegbuji.donut.backend.donut_shop_backend.advice

import com.fasterxml.jackson.databind.ObjectMapper
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class LoggingAdvice {

  val log = LoggerFactory.getLogger(classOf[LoggingAdvice])


  //ProceedingJointPoint exposes the proceed(...) method in order ro support around advice in @Aj aspects
  def applicationLogger(pjp: ProceedingJoinPoint) = {
      val mapper = new ObjectMapper()
      val methodName = pjp.getSignature.getName
      val className = pjp.getTarget.getClass.toString
      val args = pjp.getArgs
      log.info(s"Method invoked $className $methodName() arguments: " +
        s"${mapper.writeValueAsString(args)}")
  }

}
