package comfdmgroupExercise3;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@NamedQuery(
		name= "SavingsAccount.findAll",
		query= "SELECT s FROM SavingsAccount s")
@Entity
@DiscriminatorValue(value= "SAVINGS")
public class SavingsAccount extends BankAccount{
	
	
	public SavingsAccount() {}
	

	public SavingsAccount(double balance, BankCustomer customer) {
		super(balance, customer);
	}


	@Override
	public void withdraw(double withdrawAmount) {
		super.withdraw(withdrawAmount);
	}

}
