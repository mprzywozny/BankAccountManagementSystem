# TDD-Based Bank Account Management System 

This project is a Java-based Bank Account Management System developed using Test-Driven Development (TDD) principles. It forms part of a university assignment for CS4004 – Software Testing & Inspection at the University of Limerick.

Features:
  -Account Creation: Prevents duplicate accounts and ensures valid, non-negative balances.
  -Deposits & Withdrawals: Allows funds to be deposited/withdrawn only under valid conditions.
  -Overdraft Protection: Automatically blocks withdrawals that exceed the available balance.
  -Balance Inquiry: Returns the account balance or -1.0 for invalid accounts.
  -Data Flow Testing:
    -DU-Pair coverage for the deposit method.
    -Definition coverage for the withdraw method.
    
Structure:
  -BankAccountManagementSystem_23365021.java: Main class implementing account operations.
  -TDD_23365021.java: JUnit 5 test suite developed through TDD for all system functionalities.

How to Run:
  -Compile both .java files.
  -Run the test class (TDD_23365021.java) using a JUnit 5-compatible IDE or build tool.
