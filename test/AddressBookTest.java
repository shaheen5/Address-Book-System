package com.addressbooksystem.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import Address_Book_Problem1.AddressBook;
import Address_Book_Problem1.MyAddressBookException;
import Address_Book_Problem1.Person;

import static Address_Book_Problem1.AddressBook.IOService.DB_IO;

import java.util.List;

public class AddressBookTest {
    AddressBook addressBook;
    @Before
    public void setUp(){
        addressBook = new AddressBook();
    }
    @Test
    public void givenPersonContactsInDB_WhenRetrived_ShouldMatchPersonCount(){
       	try{
		List<Person> contacts = addressBook.readDataFromDatabase(DB_IO);
            	Assert.assertEquals(5,contacts.size());
        } catch (MyAddressBookException e) {
           	e.printStackTrace();
        }
    }
}
