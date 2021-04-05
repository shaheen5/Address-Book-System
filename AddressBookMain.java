package Address_Book_Problem;

import java.util.Scanner;

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
}

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program !!!");
		Scanner sc=new Scanner(System.in);
		Person person=addPerson(sc);
		System.out.println(person);
	}
	public static Person addPerson(Scanner sc) {
		System.out.println("\nEnter First name :- ");
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
		while(!phoneNumber.matches("\\d{10}")) {
			System.out.println("INVALID !\nEnter Contact number :- ");
			phoneNumber=sc.nextLine();
		}
		System.out.println("Enter Email Id:-");
		String email=sc.nextLine();
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		while(!email.matches(EMAIL_REGEX)) {
			System.out.println("INVALID EMAIL ID !\n Enter Valid Email Id:-");
		    email=sc.nextLine();
		}
		Person person=new Person(firstName,lastName,address,city,state,zipCode,phoneNumber,email);
		return person;
	}
}
