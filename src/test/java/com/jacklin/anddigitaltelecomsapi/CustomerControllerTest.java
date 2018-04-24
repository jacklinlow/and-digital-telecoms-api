package com.jacklin.anddigitaltelecomsapi;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Jacklin on 21/04/2018.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private PhoneNumberController phoneNumberController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(phoneNumberController).build();
    }

    @Test
    public void testGetPhoneNumbersRequestReturnsAllPhoneNumbers() throws Exception {
        String expectedJsonResponse = "[{\"number\":\"07486154863\",\"activated\":false},{\"number\":\"07416558848\",\"activated\":true},{\"number\":\"07452244814\",\"activated\":false},{\"number\":\"07746155963\",\"activated\":true},{\"number\":\"07434564863\",\"activated\":false},{\"number\":\"07688964448\",\"activated\":false},{\"number\":\"07567900987\",\"activated\":true},{\"number\":\"07634567832\",\"activated\":true}]";

        mockMvc.perform(get("/api/phonenumbers"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonResponse));
    }

    @Test
    public void testGetPhoneNumbersByCustomerIdRequestReturnsOnePhoneNumberOfACustomerWithOneNumber() throws Exception {
        String expectedJsonResponse = "[{\"number\":\"07634567832\",\"activated\":true}]";

        mockMvc.perform(get("/api/customers/3/phonenumbers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonResponse));
    }

    @Test
    public void testGetPhoneNumbersByCustomerIdRequestReturnsAllPhoneNumbersOfACustomerWithThreeNumbers() throws Exception {
        String expectedJsonResponse = "[{\"number\":\"07486154863\",\"activated\":false},{\"number\":\"07416558848\",\"activated\":true},{\"number\":\"07452244814\",\"activated\":false}]";

        mockMvc.perform(get("/api/customers/1/phonenumbers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonResponse));
    }

    @Test
    public void testGetPhoneNumbersByCustomerIdRequestReturnsNoPhoneNumbersForANonExistentCustomer() throws Exception {
        mockMvc.perform(get("/api/customers/6/phonenumbers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string("[]"));
    }

    @Test
    public void testGetPhoneNumbersByCustomerIdRequestReturnsHttpResponse404ForANonExistentCustomer() throws Exception {
        mockMvc.perform(get("/api/customers/6/phonenumbers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testPutPhoneNumbersRequestWithPhoneNumberInParameterSetsActivatedToTrue() throws Exception {
        String expectedJsonResponse = "[{\"number\":\"07486154863\",\"activated\":true}]";

        mockMvc.perform(put("/api/phonenumbers/07486154863"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonResponse));
    }

    @Test
    public void testPutPhoneNumbersRequestWithNonExistentNumberInParameterReturnsHttpResponse404() throws Exception {

        mockMvc.perform(put("/api/phonenumbers/07486154866"))
                .andExpect(status().isNotFound());
    }


}