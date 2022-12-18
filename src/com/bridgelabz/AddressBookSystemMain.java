package com.bridgelabz;

import java.util.*;
import java.util.Scanner;

public class AddressBookSystemMain {
    public static void main(String[] args) {
        System.out.println("Welcome To AddressBook management System");
        Scanner sc = new Scanner(System.in);
        AddressBookSystemDetails addressBook = new AddressBookSystemDetails();
        Map<String, AddressBookSystemDetails> addressBookMap = new HashMap<String, AddressBookSystemDetails>();

        while (true) {
            System.out.println("\nWelcome to Address Book System");
            System.out.println("1. New Address Book \n2. Select Address Book \n3. Delete Address Book \n4. Search Contact Data \n5.View Contact Data \n6.Count Contacts\n7. Exit");
            System.out.print("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name of new Address Book: ");
                    String bookName = sc.next();
                    sc.nextLine();
                    addressBookMap.put(bookName, new AddressBookSystemDetails());// adding bookName as a key and value is allocating
                    // memory for address book obj
                    AddressBookSystemDetails.addressBookOptions(addressBookMap.get(bookName));// call address book option method with
                    // passing key of hashmap
                    break;
                case 2:
                    System.out.println("List of available Address Book : ");
                    Set<String> keys = addressBookMap.keySet();// retrived keys from hashmap to show address book list
                    Iterator<String> i = keys.iterator();
                    while (i.hasNext()) {
                        System.out.println(i.next());
                    }
                    System.out.println("Enter Address Book name you want to Open : ");
                    String name = sc.nextLine();
                    System.out.println("Current Address Book is : " + name);
                    AddressBookSystemDetails.addressBookOptions(addressBookMap.get(name));// call method with passing address book name
                    break;
                case 3:
                    System.out.println("Enter Address Book name to be delete: ");
                    name = sc.nextLine();
                    addressBookMap.remove(name);// delete hashmap using remove fun
                    break;
                case 4:
                    System.out.println("Welcome to the search option:");
                    addressBook.searchByOptions();
                case 5:
                    System.out.println("Welcome to view By Option:");
                    addressBook.viewByOption(addressBookMap);
                    break;
                case 6:
                    System.out.println("Welcome to the counter");
                    addressBook.countByOption();
                    break;
                case 7 : FileIO fileIO = new FileIO();
                    fileIO.writeData(addressBookMap);
                    break;
                case 8 : FileIO fileIORead = new FileIO();
                    System.out.println(fileIORead.readData());
                    break;
                case 9:
                    sc.close();
                    return;
                default:
                    System.out.println("You Entered Invalid Choice....!");
                    break;
            }
        }
    }
}