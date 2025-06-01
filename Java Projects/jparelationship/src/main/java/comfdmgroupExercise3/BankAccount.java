package comfdmgroupExercise3;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@NamedQuery(
		name= "BankAccount.findAll",
		query= "SELECT b from BankAccount b WHERE b.id = :bankId"
		)
@Entity
@Table(name="BANK_ACCOUNT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "BA_SEQ_GNTR")
	@SequenceGenerator(name= "BA_SEQ_GNTR", sequenceName= "BA_SEQ")
	@Column(name="ACCOUNT_ID")
	private int id;
	
	@Column(name="BALANCE")
	private double balance;
	
	//@Column(name="FK_CUSTOMER_ID")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private BankCustomer customer;

	
	public BankAccount() {
	}
	
	
	public BankAccount(double balance ,BankCustomer customer) {
		this.balance = balance;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public BankCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(BankCustomer customer) {
		this.customer = customer;
	}
	
	public void deposit(double depositAmount) {
		balance= balance + depositAmount;
	}
	
	public void withdraw(double withdrawAmount) {
		balance= balance- withdrawAmount;
	}
	

}
