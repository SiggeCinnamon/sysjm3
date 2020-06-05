package projekt.sysjm3.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import projekt.sysjm3.rest.Controller.MainController;
import projekt.sysjm3.rest.Controller.WebController;
import projekt.sysjm3.rest.Entity.Person;
import projekt.sysjm3.rest.Repository.PersonRepository;

class RestApplicationTest {

	@Autowired
	private static WebController wb;

	@Autowired
	private static MainController mb;

	@Autowired
	private static PersonRepository personRepo;

	private static Person person;
	private static MockMvc mockie;

	@BeforeAll
	public static void beforeAllTests() {

		person = new Person('1', "Mattias", "A", 20, 'm', 860215, "City", "Country");
		personRepo.save(person);

		person = new Person('2', "Emir", "M", 20, 'm', 860215 + 1, "City", "Country");
		personRepo.save(person);

		person = new Person('3', "Tanvir", "S", 20, 'm', 860215 + 2, "City", "Country");
		personRepo.save(person);

		person = new Person('4', "Susanna", "M", 20, 'm', 860215 + 3, "City", "Country");
		personRepo.save(person);

		person = new Person('5', "Jonas", "Sjöstedt", 41, 'm', 860215 + 4, "Malmö", "Sweden");
		personRepo.save(person);

	}

	@Test
	void testGetRowsAfterDelete() {
		// delete last person
		personRepo.delete(person);

		assertEquals(3, personRepo.count());
	}

	@Test
	@DisplayName("Test1")
	public void testNumberOfRows() {
		assertTrue(personRepo.findAll().equals(3));
	}

	@Test
	@DisplayName("Test4")
	public void testIfRowExists() {
		assertFalse(personRepo.existsById(person.id));
	}

	@Test
	public void testGetExpectedRows() {
		assertEquals(4, personRepo.count());

	}

	@Test
	void contextLoads() {

		assertThat(wb).isNotNull();
		assertThat(mb).isNotNull();
	}

	@Test
	void testIndex() throws Exception {
		mockie.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
	}

	@Test
	void testAbout() throws Exception {
		mockie.perform(get("/about")).andExpect(status().isOk()).andExpect(view().name("about"));
	}

	@Test
	public void testFieldFirstName() throws Exception {
		Person person = new Person();
		person.setFirstName("MattiasAndersen");

		assertThat(person.getFirstName()).isEqualTo("MattiasAndersen");
	}


}
