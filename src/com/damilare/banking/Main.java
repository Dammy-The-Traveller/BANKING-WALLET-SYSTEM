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

        System.out.println("\nCustomer Lookup:");

        Customer foundCustomer = bank.findCustomer(
                customer1.getCustomerId()
        );

        if (foundCustomer != null) {

            System.out.println(
                    "Customer ID: " +
                    foundCustomer.getCustomerId()
            );

            System.out.println(
                    "Name: " +
                    foundCustomer.getFullName()
            );

            System.out.println(
                    "Email: " +
                    foundCustomer.getEmail()
            );

            System.out.println(
                    "Phone: " +
                    foundCustomer.getPhoneNumber()
            );
        }

        System.out.println("\nAccount Lookup:");

        Account foundAccount = bank.findAccount(
                account1.getAccountNumber()
        );

        if (foundAccount != null) {

            System.out.println(
                    "Account found: " +
                    foundAccount.getAccountNumber()
            );

            System.out.println(
                    "Owner: " +
                    foundAccount.getOwner().getFullName()
            );

            System.out.println(
                    "Balance: " +
                    foundAccount.getBalance()
            );
        }

        System.out.println("\nAll Customers:");

        for (Customer customer : bank.getCustomers().values()) {

            System.out.println(
                    customer.getCustomerId() +
                    " - " +
                    customer.getFullName()
            );
        }

        System.out.println("\nAll Accounts:");

        for (Account account : bank.getAccounts().values()) {

            System.out.println(
                    account.getAccountNumber() +
                    " - " +
                    account.getOwner().getFullName()
            );
        }
    }
}