package projekt.sysjm3.rest.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projekt.sysjm3.rest.Entity.Person;
import projekt.sysjm3.rest.Service.PersonService;


@RestController
public class MainController {

	@Autowired
	PersonService personService;


	/**
	 * @return Returns All persons from ArrayList<Person>
	 */
	@GetMapping("/persons")
	private ArrayList<Person> getAllPersons() {
		return personService.getAllPersons();
	}

	/**
	 * Find specific person using Id.
	 * For example http://localhost:8080/persons/4
	 * will get you person with the Id 4.
	 * @param id
	 * @return Person by Id
	 */
	@GetMapping("/persons/{id}")
	private Person getPerson(@PathVariable("id") int id) {
		return personService.getPersonById(id);
	}

	/**
	 * Deletes a person, deletes by Id.
	 * @param id
	 */
	@DeleteMapping("/persons/{id}")
	private void deletePerson(@PathVariable("id") int id) {
		System.out.println("Delete");
		personService.delete(id);
	}

	/**
	 * @Postmapping handle HTTP POST requests.
	 * @param person
	 * @return
	 */
	@PostMapping("/persons")
	private int savePerson(@RequestBody Person person) {
		personService.saveOrUpdate(person);
	
		return person.getId();
	}

	/**
	 * Use to add or update an existing person in the database.
	 * @param id
	 * @param person
	 * @return
	 */
	@PutMapping("/persons/{id}")
	public ResponseEntity<?> updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
		personService.saveOrUpdate(person);
		return ResponseEntity.ok("PUT");

	}

}