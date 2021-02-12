//package dev.tobiadegbuji.donut.backend.donut_shop_backend.services
//
//import dev.tobiadegbuji.donut.backend.donut_shop_backend.exception.DonutNotFoundException
//import dev.tobiadegbuji.donut.backend.donut_shop_backend.model.{Donut, DonutType, Nutrition}
//import dev.tobiadegbuji.donut.backend.donut_shop_backend.repositories.DonutRepo
//import org.junit.jupiter.api.Assertions.{assertThrows, assertTrue}
//import org.junit.jupiter.api.{BeforeEach, DisplayName, Test}
//import org.mockito.Mockito
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
//
//import java.util
//import java.util.Optional
//
//class DonutServiceImplTest {
//
//  private var donutServiceImpl: DonutServiceImpl = null
//  private val donutRepoMock = Mockito.mock(classOf[DonutRepo])
//  private var donut: Donut = null
//  @BeforeEach
//  def setUp(): Unit ={
//    donut = new Donut(123L,"Glazed Donut", 3.99, DonutType.YEAST, new Nutrition(1,234))
//    donutServiceImpl = new DonutServiceImpl(donutRepoMock)
//  }
//
//  @Test
//  @DisplayName("Test should return a single Donut by ID")
//  def shouldReturnDonutById(): Unit ={
//    val donutServiceImpl = new DonutServiceImpl(donutRepoMock)
//    Mockito.when(donutRepoMock.findById(123L)).thenReturn(Optional.of(donut))
//  }
//
//  @Test
//  def donutIdNotFoundByRepository(): Unit ={
//    donut.id = -9999L
//    val donutNotFoundException =
//      assertThrows(classOf[DonutNotFoundException], () => donutServiceImpl.getDonutById(donut.id),
//        "DonutNotFoundException was not thrown")
//
//    assertTrue(donutNotFoundException.getMessage().equals("Donut with ID: " + donut.id + " was not found"))
//  }
//
//
//
//  @Test
//  @DisplayName("Test should return a list of Donuts")
//  def shouldReturnAllDonutsInDB(): Unit ={
//    val donutServiceImpl = new DonutServiceImpl(donutRepoMock)
//    val donut1 = new Donut(1,"Glazed Donut", 3.99, DonutType.YEAST, new Nutrition(1,234))
//    val donut2 = new Donut(2,"Spicy Churro", 2.99, DonutType.CHURRO, new Nutrition(2,125))
//    //Mockito.when(donutRepoMock.findAll()).thenReturn(new util.List[Donut] {})
//  }
//
//}
