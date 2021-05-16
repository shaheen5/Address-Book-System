package com.addressbooksystem;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

	public class AddressBookDBService {
		
	    private static AddressBookDBService addressBookDBService;

	    public static AddressBookDBService getInstance(){
	        if(addressBookDBService == null)
	            addressBookDBService = new AddressBookDBService();
	        return addressBookDBService;
	    }
	    //create connection to database and return connection object
	    private Connection getConnection() throws SQLException {
	        String jdbcURL = "jdbc:mysql://localhost:3306/addressbook_service?allowPublicKeyRetrieval=true&useSSL=false";
	        String userName = "root";
	        String passWord = "shaheen@5";
	        Connection connection;
	        System.out.println("Connecting to database " + jdbcURL);
	        connection = DriverManager.getConnection(jdbcURL, userName, passWord);
	        System.out.println("Connection is successful!! " + connection);
	        return connection;
	    }
	    //read data from database and return list
	    public List<Person> readDataFromDatabase() throws MyAddressBookException {
	        String sql = "SELECT * FROM contacts";
	        return this.getPersonsDataUsingDB(sql);
	    }
	    //execute sql query ,retrieve results ,store the results in list & return list
	    private List<Person> getPersonsDataUsingDB(String sql) throws MyAddressBookException {
	        List<Person> contacts = new ArrayList<>();
	        try (Connection connection = this.getConnection()) {
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql);
	            while (resultSet.next()) {
	                String firstName = resultSet.getString("first_name");
	                String lastName = resultSet.getString("last_name");
	                String address = resultSet.getString("address");
	                String city = resultSet.getString("city");
	                String state = resultSet.getString("state");
	                String zipCode = resultSet.getString("zip_code");
	                String phoneNumber = resultSet.getString("phone_number");
	                String email = resultSet.getString("email");
	                contacts.add(new Person(firstName,lastName,address,city,state,zipCode,phoneNumber,email));
	            }
	        } catch (SQLException e) {
	          //  throw new MyAddressBookException("Connection To Database Failed!");
	        	e.printStackTrace();
	        }
	        return contacts;
	    }
	}
