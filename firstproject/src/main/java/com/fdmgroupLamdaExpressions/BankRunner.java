package com.fdmgroupLamdaExpressions;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class BankRunner {

	public static void main(String[] args) {
	
		BankAccount account1= new BankAccount(12345678, 987654, "Mr J Smith", "savings", 1.0, 25362.91);
		BankAccount account2= new BankAccount(87654321, 234567, "Ms J Jones", "current/checking", 0.2, 550);
		BankAccount account3= new BankAccount(87654321, 946284, "Dr T Williams", "savings", 1.1, 4763.32);
		BankAccount account4= new BankAccount(94715453, 987654, "Ms S Taylor", "savings", 1.1, 10598.01);
		BankAccount account5= new BankAccount(16254385, 234567, "Mr P Brown", "current/checking", 0.2, -195.74);
		BankAccount account6= new BankAccount(38776543, 946284, "Ms F Davies", "current/checking", 0.2, -503.47);
		BankAccount account7= new BankAccount(87609802, 987654, "Mr B Wilson", "savings", 1.1, 2.5);
		BankAccount account8= new BankAccount(56483769, 234567, "Dr E Evans", "current/checking", 0.2, -947.72);
		
		
		//1.
		Function <BankAccount, String> getCustomerNameAndBalance= bankAccount -> bankAccount.getAccountHolder() +": "+ bankAccount.getBalance();
		
		String BankAccountNameAndBalance= getCustomerNameAndBalance.apply(account3);
		
		System.out.println(BankAccountNameAndBalance);
		
		
		//2.
		Function <BankAccount,Double> getAmountOfInterest= bankAccount -> (bankAccount.getBalance()* bankAccount.getInterestRate())/100;
		
		double amountOfInterest= getAmountOfInterest.apply(account2);
		
		System.out.println(amountOfInterest);
		
		//3.
		Function <BankAccount,Double> getAmountOfInterestIfOverdrawn= bankAccount -> bankAccount.getBalance()< 0 ? 0:(bankAccount.getBalance()* bankAccount.getInterestRate())/100;
		
		double AmountOfInterestIfOverdrawn= getAmountOfInterestIfOverdrawn.apply(account8);
		double AmountOfInterestIfOverdrawn2= getAmountOfInterestIfOverdrawn.apply(account2);
		
		System.out.println(AmountOfInterestIfOverdrawn);
		System.out.println(AmountOfInterestIfOverdrawn2);
		
		//4. 
		Predicate<BankAccount> getTypeOfAccount= bankAccount -> bankAccount.getAccountType().equals("current/checking")? true: false;
		
		boolean TypeOfAccount= getTypeOfAccount.test(account1);
		boolean TypeOfAccount2= getTypeOfAccount.test(account6);
		
		System.out.println(TypeOfAccount);
		System.out.println(TypeOfAccount2);
		
		//5. 
		Predicate<BankAccount> IfAccountOverdrawn= bankAccount -> bankAccount.getBalance()< 0 ? true:false;

		boolean overDrawn= IfAccountOverdrawn.test(account5);
		boolean overDrawn2= IfAccountOverdrawn.test(account7);
		
		System.out.println(overDrawn);
		System.out.println(overDrawn2);
		
		//6.
		BinaryOperator<BankAccount> getHighestBalance= (bankAccount1, bankAccount2) -> 
		bankAccount1.getBalance() > bankAccount2.getBalance() ? bankAccount1 : bankAccount2;
		
		BankAccount highestBalance= getHighestBalance.apply(account4, account3);

		System.out.println(highestBalance.getBalance());
//		
//		//7.
		Consumer<BankAccount> tenPoundFee= bankAccount -> {
			bankAccount.setBalance(bankAccount.getBalance()-10.00);
			};
		
		tenPoundFee.accept(account6);
		
		//8.
		BiConsumer <BankAccount,Double> withdrawMethod= (bankAccount, withdrawlAmount) -> System.out.println(bankAccount.getBalance()- withdrawlAmount);
				
		withdrawMethod.accept(account5, 50.00);
		
		//1.3 - 1
		ArrayList<BankAccount> bankAccounts= new ArrayList<BankAccount>();
		bankAccounts.add(account1);
		bankAccounts.add(account2);
		bankAccounts.add(account3);
		bankAccounts.add(account4);
		bankAccounts.add(account5);
		bankAccounts.add(account6);
		bankAccounts.add(account7);
		bankAccounts.add(account8);
		
		
		//1.3-2 , 3
		System.out.println("QUESTION 1.3 ");
		bankAccounts.forEach(tenPoundFee);
		Consumer <BankAccount> getAccountDetails= bankAccount -> System.out.println(bankAccount.getAccountHolder() + " "+ bankAccount.getAccountNumber() +" "+ bankAccount.getAccountType() + " "+  bankAccount.getBalance());
		getAccountDetails.accept(account4);
		
		//1.4
		System.out.println(" ");
		Predicate<BankAccount> IfAccountOverdrawnbyMoreThan500= bankAccount -> bankAccount.getBalance()< -500 ? true:false;
		bankAccounts.removeIf(IfAccountOverdrawnbyMoreThan500);
		bankAccounts.forEach(getAccountDetails);
		
		//1.3-5
		System.out.println(" ");// to create gap between printing
		Predicate<BankAccount> IfSavingsAccount= bankAccount -> bankAccount.getAccountType().equals("savings")? true:false;
		bankAccounts.removeIf(IfSavingsAccount);
		bankAccounts.forEach(getAccountDetails);
		
		
		///////1.4 Comparators
		System.out.println(" ");
		System.out.println("Exercise 1.4 adding back savings");
		bankAccounts.add(account1);
		bankAccounts.add(account7);
		bankAccounts.add(account3);
		bankAccounts.add(account4);
		bankAccounts.forEach(getAccountDetails);
		
		//1.4- 1
		System.out.println(" ");
		Comparator<BankAccount> sortByBalance= (bankAccounts1,bankAccounts2) -> ((Double)bankAccounts2.getBalance()).compareTo(bankAccounts1.getBalance()); // when using a double
		// needs a bracket around first and second one
		bankAccounts.sort(sortByBalance);
		bankAccounts.forEach(getAccountDetails);
		
		//1.4-2
		System.out.println(" ");
		Comparator<BankAccount> sortByType= (bankAccounts1,bankAccounts2) -> ((String)bankAccounts2.getAccountType()).compareTo(bankAccounts1.getAccountType()); // when using a String
		bankAccounts.sort(sortByType);
		bankAccounts.forEach(getAccountDetails);
		
		//1.4- 4
		System.out.println(" ");
		Comparator<BankAccount> sortByTypeThenBalance= sortByBalance.thenComparing(sortByType);
		bankAccounts.forEach(getAccountDetails);
		
		
		//1.5 Merge sort
		System.out.println(" ");
		Map<Integer,Integer> bankAccountCodes= new HashMap<>();
		BiFunction<Integer,Integer, Integer> addToCount= (currentValue,amountToAdd) -> currentValue + amountToAdd;

		for (BankAccount eachaccount : bankAccounts) {
			bankAccountCodes.merge(eachaccount.getBankCode(), 1, addToCount);
		}
		bankAccounts.forEach(bankAccount -> bankAccountCodes.merge(bankAccount.getBankCode(), 1, addToCount));
		System.out.println();
		///// part 2-
		Map<Integer,Double> bankAccountCodesSum= new HashMap<>();
		BiFunction<Double,Double, Double> addBankCodes= (bankcode1,bankcode2) ->  bankcode1+ bankcode2;
		
		for (BankAccount eachaccount : bankAccounts) {
			bankAccountCodesSum.merge(eachaccount.getBankCode(), eachaccount.getBalance(), addBankCodes);
		}
		
		System.out.println(bankAccountCodesSum);
	}

}
