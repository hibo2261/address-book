package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
    public ArrayList<Contact> contactList = new ArrayList<>();

    public boolean addContact(Contact contact) {
        List<Contact> checkByName = searchByName(contact.getFirstName());
        for (Contact equalName : checkByName)
            if (equalName.equals(contact))
                return false;
        contactList.add(contact);
        return true;
    }
    // searching contacts by first name

    public List<Contact> searchByName(String name) {
        return contactList.stream().filter(person -> person.getFirstName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

    }
    // searching contact by city
    public List<Contact> searchByCity(String city) {
        return contactList.stream().filter(person -> person.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
    // searching contacts by state
    public List<Contact> searchByState(String state) {
        return contactList.stream().filter(person -> person.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    public void editContact(Contact current, Contact edit) {
        if (!contactList.contains(current))
            return;
        contactList.remove(current);
        contactList.add(edit);
    }

    public void deleteContact(Contact contacts) {
        contactList.remove(contacts);
    }

    @Override
    public String toString() {
        if (contactList.isEmpty())
            return "No contacts found!";
        StringBuilder result = new StringBuilder();
        for (Contact contacts : contactList) {
            result.append(" ").append(contacts);
        }
        return result.toString();
    }
    // adding a contact method
    public static Contact readContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter City: ");
        String city = sc.nextLine();
        System.out.print("Enter State: ");
        String state = sc.nextLine();
        System.out.print("Enter Zip Code: ");
        String zip = sc.next();
        sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.next();
        sc.nextLine();
        System.out.print("Enter Email ID: ");
        String email = sc.nextLine();
        return new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
    }

    public static void addressBookOptions(AddressBook addressBook) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n-------------------------- Address Book Contact Option --------------------------");
            System.out.println("1. Add contact details");
            System.out.println("2. Edit contact details");
            System.out.println("3. Delete contact details");
            System.out.println("4. Show contacts details");
            System.out.println("5. Back to main menu");
            System.out.print("Enter Your choice: ");
            int choice = sc.nextInt();
            // taking user input what user want to
            sc.nextLine();
            switch (choice) {
                case 1:
                    if (addressBook.addContact(readContact()))
                        System.out.println("Contact Added Successfully");
                    else
                        System.out.println("Contact Already Exists");
                    break;
                case 2:
                    System.out.print("Enter First name: ");
                    String name = sc.nextLine();
                    List<Contact> equalName = addressBook.searchByName(name);
                    if (equalName.isEmpty())
                        System.out.println("Data Not Found");
                    else if (equalName.size() == 1) {
                        addressBook.editContact(equalName.get(0), readContact());

                        System.out.println("Contact data modified");
                    } else {
                        equalName.forEach(x -> System.out.println(equalName.indexOf(x) + "  " + x.toString()));
                        System.out.print("Enter index to edit: ");
                        int i = sc.nextInt();
                        sc.nextLine();
                        addressBook.editContact(equalName.get(i), readContact());
                        System.out.println("Contact Modified");
                    }
                    break;
                case 3:
                    System.out.print("Enter First name to delete contact: ");
                    name = sc.nextLine();
                    equalName = addressBook.searchByName(name);
                    if (equalName.isEmpty())
                        System.out.println("Data Not Found");
                    else if (equalName.size() == 1) {
                        addressBook.deleteContact(equalName.get(0));
                        System.out.println("Contact data deleted");
                    } else {
                        equalName.forEach(x -> System.out.println(equalName.indexOf(x) + "  " + x.toString()));
                        System.out.print("Enter an index : ");
                        int index = sc.nextInt();
                        sc.nextLine();
                        addressBook.deleteContact(equalName.get(index));
                        System.out.println("Contact data deleted");
                    }
                    break;
                case 4:
                    System.out.println(addressBook.toString());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }
    // searching methods, taking user input through which user want to search
    public void searchByOptions() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.By name");
        System.out.println("2.By city");
        System.out.println("3.By state");
        System.out.println("4.Back");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();

        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                contactList.forEach(book -> searchByName(name).forEach(System.out::println));
                break;
            case 2:
                System.out.print("Enter city: ");
                String city = sc.nextLine();
                contactList.forEach(book -> searchByCity(city).forEach(System.out::println));
                break;
            case 3:
                System.out.print("Enter state: ");
                String state = sc.nextLine();
                contactList.forEach(book -> searchByState(state).forEach(System.out::println));
                break;
            case 4:
                return;
            default:
                System.out.println("INVALID CHOICE!");
        }
    }
}