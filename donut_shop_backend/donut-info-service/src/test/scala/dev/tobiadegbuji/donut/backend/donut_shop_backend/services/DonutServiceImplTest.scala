package dev.tobiadegbuji.donut.backend.donut_shop_backend.services

import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.{Donut, DonutType, Nutrition}
import dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories.DonutRepo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.{BeforeEach, DisplayName, Test}
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.`then`
import org.mockito.{BDDMockito, InjectMocks, Mock}
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(Array(classOf[MockitoExtension]))
class DonutServiceImplTest {

  @Mock var donutRepo: DonutRepo = _
  @Mock var awsS3Service: AWSS3Service = _
  @InjectMocks var donutService: DonutServiceImpl = _

  var donut: Donut = _

  @BeforeEach
  def setUp(): Unit ={
    donut = new Donut(5L, "Glazed Deluxe", 1.50, DonutType.YEAST,new Nutrition())
  }

  @DisplayName("Test should return saved donut when given donut is saved")
  @Test
  def givenDonut_WhenDonutIsSaved_ThenSavedDonutIsReturned(): Unit = {
    //GIVEN
    BDDMockito.given(donutRepo.save(any(classOf[Donut]))).willReturn(donut)
    //WHEN
    val savedDonut = donutRepo.save(donut)
    //THEN
    assertEquals(5L, savedDonut.id, "saveDonut test failed")
    `then`(donutRepo).should().save(any(classOf[Donut]))
    `then`(donutRepo).shouldHaveNoMoreInteractions()
    `then`(awsS3Service).shouldHaveNoInteractions()
  }


}
