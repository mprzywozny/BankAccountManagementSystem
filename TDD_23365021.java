import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TDD_23365021 {
	
	//BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();

	/*
	 1. Requirement 1: Account Creation
	 Ensure the system allows 
	 the creation of a new bank account
	 with a specified initial balance. */
	
	 //* 1.1 Implement a successful account creation operation.
	@Test
	void testSuccessfulAccountCreation() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		boolean createdAccount = bank.createAccount(500, 1000.0); //create a bank account with account number 500 and balance €1000, which should be valid
		assertTrue(createdAccount); //If it's true and valid account was created, assert
	}
	
	 //* 1.2 Validate that the initial balance is a positive numeric value.
	@Test
	void testForNoNegativeBalance() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		boolean createdAccount = bank.createAccount(600, -1000.0); // create an account with negative balance
		assertFalse(createdAccount); //Make sure its false(account with negative balance is not created)
	}
	
	 //* 1.3 Implement a check to prevent the creation of duplicate accounts.
	@Test
	void testForNoDuplicates() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		bank.createAccount(700, 500.00); //create account 
		boolean createdAccount = bank.createAccount(700, 500.00); //create duplicate which has to be false
		assertFalse(createdAccount); //Assert false to make sure the duplicate account is not valid
	}

	/*
	2. Requirement 2: Deposit
	Enable users to deposit and withdraw funds from their bank account. */
	
	//* 2.1 Implement a successful deposit operation.
	
	//2 test cases: 1 with valid account and 1 with a non-existent account
	@Test
	void testSuccessfulDepositForExistentAccount() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		bank.createAccount(123, 250.0); //make a valid account with balance €250
		boolean deposited = bank.deposit(123, 250.0); //deposit another €250 into the account but store the result as boolean
		assertTrue(deposited); //If its valid, then the value is deposited into account
	}
	
	@Test
	void testDepositForNonExistentAccount() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		//This time don't create an account
		boolean deposited = bank.deposit(555, 200.0); //deposit into a non-existent account
		assertFalse(deposited); //If the account is invalid, the value is NOT deposited 
	}
	
	//* 2.2 Validate that deposited amounts are positive numeric values.
	
	//2 test cases: positive and negative deposit
	@Test
	void testPositiveDeposit() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		bank.createAccount(200, 400.0); //existing account
		boolean deposited = bank.deposit(200, 500.0); //deposit into account
		assertTrue(deposited); //If the deposited value is positive, the deposit is successful
	}
	
	@Test
	void testnegativeDeposit() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		bank.createAccount(333, 500.0); //existing account
		boolean deposited = bank.deposit(333, -123.50); //deposit negative amount into account
		assertFalse(deposited); //If the deposited value is negative, then it is NOT deposited
	}
	
	/*
	3. Requirement 3: Withdrawal
	Enable users to withdraw funds from their bank account.*/
	
	//* 3.1 Implement a successful withdrawal operation.
	//3 test cases: 1 with valid account, 1 with invalid account, 
	//1 with withdrawal amount greater than balance
	@Test
	void testSuccessfulWithdrawalForExistentAccount() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		bank.createAccount(999, 1500.0); //existing account
		boolean withdrawn = bank.withdraw(999, 1000.0); //withdraw from account
		assertTrue(withdrawn); //If its valid, then the value is withdrawn from account
	}
	
	@Test
	void testWithdrawalForNonExistentAccount() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		//Non-existent account
		boolean withdrawn = bank.withdraw(777, 100.0); //withdraw from account
		assertFalse(withdrawn); //If the account is invalid, the value is NOT withdrawn
	}
	
	//* 3.2 Validate that withdrawal amounts are positive numeric values.
	//2 test cases: positive and negative withdraw
	@Test
	void testPositiveWithdrawal() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		bank.createAccount(8000, 500.0); //existing account
		boolean withdrawn = bank.withdraw(8000, 300.0); //withdraw from account
		assertTrue(withdrawn); //If the withdrawn value is positive, the withdrawal is successful
	}
	
	@Test
	void testnegativeWithdrawal() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		bank.createAccount(9000, 500.0); //existing account
		boolean withdrawn = bank.withdraw(9000, -500.0); //withdraw negative amount from account
		assertFalse(withdrawn); //If the withdrawn value is negative, then withdrawal is NOT successful
	}
	
	/*
	4. Requirement 4: Overdraft Protection
	Prevent users from overdrawing their accounts 
	and reject withdrawal attempts exceeding
	the available balance.*/
	
	//* 4.1 Implement overdraft prevention to disallow negative balances.
	//* 4.2 Reject withdrawal attempts that exceed the available balance.
	//2 test cases: withdrawal that exceeds current balance, withdrawal of the exact same amount as balance
	@Test
	void testWithdrawalExceedingBalance() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		bank.createAccount(233, 100.0); //existing account
		boolean withdrawn = bank.withdraw(233, 200.0); //withdraw amount greater than balance
		assertFalse(withdrawn); //has to be false since that would result in negative balance
	}
	
	@Test
	void testWithdrawalSameAsBalance() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		bank.createAccount(678, 100.0); //existing account
		boolean withdrawn = bank.withdraw(678, 100.0); //withdraw the exact same amount as balance
		assertTrue(withdrawn); //should be true since it doesnt result in negative balance
	}
	
	
	/*
	5. Requirement 5: Balance Inquiry
	Allow users to check their account balance at any time.*/
	
	//* 5.1 Implement a successful balance inquiry operation.
	//3 test cases: existing and non-existing account, balance after transactions
	@Test
	void testBalanceInquiryForExistingAccount() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		bank.createAccount(7500, 1000.0); //existing account
		double balance = bank.getBalance(7500); //call the method
		assertEquals(1000.0, balance); //the balance stays the same
	}
	
	@Test
	void testBalanceInquiryForNonExistentAccount() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		//Non-existent account
		double balance = bank.getBalance(70); //call the method
		assertEquals(-1.0, balance); //the method should return -1
	}
	
	@Test
	void testBalanceInquiryAfterTransactions() {
		BankAccountManagementSystem_23365021 bank = new BankAccountManagementSystem_23365021();
		bank.createAccount(1900, 100.0); //existing account with initial balance of €100
		bank.deposit(1900, 900.0); //deposit into account
		bank.withdraw(1900, 500.0); //withdraw valid amount from account
		double balance = bank.getBalance(1900); 
		assertEquals((100.0+900.0-500.0), balance); //balance has to update accordingly
	}
}
