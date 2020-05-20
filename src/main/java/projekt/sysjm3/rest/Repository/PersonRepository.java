package projekt.sysjm3.rest.Repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projekt.sysjm3.rest.Entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
