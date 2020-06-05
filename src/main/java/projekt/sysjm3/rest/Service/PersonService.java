package projekt.sysjm3.rest.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekt.sysjm3.rest.Entity.Person;
import projekt.sysjm3.rest.Repository.PersonRepository;

/**
 * This class will get @autowired to the MainController
 * Makes the database fully CRUD.
 * 
 * The methodnames are pretty self-explanatory.
 *
 */
@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	/**
	 * Adds person to ArrayList<Person> with a loop via the CRUDrepo.
	 * @return persons
	 */
	public ArrayList<Person> getAllPersons() {
		ArrayList<Person> persons = new ArrayList<Person>();
		personRepository.findAll().forEach(person -> persons.add(person));
		return persons;
	}


	public Person getPersonById(int id) {
		return personRepository.findById(id);
	}

	public void saveOrUpdate(Person person) {
		personRepository.save(person);
	}

	public void delete(int id) {
		personRepository.deleteById(id);
	}

	public void updatePerson(Person person) {
		personRepository.save(person);

	}
}
