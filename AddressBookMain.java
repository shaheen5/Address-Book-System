package com.addressbooksystem;

import java.io.IOException;
import java.util.*;
import java.util.stream.*;

public class AddressBookMain {
	static HashMap<String,AddressBook>addressbooks=new HashMap<String,AddressBook>();
	static AddressBook addressbook=new AddressBook();

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to Address Book Program !!!");
		@SuppressWarnings("resource")
		Scanner userInput=new Scanner(System.in);
		int choice;
		String addressBookName = "Default";
		addressbooks.put(addressBookName,addressbook);
		do {
			System.out.println("\n\n*******************OPTIONS********************\n");
			System.out.println("1]Add Contact\n2]Edit Contact\n3]Delete Contact\n4]Go To Address Book\n5]Display Current AddressBook\n"
					  + "6]Display All AddressBooks\n7]View Person by City or State In Current Address Book\n"
					  + "8]Search Person By City Or State In All Address Books\n9]Count No. Of Persons by City Or State\n"
					  + "10]Sort Entries in AddressBook By Person's Name\n11]Ability To Sort Entries In AddressBook"
					  + "By City, State Or ZipCode\n12]Read Or Write Person Data Into File\n13]Read Or Write Contacts Into "
					  + "CSV File\n14]Read or Write the AddressBook with Persons Contact as JSON File 15]Exit\"");
			choice=userInput.nextInt();
			userInput.nextLine();
			switch(choice) {
				case 1: addressbook.addPerson();
					addressbook.display();
				        break;
				case 2: addressbook.editPerson();
					addressbook.display();
					break;
				case 3: addressbook.deletePerson();
				        addressbook.display();
				        break;
				case 4: selectAddressBook();
				        break;
				case 5: addressbook.display();
					break;
				case 6: display();
					break;
				case 7: viewPersonsByCityOrState();
					break;
				case 8: searchPersonsByCityOrState();
                        		break;
				case 9: countPersonsByCityOrState();
					break;
				case 10: addressbook.sortPersonsByName();
					break;
				case 11: SortEntriesByCityOrStateOrZipcode();
					break;
				case 12: selectreadOrWriteFromFile();
					break;
				case 13: selectReadOrWriteFromCSVFile();
					break;
				case 14: selectReadOrWriteToJSONFile();
					break;
				case 15: System.exit(0);			
				}
		}while(choice!=15);
	}

	//method to check whether addressBook contains given name
	public static boolean isKeyExists(String name) {
		return addressbooks.containsKey(name);
	}

	//method to display all addressBook records
	public static void display() {
		System.out.println("*******All Address Book Details*******\n");
		addressbooks.entrySet().stream().forEach(book->{
				System.out.println("\""+book.getKey()+"\""+" "+book.getValue());
		});
	}

	//method to select or create a new addressBook
	public static void selectAddressBook(){
        	Scanner userInput=new Scanner(System.in);
		System.out.println("Enter name of Address Book:");
        	String addressbookName=userInput.nextLine();
        	if(isKeyExists(addressbookName)) {
    	    		System.out.println("This addressbook already exists!");
    	    		System.out.println("Entering '"+addressbookName+"' addressbook........");
    	    		addressbook=addressbooks.get(addressbookName);
        	}
        	else {
    	    		System.out.println("Creating New AddressBook........");
    	    		AddressBook tempAddressBook=new AddressBook();
    	    		addressbooks.put(addressbookName, tempAddressBook);
    	    		addressbook=tempAddressBook;
    	    		System.out.println("Welcome to '"+addressbookName+"' addressbook");
        	}
	}

	//method to search person by city in all addressBooks
    	public static void searchPersonByCity() {
        	Scanner userInput=new Scanner(System.in);
        	System.out.print("Enter city name :");
        	String cityName=userInput.nextLine();
        	List<Person> list = addressbooks.values()
        					.stream()
        					.map(addressbook->addressbook.getContacts())
        					.flatMap(List::stream)
        					.filter(city->city.getCity().equalsIgnoreCase(cityName))
        					.collect(Collectors.toList());
       		if(list.isEmpty())
    			System.out.println("This City does not exists!");
       		else
    			list.forEach(System.out::println);
        }

    	//method to search person by state in all adrressBooks
    	public static void searchPersonByState() {
    		Scanner userInput=new Scanner(System.in);
    		System.out.print("Enter State name :");
    		String stateName=userInput.nextLine();
    		List<Person> list = addressbooks.values().stream()
						.map(addressbook->addressbook.getContacts())
						.flatMap(List::stream)
						.filter(state->state.getState().equalsIgnoreCase(stateName))
						.collect(Collectors.toList());
    		if(list.isEmpty())
    			System.out.println("This State does not exists!");
    		else
    			list.forEach(System.out::println);
    	}

	//method to select options to view persons in city or state
    	public static void viewPersonsByCityOrState() {
    		System.out.println("Enter (C) to View by City\nEnter (S) to View by State\n");
    		Scanner userInput=new Scanner(System.in);
		String input=userInput.nextLine();
		if(input.equalsIgnoreCase("C")) {
			System.out.print("Enter City Name :");
			String cityName=userInput.nextLine();
			List<Person>personsList=addressbook.getPersonsByCity(cityName);
			addressbook.displayNumberOfPersonsFound(personsList,cityName);
		}
		else if(input.equalsIgnoreCase("S")) {
			System.out.print("Enter State Name :");
			String stateName=userInput.nextLine();
			List<Person>personsList=addressbook.getPersonsByState(stateName);
			addressbook.displayNumberOfPersonsFound(personsList,stateName);
			}
		else
			System.out.println("Invalid Input!");
    	}

    	//method to select options to search persons in city or state
    	public static void searchPersonsByCityOrState() {
    		System.out.println("Enter (C) to search by City\nEnter (S) to search by State\n");
     	 	Scanner userInput=new Scanner(System.in);
		String searchInput=userInput.nextLine();
		if(searchInput.equalsIgnoreCase("C")) 
			searchPersonByCity();
 		else if(searchInput.equalsIgnoreCase("S"))
 			searchPersonByState();
	 	else
	     		System.out.println("Invalid Input!");
    	}

	//method to select options to count by city or by state
        public static void countPersonsByCityOrState() {
    		System.out.println("Enter (C) to Count by City\nEnter (S) to Count by State\n");
    		Scanner userInput=new Scanner(System.in);
		String input=userInput.nextLine();
		if(input.equalsIgnoreCase("C")) {
			System.out.print("Enter City Name :");
			String cityName=userInput.nextLine();
			addressbook.countPersonsByCity(cityName);
		}
		else if(input.equalsIgnoreCase("S")) {
			System.out.print("Enter State Name :");
			String stateName=userInput.nextLine();
			addressbook.countPersonsByState(stateName);
			}
		else
			System.out.println("Invalid Input!");
	}
    	//method to select option to sort by city ,state or zipCode
        public static void SortEntriesByCityOrStateOrZipcode() {
    		Scanner userInput=new Scanner(System.in);
        	System.out.println("Enter (C) to Sort by City\nEnter (S) to Sort by State\nEnter (Z) to Sort by ZipCode\n");
        	System.out.print("Enter your choice:");
        	String choice=userInput.nextLine();
        	switch(choice) {
        		case "C":
        		case "c":addressbook.sortPersonsByCity();
        				break;
        		case "S":
        		case "s":addressbook.sortPersonsByState();
        				break;
        		case "Z":
        		case "z":addressbook.sortPersonsByZipCode();
        				break;
        		default : System.out.println("Invalid Input");
        	}
    	}
        //select options to read or write from file
        public static void selectreadOrWriteFromFile() {
        	Scanner userInput=new Scanner(System.in);
        	System.out.println("Enter (W) to Write to a File\nEnter (R) to Read From a File");
        	System.out.print("Enter your choice:");
        	String choice=userInput.nextLine();
        	if(choice.equalsIgnoreCase("w"))
        		addressbook.writeDataToFile();
        	else if(choice.equalsIgnoreCase("r"))
        		addressbook.readDataFromFile();
        	else
        		System.out.println("Invalid Input!");
    	}
        //select options to read or write from CSV File
        public static void selectReadOrWriteFromCSVFile() throws IOException  {
            	Scanner userInput=new Scanner(System.in);
            	System.out.println("Enter (W) to Write to a File\nEnter (R) to Read From a CSV File");
            	System.out.print("Enter your choice:");
            	String choice=userInput.nextLine();
                if(choice.equalsIgnoreCase("w"))
                	addressbook.writeDataToCSVFile();
            	else if(choice.equalsIgnoreCase("r"))
                	addressbook.readDataFromCSVFile();
            	else
                	System.out.println("Invalid Input!");
        }
        //select options to read or write from JSON File
        public static void selectReadOrWriteToJSONFile() {
                Scanner userInput=new Scanner(System.in);
                System.out.println("Enter (W) to Write to a File\nEnter (R) to Read From a JSON File");
                System.out.print("Enter your choice:");
                String choice=userInput.nextLine();
                if(choice.equalsIgnoreCase("w"))
                	addressbook.writeDataToJSONFile();
                else if(choice.equalsIgnoreCase("r"))
                	addressbook.readDataFromJSONFile();
                else
                	System.out.println("Invalid Input!");
        }

}
