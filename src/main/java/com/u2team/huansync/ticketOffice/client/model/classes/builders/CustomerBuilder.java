/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.model.classes.builders;

import com.u2team.huansync.ticketOffice.client.model.classes.Customer;

import java.time.LocalDate;

/**
 * Interface for building instances of the {@link Customer} class using a fluent builder pattern.
 *
 * Usage example:
 * <pre>{@code
 * Customer customer = CustomerBuilderFactory.createBuilder()
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
public interface CustomerBuilder {

    /**
     * Sets the customer ID for the builder.
     *
     * @param customerId The customer ID to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    CustomerBuilder customerId(long customerId);

    /**
     * Sets the name of the customer for the builder.
     *
     * @param nameCustomer The name of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    CustomerBuilder nameCustomer(String nameCustomer);

    /**
     * Sets the document of the customer for the builder.
     *
     * @param document The document of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    CustomerBuilder document(String document);

    /**
     * Sets the gender of the customer for the builder.
     *
     * @param gender The gender of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    CustomerBuilder gender(String gender);

    /**
     * Sets the birth date of the customer for the builder.
     *
     * @param birthDate The birth date of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    CustomerBuilder birthDate(LocalDate birthDate);

    /**
     * Sets the email of the customer for the builder.
     *
     * @param email The email of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    CustomerBuilder email(String email);

    /**
     * Sets the phone number of the customer for the builder.
     *
     * @param phoneNumber The phone number of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    CustomerBuilder phoneNumber(String phoneNumber);

    /**
     * Sets the customer type of the customer for the builder.
     *
     * @param customerTypeEnum The customer type of the customer to be set.
     * @return The CustomerBuilder instance for method chaining.
     */
    CustomerBuilder customerTypeEnum(String customerTypeEnum);

    /**
     * Builds and returns an instance of the {@link Customer} class with the set attributes.
     *
     * @return An instance of the {@link Customer} class.
     */
    Customer build();
}
