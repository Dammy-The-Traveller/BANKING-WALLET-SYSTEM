package com.damilare.banking; 

import com.damilare.banking.model.Customer; 

public class Main { 

    public static void main(String[] args) {

        Customer customer = new Customer( 
                "CUS001", //  unique ID.
                "Damilare Adebesin", //  full name.
                "damilare@example.com", //  email address.
                "08012345678" //  phone number.
        ); 

        System.out.println("Customer Information");

        System.out.println("--------------------"); 

        System.out.println("Customer ID: " + customer.getCustomerId()); 

        System.out.println("Full Name: " + customer.getFullName()); 

        System.out.println("Email: " + customer.getEmail()); 

        System.out.println("Phone: " + customer.getPhoneNumber()); 

        customer.setEmail("newemail@example.com"); 

        System.out.println("\nUpdated Email: " + customer.getEmail()); 

    } 

} 