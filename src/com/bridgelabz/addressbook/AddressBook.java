package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.tools.javac.Main;

public class AddressBook extends AddressBookMain{

    Scanner sc = new Scanner(System.in);

    ArrayList<Contact> contactArrayList = new ArrayList<Contact>();



    public void addContact() {
        // creating object of Contact class
        Contact contact = new Contact();
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
        // adding contact to Array List
        contactArrayList.add(contact);
    }

    public void displayContact() {
        /**
         * showing data inputed by user in addContact method
         */
        System.out.println("\n    Contact    ");
        System.out.println("----------------------");
        // displaying the data in the ArrayList through index value
        for(int i = 0; i < contactArrayList.size(); i++ ) {
            Contact contact = contactArrayList.get(i);
            // Printing the contact using toString method
            System.out.println(contact.toString());
        }
    }

    public void editContact() {
        // editing the existing contact using their First Name
        int choice;
        System.out.println("Enter the First Name of Contact to Edit");
        String firstName = sc.next();
        boolean isAvailable = false;
        for (Contact contact : contactArrayList) {
            if (contact.getFirstName().equals(firstName)) {
                isAvailable = true;
                do {
                    System.out.println("What you want to edit for the contact");
                    System.out.println(
                            "1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip Code\n7.Mobile Number\n8.Email id\n9.Exit\n10.Main Menu");
                    choice = sc.nextInt();
                    // choose options what you want to edit
                    switch (choice) {
                        case 1:
                            System.out.println("Enter the First Name :");
                            contact.setFirstName(sc.next());
                            break;
                        case 2:
                            System.out.println("Enter the Last Name :");
                            contact.setLastName(sc.next());
                            break;
                        case 3:
                            System.out.println("Enter the Address :");
                            contact.setAdddress(sc.next());
                            break;
                        case 4:
                            System.out.println("Enter the City :");
                            contact.setCity(sc.next());
                            break;
                        case 5:
                            System.out.println("Enter the State :");
                            contact.setState(sc.next());
                            break;
                        case 6:
                            System.out.println("Enter the Zip code :");
                            contact.setZipCode(sc.next());
                            break;
                        case 7:
                            System.out.println("Enter the Mobile Number :");
                            contact.setMobileNumber(sc.next());
                            break;
                        case 8:
                            System.out.println("Enter the Email id :");
                            contact.setEmail(sc.next());
                            break;
                        case 9:
                            System.exit(0);
                            break;
                        default:
                            break;
                    }
                    System.out.println("Updated Sucessfully ...");
                }
                while (choice != 10);
            }
        }
        if (isAvailable == false) {
            System.out.println("Contact is not Available \nTry again");
        }
    }



    public void deleteContact() {
        // taking first name of contact to be deleted
        System.out.println("Enter the First Name of Contact to Delete");
        String firstName = sc.next();
        boolean isAvailable = false;
        for(Contact contact : contactArrayList) {
            if(contact.getFirstName().equalsIgnoreCase(firstName)) {
                // removing the contact if first name matched
                isAvailable = true ;
                contactArrayList.remove(contact);
                System.out.println("Contact deleted sucessfully");
                break;
            }
        }
        if (isAvailable == false) {
            System.out.println("Sorry ! Data not found");
        }
    }
}