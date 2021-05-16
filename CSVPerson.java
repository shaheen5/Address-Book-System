package com.addressbooksystem;

import com.opencsv.bean.CsvBindByName;

public class CSVPerson {
    @CsvBindByName(column = "FIRST NAME", required = true)
    public String firstName;

    @CsvBindByName(column = "LAST NAME", required = true)
    public String lastName;

    @CsvBindByName(column = "ADDRESS", required = true)
    public String address;

    @CsvBindByName(column = "CITY", required = true)
    public String city;

    @CsvBindByName(column = "STATE", required = true)
    public String state;

    @CsvBindByName(column = "ZIPCODE", required = true)
    public String zipCode;

    @CsvBindByName(column = "PHONE NUMBER", required = true)
    public String phoneNumber;

    @CsvBindByName(column = "EMAIL", required = true)
    public String email;

    @Override
    public String toString() {
        return "CSVPerson{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
