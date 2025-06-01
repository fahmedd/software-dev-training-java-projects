package comfdmgroupExercise3;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value= "CHECKINGS")
public class CheckingAccount extends BankAccount{

	public CheckingAccount() {
		
	}
	
	

	public CheckingAccount(double balance, BankCustomer customer) {
		super(balance, customer);
		
	}



	@Override
	public void withdraw(double withdrawAmount) {
		super.withdraw(withdrawAmount);
	}
	
	

}
