package com.damilare.banking.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {

    private final List<Customer> customers;

    private final List<Account> accounts;

    public Bank() {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }

        customers.add(customer);
    }

    public void addAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }

        accounts.add(account);
    }

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }
}