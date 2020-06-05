package projekt.sysjm3.rest.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projekt.sysjm3.rest.Entity.Person;

/**
 * An interface that will get @Autowired to the service class, PersonService.
 * Implements findAll,findById,save,deleteById to create method for full CRUD.
 *
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
	
	Person findById(int id);
	
	
	
}
