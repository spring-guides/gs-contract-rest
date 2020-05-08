package hello;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(MockitoJUnitRunner.class)
public abstract class BaseClass {

	@InjectMocks PersonRestController personRestController;
	@Mock PersonService personService;

	@Before public void setup() {
		RestAssuredMockMvc.standaloneSetup(personRestController);

		Mockito.when(personService.findPersonById(1L))
				.thenReturn(new Person(1L, "foo", "bee"));
	}

}

