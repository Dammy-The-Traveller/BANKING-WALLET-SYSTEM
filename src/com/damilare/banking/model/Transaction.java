package com.damilare.banking.model;

import java.math.BigDecimal; 
import java.time.LocalDateTime; 

public class Transaction {

    private static long transactionCounter = 100000; // Stores the shared counter used to generate transaction IDs.

    private final String transactionId; // Stores the transaction ID and prevents it from being changed.

    private final LocalDateTime timestamp; // Stores the date and time when the transaction occurred.

    private final TransactionType type; // Stores the type of transaction.

    private final BigDecimal amount; // Stores the monetary amount of the transaction.

    private final BigDecimal balanceAfter; // Stores the account balance immediately after the transaction.

    public Transaction( // Defines the constructor used to create a transaction.

            TransactionType type, // Receives the type of transaction.

            BigDecimal amount, // Receives the transaction amount.

            BigDecimal balanceAfter // Receives the resulting account balance.

    ) { 

        if (type == null) { // Checks whether a transaction type was provided.

            throw new IllegalArgumentException("Transaction type cannot be null."); // Rejects a transaction without a type.

        } 

        if (amount == null) { // Checks whether the transaction amount was provided.

            throw new IllegalArgumentException("Transaction amount cannot be null."); // Rejects a transaction without an amount.

        } 

        if (amount.compareTo(BigDecimal.ZERO) <= 0) { // Checks whether the transaction amount is zero or negative.

            throw new IllegalArgumentException("Transaction amount must be greater than zero."); // Rejects invalid monetary amounts.

        } 

        if (balanceAfter == null) { // Checks whether the resulting balance was provided.

            throw new IllegalArgumentException("Resulting balance cannot be null."); // Rejects a transaction without a resulting balance.

        } 
        if (balanceAfter.compareTo(BigDecimal.ZERO) < 0) { // Checks whether the resulting balance is negative.

            throw new IllegalArgumentException("Resulting balance cannot be negative."); // Prevents an invalid transaction state.

        }

        this.transactionId = generateTransactionId(); // Generates and assigns a unique transaction ID.

        this.timestamp = LocalDateTime.now(); // Records the current date and time.

        this.type = type; // Stores the supplied transaction type.

        this.amount = amount; // Stores the supplied transaction amount.

        this.balanceAfter = balanceAfter; // Stores the balance after the transaction.

    } 

    private static String generateTransactionId() { // Defines the private method responsible for generating transaction IDs.

        transactionCounter++; // Increases the shared transaction counter.

        return "TXN" + transactionCounter; // Creates an ID such as TXN100001.

    } 

    public String getTransactionId() { // Provides read-only access to the transaction ID.

        return transactionId; // Returns the transaction ID.

    } 

    public LocalDateTime getTimestamp() { // Provides read-only access to the transaction timestamp.

        return timestamp; // Returns the transaction date and time.

    } 
    public TransactionType getType() { // Provides read-only access to the transaction type.

        return type; // Returns the transaction type.

    } 

    public BigDecimal getAmount() { // Provides read-only access to the transaction amount.

        return amount; // Returns the transaction amount.

    } 

    public BigDecimal getBalanceAfter() { // Provides read-only access to the resulting balance.

        return balanceAfter; // Returns the balance after the transaction.

    } 

} 