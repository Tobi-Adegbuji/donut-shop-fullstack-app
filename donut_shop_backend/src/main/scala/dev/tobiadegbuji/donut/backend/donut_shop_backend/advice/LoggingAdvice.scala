//package dev.tobiadegbuji.donut.backend.donut_shop_backend.advice
//
//import com.fasterxml.jackson.databind.ObjectMapper
//import lombok.Data
//import org.aspectj.lang.ProceedingJoinPoint
//import org.aspectj.lang.annotation.{Aspect, Before}
//import org.slf4j.LoggerFactory
//import org.springframework.context.annotation.EnableAspectJAutoProxy
//import org.springframework.stereotype.Component
//
//@Aspect //Cross cutting concerns are ket within aspects
//@EnableAspectJAutoProxy //Enables Spring AOP for Advice
//@Data
//@Component
//class LoggingAdvice {
//
//  //Advice: is what should be shown. Two main types are before and after
//  @Before("execution(* dev.tobiadegbuji.donut.backend.BootstrapData.bootstrap())") //pointcut -> where you want to show advice
//  def log = {
//  println("Printed Donuts")
//  }
//
//}
