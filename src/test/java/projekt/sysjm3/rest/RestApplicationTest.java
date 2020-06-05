package projekt.sysjm3.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import projekt.sysjm3.rest.Entity.Person;
import projekt.sysjm3.rest.Repository.PersonRepository;
import projekt.sysjm3.rest.Service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApplicationTest {

	@Autowired
	PersonRepository pr;

	@Autowired
	PersonService ps;

	public Person person;
	public MockMvc mockie;

	@Test
	@DisplayName("Test 1")
	@Transactional
	public void testAllPersons() throws Exception {
		ArrayList<Person> persons = (ArrayList<Person>) pr.findAll();
		assertFalse(persons.isEmpty());
		assertEquals(4, persons.size());
	}

	@Test
	@DisplayName("Test 2")
	@Transactional
	public void testFindById() throws Exception {
		Person p = pr.findById(1);
		assertNotNull(p);
	}

	@Test
	@DisplayName("Test 3")
	@Transactional
	public void testDeletePerson() throws Exception {
		pr.deleteById(1);
		assertEquals(3,pr.findById(1));
	}

	@Test
	@DisplayName("Test 4")
	@Transactional
	public void contextLoads() {
		assertThat(pr).isNotNull();
	}

	@Test
	@DisplayName("Test 5")
	@Transactional
	public void testNumberOfRows() {
		assertTrue(pr.findAll().equals(4));
	}

	@Test
	@DisplayName("Test5")
	@Transactional
	public void testGetExpectedRows() {
		assertEquals(4, pr.count());
	}

	@Test
	@DisplayName("Test 6")
	@Transactional
	public void testFieldFirstName() throws Exception {
		Person person = new Person();
		person.setFirstName("MattiasAndersen");

		assertThat(person.getFirstName()).isEqualTo("MattiasAndersen");
	}
	
	
//	@Test
//	@DisplayName("Test 4")
//	public void test
//	private static WebController wc= new WebController();
//	
//	private static MainController mc = new MainController();
//	
//	private static PersonRepository personRepo;
//
//	private static Person person;
//
//	private static MockMvc mockie;
//	
//	
//
//	@BeforeClass
//	public void beforeAllTests() {
//
////		person = new Person(1, "Mattias", "Afg", 20, 'm', 860215, "City", "Country");
////		personRepo.save(person);
////
////		person = new Person(2, "Emir", "Mfg", 20, 'm', 860215, "City", "Country");
////		personRepo.save(person);
////
////		person = new Person(3, "Tanvir", "Sfg", 20, 'm', 860215, "City", "Country");
////		personRepo.save(person);
////
////		person = new Person(4, "Susanna", "Mfg", 20, 'm', 860215, "City", "Country");
////		personRepo.save(person);
////
////		person = new Person(5, "Jonas", "Sjöstedtfg", 41, 'm', 860215, "Malmö", "Sweden");
////		personRepo.save(person);}
//	@Test
//	@DisplayName("Test2")
//	void testGetRowsAfterDelete() {
//		// delete last person
//		personRepo.delete(person);
//
//		assertEquals(5, personRepo.count());
//	}
//	@Test
//	@DisplayName("Test6")
//	void testIndex() throws Exception {
//		mockie.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
//	}
//
//	@Test
//	@DisplayName("Test7")
//	public void testAbout() throws Exception {
//		mockie.perform(get("/about")).andExpect(status().isOk()).andExpect(view().name("about"));
//	}
//

}
