package com.bridgelabz.addressbook;


public class AddressBookMain extends AddressBook {

    public static void main(String[] args) {
        System.out.println("Welcome to the Address book System project: ");
        AddressBook operations = new AddressBook();
        System.out.println("--------------------------Address Book-------------------------");
        addressBook(operations);
    }
}