package com.u2team.huansync.ticketOffice.client.model.classes;

import java.time.LocalDate;

/**
 * Represents a customer entity with various attributes such as name, document, gender, birthdate, email, phone number, and customer type.
 */
public class Customer {

    /**
     * Unique identifier for the customer.
     */
    private long customerId;

    /**
     * The name of the customer.
     */
    private String name;

    /**
     * The document (ID, passport, etc.) associated with the customer.
     */
    private String document;

    /**
     * The gender of the customer.
     */
    private String gender;

    /**
     * The birth date of the customer.
     */
    private LocalDate birthDate;

    /**
     * The email address of the customer.
     */
    private String email;

    /**
     * The phone number of the customer.
     */
    private String phoneNumber;

    /**
     * The type of customer (participant, visitor, winner).
     */
    private CustomerTypeEnum customerTypeEnum;

    /**
     * Gets the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The name to be set for the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the unique identifier of the customer.
     *
     * @return The unique identifier of the customer.
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the unique identifier of the customer.
     *
     * @param customerId The unique identifier to be set for the customer.
     */
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the document associated with the customer.
     *
     * @return The document associated with the customer.
     */
    public String getDocument() {
        return document;
    }

    /**
     * Sets the document associated with the customer.
     *
     * @param document The document to be set for the customer.
     */
    public void setDocument(String document) {
        this.document = document;
    }

    /**
     * Gets the gender of the customer.
     *
     * @return The gender of the customer.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the customer.
     *
     * @param gender The gender to be set for the customer.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the birth date of the customer.
     *
     * @return The birth date of the customer.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birth date of the customer.
     *
     * @param birthDate The birth date to be set for the customer.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets the email address of the customer.
     *
     * @return The email address of the customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the customer.
     *
     * @param email The email address to be set for the customer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number of the customer.
     *
     * @return The phone number of the customer.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the customer.
     *
     * @param phoneNumber The phone number to be set for the customer.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the type of customer.
     *
     * @return The type of customer (e.g., regular, VIP).
     */
    public CustomerTypeEnum getCustomerTypeEnum() {
        return customerTypeEnum;
    }

    /**
     * Sets the type of customer.
     *
     * @param customerTypeEnum The customer type to be set for the customer.
     */
    public void setCustomerTypeEnum(CustomerTypeEnum customerTypeEnum) {
        this.customerTypeEnum = customerTypeEnum;
    }

    /**
     * Returns a string representation of the customer object.
     *
     * @return A string representation of the customer object.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerType=" + customerTypeEnum +
                '}';
    }
}
