package Address_Book_Problem;

import java.util.*;

class Person{
	String firstName;
	String lastName;
	String address;
   String city;
   String state;
   String zipCode;
   String phoneNumber;
   String email;
    
	public Person(String firstName, String lastName, String address, String city, String state, String zipCode,
			String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "[FirstName=" + firstName + ", LastName=" + lastName + ", Address=" + address + ", City=" + city
				+ ", State=" + state + ", ZipCode=" + zipCode + ", PhoneNumber=" + phoneNumber + ", Email=" + email
				+ "]";
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

class AddressBook{
	ArrayList<Person>contacts;

	public AddressBook() {
		contacts=new ArrayList<Person>();
	}

	public ArrayList<Person> getContacts() {
		return contacts;
	}

	@Override
	public String toString() {
		return "AddressBook [contacts=" + contacts + "]";
	}

	public void addPerson(Scanner sc) {
		System.out.println("\nEnter First name :- ");
		sc.nextLine();
		String firstName=sc.nextLine();
		while(!firstName.matches("[A-Za-z]{3}[A-Za-z]*")) {
			System.out.println("Minimum 3 characters required !\nEnter First name :- ");
		    firstName=sc.nextLine();
		}
		System.out.println("Enter Last name :- ");
		String lastName=sc.nextLine();
		while(!lastName.matches("[A-Za-z]{3}[A-Za-z]*")) {
			System.out.println("Minimum 3 characters required !\nEnter Last name :- ");
		    lastName=sc.nextLine();
		}
		System.out.println("Enter Address :- ");
		String address=sc.nextLine();
		while(!address.matches("^[a-zA-Z\\d\\s\\-\\_]*$")) {
			System.out.println("INVALID! \nEnter Address :- ");
			address=sc.nextLine();
		}
		System.out.println("Enter City :- ");
		String city=sc.nextLine();
		while(!city.matches("^[a-zA-Z]*$")) {
			System.out.println("INVALID!\nEnter City :- ");
			city=sc.nextLine();
		}
		System.out.println("Enter State :- ");
		String state=sc.nextLine();
		while(!state.matches("^[a-zA-Z\\s]*$")) {
			System.out.println("INVALID!\nEnter State :- ");
			state=sc.nextLine();
		}
		System.out.println("Enter Zip code :- ");
		String zipCode=sc.nextLine();
		while(!zipCode.matches("\\d{6}")) {
			System.out.println("INVALID!!\nEnter Zip code :- ");
			zipCode=sc.nextLine();
		}
		System.out.println("Enter Contact number :- ");
		String phoneNumber=sc.nextLine();
		while(!phoneNumber.matches("^[6-9]{1}\\d{9}")) {
			System.out.println("INVALID !\nEnter Contact number :- ");
			phoneNumber=sc.nextLine();
		}
		System.out.println("Enter Email Id:-");
		String email=sc.nextLine();
		String EMAIL_REGEX ="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		while(!email.matches(EMAIL_REGEX)) {
			System.out.println("INVALID EMAIL ID !\n Enter Valid Email Id:-");
		    email=sc.nextLine();
		}
		Person person=new Person(firstName,lastName,address,city,state,zipCode,phoneNumber,email);
		contacts.add(person);
		System.out.println("Added:- "+person);
	}

	public void editPerson(Scanner sc) {
		System.out.println("Enter name of the person to edit :");
		sc.nextLine();
		String name=sc.nextLine();
		int flag=0;
		for(int i=0;i<contacts.size();i++) {
			Person person=contacts.get(i);
			if(name.equals(person.firstName)) {
				System.out.println("Enter address :- ");
				String address=sc.nextLine();
				while(!address.matches("^[a-zA-Z\\d\\s\\-\\_]*$")) {
					System.out.println("INVALID! \nEnter Address :- ");
					address=sc.nextLine();
				}
				person.setAddress(address);
				System.out.println("Enter city :- ");
				String city=sc.nextLine();
				while(!city.matches("^[a-zA-Z]*$")) {
					System.out.println("INVALID!\nEnter City :- ");
					city=sc.nextLine();
				}
				person.setCity(city);
				System.out.println("Enter state :- ");
				String state=sc.nextLine();
				while(!state.matches("^[a-zA-Z\\s]*$")) {
					System.out.println("INVALID!\nEnter State :- ");
					state=sc.nextLine();
				}
				person.setState(state);
				System.out.println("Enter zip code :- ");
				String zipCode=sc.nextLine();
				while(!zipCode.matches("\\d{6}")) {
					System.out.println("INVALID!!\nEnter Zip code :- ");
					zipCode=sc.nextLine();
				}
				person.setZipCode(zipCode);
				System.out.println("Enter contact number :- ");
				String phoneNumber=sc.nextLine();
				while(!phoneNumber.matches("^[6-9]{1}\\d{9}")) {
					System.out.println("INVALID !\nEnter Contact number :- ");
					phoneNumber=sc.nextLine();
				}
				person.setPhoneNumber(phoneNumber);
				System.out.println("Enter Email Id:-");
				String email=sc.nextLine();
				while(!email.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")){
					System.out.println("INVALID EMAIL ID !\n Enter Valid Email Id:-");
					email=sc.nextLine();
				}
				person.setEmail(email);
				flag=1;
				System.out.println("Edited:- "+person);
			}
		}
		if(flag==0) {
			System.out.println("This name does not exists!");
		}
	}
	public void deletePerson(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter name of person to be deleted?");
		String name=sc.nextLine();
		int flag=0;
		for(int i=0;i<contacts.size();i++) {
			Person person=contacts.get(i);
			if(name.equals(person.firstName)) {
				System.out.println("Deleted:- "+person);
				contacts.remove(i);
				flag=1;
			}
		}
		if(flag==0) {
			System.out.println("This name does not exists!");
		}
	}
	public void display() {
		System.out.println("\n*****************All Contacts************************");
		for(int i=0;i<contacts.size();i++) {
			System.out.println(contacts.get(i));
		}
	}
}

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program !!!");
		Scanner sc=new Scanner(System.in);
		AddressBook addressbook=new AddressBook();
		int choice;
		do {
			System.out.println("\n\n*******************OPTIONS********************\n");
			System.out.println("1]Add Contact\n2]Edit Contact\n3]Delete Contact\n4]Exit");
			choice=sc.nextInt();
			switch(choice) {
				case 1:addressbook.addPerson(sc);
					   addressbook.display();
					   break;
				case 2:addressbook.editPerson(sc);
						addressbook.display();
					   break;
				case 3:addressbook.deletePerson(sc);
				       addressbook.display();
					   break;
				case 4:System.exit(0);
			}
		}while(choice!=4);
	}
}
