package com.damilare.banking.model;



public class Customer { 

    private final String customerId; 

    private String fullName; 

    private String email; 
    private String phoneNumber; 

    // Constructor used to create a Customer with initial information.
    public Customer(String customerId, String fullName, String email, String phoneNumber) { 

        this.customerId = customerId; 

        this.fullName = fullName; 

        this.email = email; 

        this.phoneNumber = phoneNumber;

    } 


//  a method for retrieving the customer's ID.
    public String getCustomerId() { 

        return customerId; 

    } 

    //  a method for retrieving the customer's full name.
    public String getFullName() { 

        return fullName; 

    } 

    //  a method for updating the customer's full name.
    public void setFullName(String fullName) { 

        this.fullName = fullName; 

    } 

    //  a method for retrieving the customer's email.
    public String getEmail() { 
        return email; 

    } 

    //  a method for updating the customer's email.
    public void setEmail(String email) { 

        this.email = email; 

    } 

    //  a method for retrieving the customer's phone number.
    public String getPhoneNumber() { 

        return phoneNumber; 

    } 

    //  a method for updating the customer's phone number.
    public void setPhoneNumber(String phoneNumber) { 

        this.phoneNumber = phoneNumber; 

    }

}