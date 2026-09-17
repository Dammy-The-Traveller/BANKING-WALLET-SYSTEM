package com.damilare.banking;

import com.damilare.banking.model.Account;
import com.damilare.banking.model.Bank;
import com.damilare.banking.model.Customer;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();

        Customer customer1 = new Customer(
                "Damilare Adebesin",
                "damilare@example.com",
                "08012345678"
        );

        Customer customer2 = new Customer(
                "John Doe",
                "john@example.com",
                "08098765432"
        );

        Account account1 = new Account(customer1);
        Account account2 = new Account(customer2);

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        bank.addAccount(account1);
        bank.addAccount(account2);

        System.out.println("Customers: " + bank.getCustomers().size());
        System.out.println("Accounts: " + bank.getAccounts().size());

        System.out.println("\nCustomer List:");

        for (Customer customer : bank.getCustomers()) {
            System.out.println(
                    customer.getCustomerId() + " - " +
                    customer.getFullName()
            );
        }

        System.out.println("\nAccount List:");

        for (Account account : bank.getAccounts()) {
            System.out.println(
                    account.getAccountNumber() + " - " +
                    account.getOwner().getFullName()
            );
        }
    }
}