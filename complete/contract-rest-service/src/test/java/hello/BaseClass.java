package hello;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = ContractRestServiceApplication.class)
public abstract class BaseClass {

	@Autowired
	PersonRestController personRestController;

	@MockitoBean
	PersonService personService;

	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(personRestController);
		when(personService.findPersonById(1L))
				.thenReturn(new Person(1L, "foo", "bee"));
	}

}
