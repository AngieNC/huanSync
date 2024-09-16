/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.model.classes.builders;

import com.u2team.huansync.ticketOffice.client.model.classes.Customer;
import com.u2team.huansync.ticketOffice.client.model.classes.CustomerTypeEnum;

import java.time.LocalDate;

/**
 * Concrete implementation of the {@link CustomerBuilder} interface, providing methods to construct and configure
 * instances of the {@link Customer} class using a fluent builder pattern.
 *
 * Usage example:
 * <pre>{@code
 * CustomerBuilder customerBuilder = new CustomerConcreteBuilder();
 * Customer customer = customerBuilder
 *     .customerId(1)
 *     .nameCustomer("John Doe")
 *     .document("123456789")
 *     .gender("Male")
 *     .birthDate(LocalDate.of(1990, 1, 1))
 *     .email("john.doe@example.com")
 *     .phoneNumber("123-456-7890")
 *     .customerTypeEnum("PARTICIPANT")
 *     .build();
 * }</pre>
 *
 * @author SANTOS
 */
public class CustomerConcreteBuilder implements CustomerBuilder {

    /**
     * The customer instance being built.
     */
    private Customer customer = new Customer();

    /**
     * Sets the customer ID for the builder.
     *
     * @param customerId The customer ID to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    @Override
    public CustomerBuilder customerId(long customerId) {
        customer.setCustomerId(customerId);
        return this;
    }

    /**
     * Sets the name of the customer for the builder.
     *
     * @param nameCustomer The name of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    @Override
    public CustomerBuilder nameCustomer(String nameCustomer) {
        customer.setName(nameCustomer);
        return this;
    }

    /**
     * Sets the document of the customer for the builder.
     *
     * @param document The document of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    @Override
    public CustomerBuilder document(String document) {
        customer.setDocument(document);
        return this;
    }

    /**
     * Sets the gender of the customer for the builder.
     *
     * @param gender The gender of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    @Override
    public CustomerBuilder gender(String gender) {
        customer.setGender(gender);
        return this;
    }

    /**
     * Sets the birth date of the customer for the builder.
     *
     * @param birthDate The birth date of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    @Override
    public CustomerBuilder birthDate(LocalDate birthDate) {
        customer.setBirthDate(birthDate);
        return this;
    }

    /**
     * Sets the email of the customer for the builder.
     *
     * @param email The email of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    @Override
    public CustomerBuilder email(String email) {
        customer.setEmail(email);
        return this;
    }

    /**
     * Sets the phone number of the customer for the builder.
     *
     * @param phoneNumber The phone number of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    @Override
    public CustomerBuilder phoneNumber(String phoneNumber) {
        customer.setPhoneNumber(phoneNumber);
        return this;
    }

    /**
     * Sets the customer type of the customer for the builder.
     *
     * @param customerTypeEnum The customer type of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    @Override
    public CustomerBuilder customerTypeEnum(String customerTypeEnum) {
        if (customerTypeEnum.equalsIgnoreCase("participant")) {
            customer.setCustomerTypeEnum(CustomerTypeEnum.PARTICIPANT);
        }
        if (customerTypeEnum.equalsIgnoreCase("visitor")) {
            customer.setCustomerTypeEnum(CustomerTypeEnum.VISITOR);
        }
        if (customerTypeEnum.equalsIgnoreCase("winner")) {
            customer.setCustomerTypeEnum(CustomerTypeEnum.WINNER);
        }
        return this;
    }

    /**
     * Builds and returns an instance of the {@link Customer} class with the set attributes.
     *
     * @return An instance of the {@link Customer} class.
     */
    @Override
    public Customer build() {
        return customer;
    }
}
