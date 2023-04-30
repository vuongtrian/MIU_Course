package accounts.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import accounts.repositories.AccountRepository;
import accounts.service.AccountDTO;
import accounts.service.AccountService;



@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

	@Autowired
	MockMvc mock;

	@MockBean
	AccountService accountService;
	
	@MockBean
	AccountRepository repository;

	@Test
	public void testGetAccount() throws Exception {
		Mockito.when(accountService.getAccount("123")).thenReturn(new AccountDTO("123",0.0,"Frank Brown"));
		mock.perform(MockMvcRequestBuilders.get("/account/123"))
		  .andExpect(status().isOk())
		  .andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value("123"))
		  .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(0.0))
		  .andExpect(MockMvcResultMatchers.jsonPath("$.accountHolder").value("Frank Brown"));

	}
	
//	@Test
//	public void testDeleteCustomerByCustomerNumber() throws Exception {
//		mock.perform(MockMvcRequestBuilders.delete("/customer/{id}",1))
//		  .andExpect(status().isOk());
//		
//		verify(accountService, times(1)).removeCustomer("1");
//	}
//
//	@Test
//	public void testAddCustomer() throws Exception {
//		Customer customer = new Customer(1L, "Frank Brown", "fbrown@gmail.com");
//		mock.perform(MockMvcRequestBuilders.post("/customer")
//	      .content(asJsonString(customer))
//	      .contentType(MediaType.APPLICATION_JSON))
//          .andExpect(status().isOk());
//		
//		verify(accountService, times(1)).addCustomer(customer);
//	}
//
//	@Test
//	public void testUpdateCustomer() throws Exception {
//		Customer customer = new Customer(1L, "Frank Brown", "fbrown@gmail.com");
//		mock.perform(MockMvcRequestBuilders.put("/customer")
//	      .content(asJsonString(customer))
//	      .contentType(MediaType.APPLICATION_JSON))
//          .andExpect(status().isOk());
//		
//		verify(accountService, times(1)).updateCustomer(customer);
//	}
//
//	@Test
//	public void testGetallCustomers() throws Exception {
//		Customers customers= new Customers();
//		customers.addCustomer(new Customer(1L, "Frank Brown", "fbrown@gmail.com"));
//		customers.addCustomer(new Customer(2L, "John Doe", "jdoe@gmail.com"));
//		Mockito.when(accountService.getAllCustomers()).thenReturn(customers);
//
//		mock.perform(MockMvcRequestBuilders.get("/customers"))
//		  .andExpect(status().isOk())
//          .andExpect(MockMvcResultMatchers.jsonPath("$.customers").isArray())
//          .andExpect(MockMvcResultMatchers.jsonPath("$.customers", hasSize(2)))
//		  .andExpect(MockMvcResultMatchers.jsonPath("$.customers[0].customerNumber").value(1L))
//		  .andExpect(MockMvcResultMatchers.jsonPath("$.customers[0].name").value("Frank Brown"))
//		  .andExpect(MockMvcResultMatchers.jsonPath("$.customers[0].email").value("fbrown@gmail.com"));
//		
//		verify(accountService, times(1)).getAllCustomers();
//	}
//
//	public static String asJsonString(final Object obj) {
//	    try {
//	        return new ObjectMapper().writeValueAsString(obj);
//	    } catch (Exception e) {
//	        throw new RuntimeException(e);
//	    }
//	}
}
