package com.damilare.banking.model; 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections; 
import java.util.List; 

public class Account { 

    private static int accountCounter = 100000; // Stores the numeric portion used to generate account numbers.

    private final String accountNumber; // Stores the account number and prevents it from being changed.

    private final Customer owner; // Stores the Customer who owns this account.

    private BigDecimal balance; // Stores the current account balance.

    private AccountStatus status; // Stores the current account status.

    private final List<Transaction> transactions; // Stores all transactions belonging to this account.

    public Account(Customer owner) { // This the constructor used to create an account.

        if (owner == null) { // Checks whether a customer was supplied.

            throw new IllegalArgumentException("Account owner cannot be null."); // Prevents an account without an owner.

        } 

        this.accountNumber = generateAccountNumber(); // Generates the account number.

        this.owner = owner; // Associates the customer with the account.

        this.balance = BigDecimal.ZERO; // Starts the account with a zero balance.

        this.status = AccountStatus.ACTIVE; // New accounts begin in the ACTIVE state.

        this.transactions = new ArrayList<>(); // Creates an empty transaction list for the account.

    }

    private static String generateAccountNumber() { 

        accountCounter++; // Increases the shared account counter.

        return String.valueOf(accountCounter); // Converts the account number into a String.

    } 

    public String getAccountNumber() { // Provides read-only access to the account number.

        return accountNumber; // Returns the account number.

    }

    public Customer getOwner() { // Provides access to the account owner.

        return owner; // Returns the Customer who owns the account.

    } 

    public BigDecimal getBalance() { // Provides read-only access to the current balance.

        return balance; // Returns the current balance.

    } 

    public AccountStatus getStatus() { // Provides access to the account status.

        return status; // Returns the current account status.

    } 

    public List<Transaction> getTransactions() { // Provides read-only access to the account's transaction history.

        return Collections.unmodifiableList(transactions); // Prevents external code from modifying the internal transaction list.

    } 

    public void deposit(BigDecimal amount) { // This the operation for depositing money.

        ensureAccountIsActive(); // Ensures that only an active account can receive a deposit.

        validateAmount(amount); // Ensures that the supplied amount is valid.

        BigDecimal newBalance = balance.add(amount); // Calculates the new balance without modifying the current balance yet.

        Transaction transaction = new Transaction( // Creates the transaction record before changing the account state.

                TransactionType.DEPOSIT, // Records that this transaction is a deposit.

                amount, // Stores the deposited amount.

                newBalance // Stores the balance that will exist after the deposit.

        ); 

        balance = newBalance; // Updates the account balance after successful validation and transaction creation.

        transactions.add(transaction); // Adds the completed transaction to the account history.

    } 

    public void withdraw(BigDecimal amount) { // This the operation for withdrawing money.

        ensureAccountIsActive(); // Ensures that only an active account can perform a withdrawal.

        validateAmount(amount); // Ensures that the supplied amount is valid.

        if (amount.compareTo(balance) > 0) { // Checks whether the withdrawal amount exceeds the available balance.

            throw new IllegalStateException("Insufficient funds."); // Rejects the withdrawal when there is not enough money.

        } 

        BigDecimal newBalance = balance.subtract(amount); // Calculates the new balance without changing the current balance yet.

        Transaction transaction = new Transaction( // Creates the withdrawal transaction before changing the account state.

                TransactionType.WITHDRAWAL, // Records that this transaction is a withdrawal.

                amount, // Stores the withdrawn amount.

                newBalance // Stores the balance that will exist after the withdrawal.

        ); 

        balance = newBalance; // Updates the account balance.

        transactions.add(transaction); // Adds the withdrawal transaction to the transaction history.

    }

    private void validateAmount(BigDecimal amount) { // This a private method for validating monetary amounts.

        if (amount == null) { // Checks whether an amount was supplied.

            throw new IllegalArgumentException("Amount cannot be null."); // Rejects a null monetary amount.

        } 

        if (amount.compareTo(BigDecimal.ZERO) <= 0) { // Checks whether the amount is zero or negative.

            throw new IllegalArgumentException("Amount must be greater than zero."); // Rejects invalid monetary amounts.

        } 

    } 

    private void ensureAccountIsActive() { // This a private method for validating the account status.

        if (status != AccountStatus.ACTIVE) { // Checks whether the account is anything other than ACTIVE.

            throw new IllegalStateException("Account must be active to perform this operation."); // Prevents transactions on blocked or closed accounts.

        } 

    } 

    public void block() { // This an operation for blocking the account.

        if (status == AccountStatus.CLOSED) { // Checks whether the account has already been closed.

            throw new IllegalStateException("A closed account cannot be blocked."); // Prevents an invalid state transition.

        } 

        this.status = AccountStatus.BLOCKED; // Changes the account status to BLOCKED.

    } 

    public void activate() { // This an operation for activating the account.

        if (status == AccountStatus.CLOSED) { // Checks whether the account has already been closed.

            throw new IllegalStateException("A closed account cannot be activated."); // Prevents an invalid state transition.

        } 

        this.status = AccountStatus.ACTIVE; // Changes the account status to ACTIVE.

    } 

    public void close() { // This an operation for permanently closing the account.

        this.status = AccountStatus.CLOSED; // Changes the account status to CLOSED.

    } 

} 