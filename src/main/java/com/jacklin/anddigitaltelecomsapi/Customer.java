package com.jacklin.anddigitaltelecomsapi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacklin on 20/04/2018.
 */
public class Customer {

    private long id;
    private String firstName;
    private String lastName;
    private List<PhoneNumber> phoneNumbers;

    public Customer(long id, String firstName, String lastName, List<PhoneNumber> phoneNumbers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }
}
