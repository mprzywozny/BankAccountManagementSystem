import java.util.HashMap;
public class BankAccountManagementSystem_23365021 {
	
	private HashMap<Integer, Double>accounts;
	
	public BankAccountManagementSystem_23365021() {
		this.accounts = new HashMap();
	}
	
	public HashMap getAccounts() { 
		return accounts; //Getter method to access account list
	}
	
	/*1. ACCOUNT CREATION*/
	//No duplicates and no negative balances
	public boolean createAccount(int accNumber, double balance) {
		if(accounts.containsKey(accNumber) || balance < 0) {
			return false; //Return false if there are duplicates or negative balance
		}
		
		accounts.put(accNumber, balance); //If the requirements are met, add account onto the hash map and return true
		return true;
	}
	

	/*2. DEPOSIT*/
	//Only for existing accounts and no negative deposits
	public boolean deposit(int accNumber, double amount) {
		if(!accounts.containsKey(accNumber) || amount < 0) {
			return false; //return false if the account doesnt exist or deposited amount is negative
		}
		
		double balance = accounts.get(accNumber);
		balance += amount;
		accounts.put(accNumber, balance); //if the deposited amount is valid, update balance accordingly
		
		return true; 
	}
	
	/*3. WITHDRAWAL*/
	//Only for existing accounts, no negative amounts withdrawn
	public boolean withdraw(int accNumber, double amount) {
		if(!accounts.containsKey(accNumber) || amount < 0) {
			return false; //return false if the account doesnt exist or deposited amount is negative
		}
		
		double balance = accounts.get(accNumber); //get balance
		
		/*4. OVERDRAFT PROTECTION*/
		//Withdrawn amount cannot exceed current balance
		if(amount > balance) {
			return false; //return false if withdrawn amount is greater than balance
		}
		
		balance -= amount;
		accounts.put(accNumber, balance); //if the withdrawn amount is valid, update balance accordingly

		
		return true;
		
	}
	
	/*
	5. BALANCE INQUIRY.*/
	//Only for existing accounts
	public double getBalance(int accNumber) {
		if(!accounts.containsKey(accNumber)) {
			System.out.printf("Account %d does not exist.", accNumber);
			return -1.0; //if account does not exist, return -1.0 and print a message
		}
		
		double balance = accounts.get(accNumber);
		return balance; //Otherwise return balance
		
	}
	
}
