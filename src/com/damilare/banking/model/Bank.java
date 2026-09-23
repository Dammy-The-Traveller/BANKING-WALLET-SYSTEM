package com.damilare.banking.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Bank {

    private final Map<String, Customer> customers;

    private final Map<String, Account> accounts;

    public Bank() {
        customers = new HashMap<>();
        accounts = new HashMap<>();
    }

    public void addCustomer(Customer customer) {

        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }

        String customerId = customer.getCustomerId();

        if (customers.containsKey(customerId)) {
            throw new IllegalStateException(
                    "A customer with this ID already exists."
            );
        }

        customers.put(customerId, customer);
    }

    public Customer findCustomer(String customerId) {

        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException(
                    "Customer ID cannot be null or blank."
            );
        }

        return customers.get(customerId);
    }

    public void addAccount(Account account) {

        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }

        String accountNumber = account.getAccountNumber();

        if (accounts.containsKey(accountNumber)) {
            throw new IllegalStateException(
                    "An account with this account number already exists."
            );
        }

        accounts.put(accountNumber, account);
    }

    public Account findAccount(String accountNumber) {

        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException(
                    "Account number cannot be null or blank."
            );
        }

        return accounts.get(accountNumber);
    }

    public Map<String, Customer> getCustomers() {
        return Collections.unmodifiableMap(customers);
    }

    public Map<String, Account> getAccounts() {
        return Collections.unmodifiableMap(accounts);
    }
}