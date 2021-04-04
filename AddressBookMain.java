package Address_Book_Problem;

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
		Person person=new Person("Shaheen","Miya","Bhairav Nagar","Pune","Maharashtra","411015","9912345675","abc@gmail.com");
		System.out.println(person);
	}
}
