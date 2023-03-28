package com.orderhistory.orderhistory;

import com.orderhistory.orderhistory.controllers.OrderController;
import com.orderhistory.orderhistory.models.OrderHistory;
import com.orderhistory.orderhistory.services.OrderRepository;
import com.orderhistory.orderhistory.services.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class HistoryApplicationTests {
//	@Mock
//	private OrderService service;
//
//	@Mock
//	OrderController controller;
//
//	@Mock
//	OrderRepository repository;
//
//	@Test
//	public void testSave() throws Exception {
//		assertNotNull(controller);
//		assertNotNull(repository);
//		assertNotNull(service);
//		OrderHistory orderHistory = new OrderHistory();
//		orderHistory.setId(1L);
//		service.saveOrUpdate(orderHistory);
//		var order = repository.findById(1L).orElse(null);
//		assertNotNull(order);
//
////		// Step 3
////		OrderController orderController = new OrderController();
////		orderController.setService(orderService);
////
////		// Step 4
////		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
////
////		// Step 5
////		mockMvc.perform(post("/ordershistory")
////						.contentType(MediaType.APPLICATION_JSON)
////						.content("{ \"orderId\": 1, \"customerId\": 2, \"orderDate\": \"2023-03-26\" }"))
////				.andExpect(status().isOk())
////				.andExpect(jsonPath("$").value(orderHistory.getId()));
////
////		// Step 6
////		verify(orderService, times(1)).saveOrUpdate(orderHistory);
//	}

//	@InjectMocks
//	OrderController controller;
//
//	@Mock
//	OrderRepository repository;

//	@Test
//	public void testAddEmployee()
//	{
//		MockHttpServletRequest request = new MockHttpServletRequest();
//		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//		var elem = new OrderHistory();
//		var response = controller.save(elem);
//
//		assertEquals(elem.getId(), response);
//	}
}
