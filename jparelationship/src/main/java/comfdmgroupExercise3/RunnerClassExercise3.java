package comfdmgroupExercise3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RunnerClassExercise3 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jparelationship");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
	
		
		Person person1 = new Person("John", "Smith", "123 Fake Street");
		
		Compnay company1 = new Compnay("Google",123456789,"456 Real Street");
		
		BankCustomer customer1= new BankCustomer("123 Fake Street");
		BankCustomer customer2= new BankCustomer("456 Real Street");
		
		SavingsAccount bankaccount1 = new SavingsAccount(1234.50, customer1);
		CheckingAccount bankaccount2 = new CheckingAccount(-250.00, customer2);
		CheckingAccount bankaccount3 = new CheckingAccount(-525.25, customer1);
		SavingsAccount bankaccount4 = new SavingsAccount(10500.00, customer2);
		
		entityTransaction.begin();
		
		entityManager.persist(bankaccount1);
		entityManager.persist(bankaccount2);
		entityManager.persist(bankaccount3);
		entityManager.persist(bankaccount4);
		
		entityTransaction.commit();
		
		
		
		//Query
		//Returns list of bank account instances-if SEQUENCED AND LOOKING FOR ALL- dont need param
		System.out.println("DISPLAYS BANK ACCOUNTS");
		List<BankAccount> accounts= entityManager.createNamedQuery("BankAccount.findAll",BankAccount.class).getResultList();
		accounts.forEach(account -> System.out.println(account.getId() + " " + account.getCustomer()+ " " +account.getBalance()));
		
		
		//Queries
		//Returns a company instance
		System.out.println("DISPLAYS Companies");
		Compnay companyCustomer = entityManager.createNamedQuery("Company.findByName",  Compnay.class).setParameter("CName", "Google").getSingleResult();
		System.out.println(companyCustomer.getId()+ " " +companyCustomer.getName()+ " " + companyCustomer.getAddress()+ " " + companyCustomer.getAbn() + " " + companyCustomer.getAccounts());
		
		
		//Return a list of saving instances
		System.out.println("DISPLAYS BANK ACCOUNTS");
		List<SavingsAccount> savingsAccounts= entityManager.createNamedQuery("SavingsAccount.findAll", SavingsAccount.class).getResultList();
		savingsAccounts.forEach(account -> account.setBalance(account.getBalance()+100));
		
		for (SavingsAccount account : savingsAccounts) {
			entityTransaction.begin();
			entityManager.merge(account);
			entityTransaction.commit();
		}
		
			
		entityManager.close();
		entityManagerFactory.close();


	}

}
