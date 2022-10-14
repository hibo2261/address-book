package com.bridgelabz.addressbook;

import java.util.HashMap;
import java.util.Scanner;


public class AddressBookMain {

    HashMap<String,AddressBook> addressBookHashMap = new HashMap<>();

    public static void main(String[] args) {
        /**
         * creating object of AddressBook class calling addContact method and displayContact
         */
        AddressBook addressBook = new AddressBook();
        int choice;
        System.out.println("\n**** ADDRESSBOOK SIMULATION ****\n");

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please Choose an Option");
            System.out.println("1. ADD CONTACT \n2. DISPLAY CONTACT \n3. EDIT CONTACT \n4. DELETE CONTACT \n5. EDIT");
            choice = sc.nextInt();
            // performing task according to the choices entered by the User
            switch (choice) {
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    addressBook.displayContact();
                    break;
                case 3:
                    addressBook.editContact();
                    break;
                case 4:
                    addressBook.deleteContact();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice entered !!!!!!");
                    System.out.println("Kindly choose the correct Option");
                    break;
            }
        }
    }
}