package com.damilare.banking; 
import com.damilare.banking.model.Account;
import com.damilare.banking.model.Customer; 

public class Main { 

    public static void main(String[] args) {

        Customer customer = new Customer( 

                "Damilare Adebesin", 

                "damilare@example.com", 

                "08012345678" 

        ); 

        Account account = new Account(customer);

        System.out.println("================================"); 

        System.out.println("       ACCOUNT INFORMATION       ");

        System.out.println("================================"); 

        System.out.println("Customer ID: " + customer.getCustomerId()); 

        System.out.println("Account Number: " + account.getAccountNumber());

        System.out.println("Account Holder: " + account.getOwner().getFullName()); 

        System.out.println("Balance: " + account.getBalance());

        System.out.println("Status: " + account.getStatus()); 

        account.block(); 

        System.out.println("\nAfter blocking account:"); 
        System.out.println("Status: " + account.getStatus()); 

        account.activate();

        System.out.println("\nAfter activating account:");

        System.out.println("Status: " + account.getStatus()); 

    } 

} 