package accounts.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import accounts.domain.Account;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes= {})
public class AccountControllerIntegrationTest {

	@LocalServerPort
    private int port;
	
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGetAccount() throws Exception {
		//first create account
		Account account = new Account("123",0.0,"Frank Brown");
		
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        restTemplate.exchange(
          createURLWithPort("/createaccount/123/0.0/Frank Brown"), HttpMethod.GET, entity, String.class);

        //test get customer
       ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/account/123"), HttpMethod.GET, entity, String.class);
        String expected = "{\"accountNumber\":\"123\",\"balance\":0.0,\"accountHolder\":\"Frank Brown\"}";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
	
}
