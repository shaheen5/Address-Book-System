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
	    //update person details in database
	    public int updatePersonData(String name, String address,String city,String state ,String zipCode)
	    							throws MyAddressBookException{
	    	String sql = "  UPDATE contacts SET address = ? ,city = ? ,state =? ,zip_code = ? WHERE first_name = ? ;";
	    	try (Connection connection = this.getConnection()) {
	    		PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    		preparedStatement.setString(1, address);
	    		preparedStatement.setString(2, city);
	    		preparedStatement.setString(3, state);
	    		preparedStatement.setString(4, zipCode);
	    		preparedStatement.setString(5,name);
	    		return preparedStatement.executeUpdate();
	    	} catch (SQLException e) {
	    		throw new MyAddressBookException("Connection Error Occurred!");
	    	}
	    }
	    //retrieve from database , details of person having given name
	    public List<Person> getPersonData(String name) throws MyAddressBookException {
	        List<Person> contactPersons = new ArrayList<>();
	        String sql = " SELECT * FROM contacts WHERE first_name = ? ";
	        try (Connection connection = this.getConnection()) {
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, name);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            contactPersons = this.getPersonData(resultSet);
	        } catch (SQLException e) {
	    		throw new MyAddressBookException("Connection Error Occurred!");
	    	}
	        return contactPersons;
	    }
	    // retrive fields of person record from given resultset and create new person with that details
	    private List<Person> getPersonData(ResultSet resultSet) throws MyAddressBookException {
	        List<Person> contacts = new ArrayList<>();
	        try {
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
	    		throw new MyAddressBookException("Database Access Denied!");
	    	}
	        return contacts;
	    }
	    //retrieve records from contacts database having date between given range 
	    public List<Person> getPersonDataAddedBetweenDateRange( LocalDate startDate, LocalDate endDate)
            							    throws MyAddressBookException {
	    	String sql = String.format("SELECT * FROM contacts WHERE date_added BETWEEN '%s' AND '%s' ;",
	    			       	   Date.valueOf(startDate), Date.valueOf(endDate));
	    	return this.getPersonsDataUsingDB(sql);
	    }
	}
