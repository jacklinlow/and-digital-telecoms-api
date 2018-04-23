package com.jacklin.anddigitaltelecomsapi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jacklin on 20/04/2018.
 */

@RestController
public class PhoneNumberController {

    CustomerData customerData = new CustomerData();

    @RequestMapping(method = RequestMethod.GET, value = "/api/phonenumbers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhoneNumber> getPhoneNumbers() {

        List<PhoneNumber> allPhoneNumbers  = customerData.getCustomerData()
                .stream()
                .map(Customer::getPhoneNumbers)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return allPhoneNumbers;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/customers/{customerid}/phonenumbers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhoneNumber> getPhoneNumbersByCustomerId(@PathVariable("customerid") int customerid, HttpServletResponse response) {

        List<PhoneNumber> phoneNumbersByCustomer;

        phoneNumbersByCustomer = customerData.getCustomerData()
                .stream()
                .filter(p -> p.getId() == customerid)
                .map(Customer::getPhoneNumbers)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        if(phoneNumbersByCustomer.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }

        return phoneNumbersByCustomer;
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/api/phonenumbers/{phonenumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PhoneNumber
    activatePhoneNumber(@PathVariable("phonenumber") String phonenumber) {

        PhoneNumber phoneNumber  = customerData.getCustomerData()
                .stream()
                .map(Customer::getPhoneNumbers)
                .flatMap(List::stream)
                .filter(x -> x.getNumber().equals(phonenumber))
                .findFirst().get();

        phoneNumber.setActivated(true);
        return phoneNumber;

    }

}
