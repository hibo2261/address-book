package com.bridgelabz.addressbook;

import java.util.Scanner;
public class AddressBook {

    Scanner sc = new Scanner(System.in);
    // creating object of Contact class
    Contact contact = new Contact();

    public void addContact() {
        /**
         * taking all details from user using scanner function
         */
        System.out.println("Enter the First Name :");
        contact.setFirstName(sc.next());
        System.out.println("Enter the Last Name :");
        contact.setLastName(sc.next());
        System.out.println("Enter the Address :");
        contact.setAdddress(sc.next());
        System.out.println("Enter the City :");
        contact.setCity(sc.next());
        System.out.println("Enter the State :");
        contact.setState(sc.next());
        System.out.println("Enter the Zip code :");
        contact.setZipCode(sc.next());
        System.out.println("Enter the Mobile Number :");
        contact.setMobileNumber(sc.next());
        System.out.println("Enter the Email id :");
        contact.setEmail(sc.next());
    }

    public void displayContact() {
        /**
         * showing data inputed by user in addContact method
         */
        System.out.println("----------------------");
        System.out.println("\n     New Contact    ");
        System.out.println("----------------------");
        System.out.println("First Name    : " + contact.getFirstName());
        System.out.println("Last Name     : " + contact.getLastName());
        System.out.println("Address       : " + contact.getAdddress());
        System.out.println("City          : " + contact.getCity());
        System.out.println("State         : " + contact.getState());
        System.out.println("Zip code      : " + contact.getZipCode());
        System.out.println("Mobile Number : " + contact.getMobileNumber());
        System.out.println("Email id      : " + contact.getEmail());

    }
}