package com.addressbooksystem;

import java.io.Serializable;

public class Person implements Serializable{
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
        return "FirstName=" + firstName + ", LastName=" + lastName + ", Address=" + address + ", City=" + city
                + ", State=" + state + ", ZipCode=" + zipCode + ", PhoneNumber=" + phoneNumber + ", Email=" + email
                + "";
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getZipCode() {
        return Integer.parseInt(zipCode);
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public boolean equals(Object object) {
        if(this==object) return true;
        if(object==null) return false;
        if (this.getClass() != object.getClass()) return false;
        Person that = (Person) object;
        if (!(this.firstName.equalsIgnoreCase(that.firstName))) return false;
        if (!(this.lastName.equalsIgnoreCase(that.lastName))) return false;
        if (!(this.address.equalsIgnoreCase(that.address)))   return false;
        if (!(this.city.equalsIgnoreCase(that.city)))   return false;
        if (!(this.state.equalsIgnoreCase(that.state)))   return false;
        if (!(this.zipCode.equalsIgnoreCase(that.zipCode)))  return false;
        if (!(this.phoneNumber.equalsIgnoreCase(that.phoneNumber))) return false;
        if (!(this.email.equalsIgnoreCase(that.email)))  return false;
        return true;
    }
}
