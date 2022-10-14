package com.bridgelabz.addressbook;

public class AddressBookMain {

    public static void main(String[] args) {
        /**
         * creating object of AddressBook class
         * calling addContact method and displayContact
         */
        AddressBook addressBook = new AddressBook();
        addressBook.addContact();
        addressBook.displayContact();
    }
}