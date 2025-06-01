package comfdmgroupExercise3;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BANK_CUSTOMER")
@Inheritance(strategy = InheritanceType.JOINED)
public class BankCustomer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "BC_SEQ_GNTR")
	@SequenceGenerator(name= "BC_SEQ_GNTR", sequenceName= "BC_SEQ")
	@Column(name= "CUSTOMER_ID")
	private int id;
	
	@Column(name="ADDRESS", nullable= false)
	private String address;
	
	@OneToMany(mappedBy= "customer")
	private List<BankAccount> accounts;
	
	public BankCustomer() {}
	
	
	public BankCustomer(String address) {
		this.address = address;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	
	

}
