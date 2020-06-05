package projekt.sysjm3.rest.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Person {

	@Id
	public int id;
	public String lastName;
	public String firstName;
	public int age;
	public char gender;
	public long ssn;
	public String cityOfResidence;
	public String countryOfResicence;

	
	public Person(int id, String lastName, String firstName, int age, char gender, long ssn, String cityOfResidence,
			String countryOfResicence) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.gender = gender;
		this.ssn = ssn;
		this.cityOfResidence = cityOfResidence;
		this.countryOfResicence = countryOfResicence;
	}


	public String getFirstName() {
		return firstName;
	}


	public Person() {

	}

	public void setId(int id) {
		this.id = id;

	}

	public void setCountryOfResidence(String country) {
		this.countryOfResicence = country;

	}

	public void setCityOfResidence(String city) {
		this.cityOfResidence = city;

	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;

	}

	public void setGender(char gender) {
		this.gender = gender;

	}

	public void setAge(int age) {
		this.age = age;

	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;

	}

	public int getId() {

		return id;
	}




}
