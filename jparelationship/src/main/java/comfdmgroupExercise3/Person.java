package comfdmgroupExercise3;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person extends BankCustomer{
	
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME", nullable=false)
	private String LastName;
	
	public Person() {
		
	}

	public Person(String firstName, String lastName, String address) {
		super(address);
		this.firstName = firstName;
		LastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	
}
