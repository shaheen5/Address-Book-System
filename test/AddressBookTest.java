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
    public void givenPersonDetails_ShouldAdd_ANewContact_ToAddressBook(){
        Person person1 = new Person("Bill","Gates","11 StreetCorner","Bangalore",
                "Karnataka","211001","9922123112",
                "billgates77@gmail.com");
        Person person2 = new Person("Sana","Shaikh","Gandhi nagar","Bangalore",
                "Karnataka","911001","9800983112",
                "billgates77@gmail.com");
        addressBook.contacts.add(person1);
        addressBook.contacts.add(person2);
        Assert.assertEquals(2,addressBook.contacts.size());
    }
    @Test
    public void givenPersonDetails_WhenEdited_ShouldReflect_InAddressBook(){
        addressBook.contacts.add(new Person("Manisha","Patil","Wakad Road",
                "Pune","Maharashtra","411012", "7721340090","mahisha@gmail.com"));
        addressBook.contacts.add( new Person ("Sana","Shaikh","Gandhi nagar","Bangalore",
                "Karnataka","911001","9800983112", "billgates77@gmail.com"));
        //edit address,city of given person
        Person editedPerson = addressBook.editPerson("Manisha","Shanti Nagar","Mumbai");
        Assert.assertTrue(editedPerson.getAddress().equals("Shanti Nagar") &&
                                     editedPerson.getCity().equals("Mumbai"));
    }
    @Test
    public void givenPersonDetails_WhenDeleted_ShouldReflect_InAddressBook(){
        addressBook.contacts.add(new Person("Manisha","Patil","Wakad Road",
                "Pune","Maharashtra","411012", "7721340090","mahisha@gmail.com"));
        addressBook.contacts.add( new Person ("Sana","Shaikh","Gandhi nagar","Bangalore",
                "Karnataka","911001","9800983112", "sana77@gmail.com"));
        //edit address,city of given person
        addressBook.deletePerson("Manisha");
        Assert.assertEquals(1,addressBook.contacts.size());
    }
    @Test
    public void givenPersonRecord_WhenDuplicate_ShouldNotAdd_InAddressBook(){
        addressBook.addPerson(new Person("Manisha","Patil","Wakad Road",
                "Pune","Maharashtra","411012", "7721340090","mahisha@gmail.com"));
        addressBook.addPerson( new Person ("Sana","Shaikh","Gandhi nagar","Bangalore",
                "Karnataka","911001","9800983112", "sana77@gmail.com"));
        addressBook.addPerson( new Person ("Sana","Shaikh","Gandhi nagar","Bangalore",
                "Karnataka","911001","9800983112", "sana77@gmail.com"));
        Assert.assertEquals(2,addressBook.contacts.size());
    }
    @Test
    public void givenCity_WhenSearchedForContacts_ShouldReturnContacts_InAddressBook(){
        Person person1 = new Person("Manisha","Patil",
                "Wakad Road", "Pune","Maharashtra","411012",
                "7721340090","mahisha@gmail.com");
        addressBook.personsInCity.put(person1,person1.getCity());
        Person person2 = new Person ("Sana","Shaikh",
                "Gandhi nagar","Bangalore", "Karnataka","911001","9800983112",
                "sana77@gmail.com");
        addressBook.personsInCity.put(person2,person2.getCity());
        Person person3 = new Person ("Sanaya","Irani",
                "Gokul nagar","Pune", "Maharashtra","911001","9800983112",
                "sana77@gmail.com");
        addressBook.personsInCity.put(person3,person3.getCity());
        List<Person> personsInCity = addressBook.getPersonsByCity("Pune");
        Assert.assertEquals(2,personsInCity.size());
    }
    @Test
    public void givenState_WhenSearchedForContacts_ShouldReturnContacts_InAddressBook(){
        Person person1 = new Person("Manisha","Patil",
                "Wakad Road", "Pune","Maharashtra","411012",
                "7721340090","mahisha@gmail.com");
        addressBook.personsInState.put(person1,person1.getState());
        Person person2 = new Person ("Sana","Shaikh",
                "Gandhi nagar","Bangalore", "Karnataka","911001","9800983112",
                "sana77@gmail.com");
        addressBook.personsInState.put(person2,person2.getState());
        Person person3 = new Person ("Sanaya","Irani",
                "Gokul nagar","Pune", "Maharashtra","911001","9800983112",
                "sana77@gmail.com");
        addressBook.personsInState.put(person3,person3.getState());
        List<Person> personsInCity = addressBook.getPersonsByState("Maharashtra");
        Assert.assertEquals(2,personsInCity.size());
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
