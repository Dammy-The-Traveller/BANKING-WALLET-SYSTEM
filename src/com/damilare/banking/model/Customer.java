package com.damilare.banking.model; 

public class Customer { 

    private static int customerCounter = 1000; 
    private final String customerId; 

    private String fullName; 

    private String email; 

    private String phoneNumber; 

    public Customer(String fullName, String email, String phoneNumber) { 

        if (fullName == null || fullName.isBlank()) { 

            throw new IllegalArgumentException("Full name cannot be empty."); 

        }

        if (email == null || email.isBlank()) { 

            throw new IllegalArgumentException("Email cannot be empty."); 

        } 

        if (phoneNumber == null || phoneNumber.isBlank()) { 

            throw new IllegalArgumentException("Phone number cannot be empty."); 

        } 

        this.customerId = generateCustomerId(); 

        this.fullName = fullName.trim(); 

        this.email = email.trim(); 

        this.phoneNumber = phoneNumber.trim(); 

    } 

    private static String generateCustomerId() {

        customerCounter++; // Increases the counter before assigning the new customer ID.

        return "CUS" + customerCounter; 

    } 

    public String getCustomerId() { // Provides controlled read-only access to the customer ID.

        return customerId; 

    } 

    public String getFullName() { // Provides access to the customer's full name.

        return fullName; 

    }

    public void setFullName(String fullName) { // Provides controlled access for changing the customer's name.

        if (fullName == null || fullName.isBlank()) {

            throw new IllegalArgumentException("Full name cannot be empty.");

        } 

        this.fullName = fullName.trim(); 
    } 
    public String getEmail() { // Provides access to the customer's email.

        return email; 
    } 

    public void setEmail(String email) { // Provides controlled access for changing the customer's email.

        if (email == null || email.isBlank()) { 

            throw new IllegalArgumentException("Email cannot be empty."); 

        } 

        this.email = email.trim(); 

    } 

    public String getPhoneNumber() { // Provides access to the customer's phone number.

        return phoneNumber; 

    } 

    public void setPhoneNumber(String phoneNumber) { // Provides controlled access for changing the customer's phone number.

        if (phoneNumber == null || phoneNumber.isBlank()) { 

            throw new IllegalArgumentException("Phone number cannot be empty."); 

        } 

        this.phoneNumber = phoneNumber.trim(); 

    } 

} 