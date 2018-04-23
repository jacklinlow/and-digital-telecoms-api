package com.jacklin.anddigitaltelecomsapi;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacklin on 22/04/2018.
 */
public class CustomerData {

    private List<Customer> customerData = new ArrayList<>();

    public CustomerData() {
        PhoneNumber phoneNumber1 = new PhoneNumber ("07486154863",false);
        PhoneNumber phoneNumber2 = new PhoneNumber ("07416558848",true);
        PhoneNumber phoneNumber3 = new PhoneNumber ("07452244814",false);
        PhoneNumber phoneNumber4 = new PhoneNumber ("07746155963",true);
        PhoneNumber phoneNumber5 = new PhoneNumber ("07434564863",false);
        PhoneNumber phoneNumber6 = new PhoneNumber ("07688964448",false);
        PhoneNumber phoneNumber7 = new PhoneNumber ("07567900987",true);
        PhoneNumber phoneNumber8 = new PhoneNumber ("07634567832",true);

        List<PhoneNumber> cust1Numbers = new ArrayList<>();
        cust1Numbers.add(phoneNumber1);
        cust1Numbers.add(phoneNumber2);
        cust1Numbers.add(phoneNumber3);

        List<PhoneNumber> cust2Numbers = new ArrayList<>();
        cust2Numbers.add(phoneNumber4);
        cust2Numbers.add(phoneNumber5);
        cust2Numbers.add(phoneNumber6);
        cust2Numbers.add(phoneNumber7);

        List<PhoneNumber> cust3Numbers = new ArrayList<>();
        cust3Numbers.add(phoneNumber8);

        Customer cust1 = new Customer(1, "Jacklin", "Low", cust1Numbers);
        Customer cust2 = new Customer(2, "James", "Beal", cust2Numbers);
        Customer cust3 = new Customer(3, "Amanda", "Doole", cust3Numbers);

        customerData.add(cust1);
        customerData.add(cust2);
        customerData.add(cust3);
    }

    public List<Customer> getCustomerData() {
        return customerData;
    }
}
