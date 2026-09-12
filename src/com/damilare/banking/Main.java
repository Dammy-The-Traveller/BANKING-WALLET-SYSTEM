package com.damilare.banking; 

import com.damilare.banking.model.Customer; 

public class Main { 

    public static void main(String[] args) {

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
        System.out.println("Customer Information");

        System.out.println("--------------------"); 

        System.out.println("Customer 1 ID: " + customer1.getCustomerId()); // Displays the automatically generated first customer ID.

        System.out.println("Customer 1 Name: " + customer1.getFullName()); // Displays the first customer's name.

        System.out.println(); // Prints a blank line to separate the customers.

        System.out.println("Customer 2 ID: " + customer2.getCustomerId()); // Displays the automatically generated second customer ID.

        System.out.println("Customer 2 Name: " + customer2.getFullName()); 

    } 

} 