package com.damilare.banking.model; 
import java.math.BigDecimal; 

public class Account { 

    private static int accountCounter = 100000; 
    private final String accountNumber;

    private final Customer owner; 

    private BigDecimal balance;

    private AccountStatus status; 

    public Account(Customer owner) { 

        if (owner == null) { 

            throw new IllegalArgumentException("Account owner cannot be null."); // Prevents creation of an account without an owner.

        } 

        this.accountNumber = generateAccountNumber(); // Generates a unique account number for the new account.

        this.owner = owner; // Associates the supplied Customer object with this account.

        this.balance = BigDecimal.ZERO; // Starts every newly created account with a zero balance.

        this.status = AccountStatus.ACTIVE; // New accounts begin in the ACTIVE state.

    } 
    private static String generateAccountNumber() { 

        accountCounter++; // Increments the shared account counter.

        return String.valueOf(accountCounter); // Converts the numeric account number into a String.

    }

    public String getAccountNumber() { // Provides read-only access to the account number.

        return accountNumber; // Returns the account number.

    } 

    public Customer getOwner() { // Provides access to the Customer who owns the account.

        return owner; // Returns the account owner.

    } 

    public BigDecimal getBalance() { // Provides read-only access to the current balance.

        return balance; // Returns the current account balance.

    } 

    public AccountStatus getStatus() { // Provides access to the account's current status.

        return status; // Returns the current account status.

    }

    public void block() { // Defines an operation for blocking the account.

        if (status == AccountStatus.CLOSED) { // Checks whether the account has already been permanently closed.

            throw new IllegalStateException("A closed account cannot be blocked."); // Prevents an invalid state transition.

        } 

        this.status = AccountStatus.BLOCKED; // Changes the account status to BLOCKED.

    } 

    public void activate() { // Defines an operation for activating the account.

        if (status == AccountStatus.CLOSED) { 

            throw new IllegalStateException("A closed account cannot be activated."); // Prevents a closed account from becoming active again.

        }

        this.status = AccountStatus.ACTIVE; // Changes the account status to ACTIVE.

    } 

    public void close() { 
        this.status = AccountStatus.CLOSED; 

    } 

}