/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.model.classes;

/**
 * Enumeration representing different types of customers.
 * Each enum constant has an associated description.
 *
 * Usage example:
 * CustomerTypeEnum.PARTICIPANT.getDescription() returns "Is a participant"
 *
 * @author SANTOS
 */
public enum CustomerTypeEnum {

    /**
     * Represents a customer who is a participant.
     */
    PARTICIPANT("Is a participant"),

    /**
     * Represents a customer who is a visitor.
     */
    VISITOR("Is a visitor"),

    /**
     * Represents a customer who is a winner.
     */
    WINNER("Is a winner");

    /**
     * Description associated with the customer type.
     */
    private String description;

    /**
     * Constructs a CustomerTypeEnum with the given description.
     *
     * @param description The description associated with the customer type.
     */
    private CustomerTypeEnum(String description) {
        this.description = description;
    }

    /**
     * Gets the description associated with the customer type.
     *
     * @return The description of the customer type.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description associated with the customer type.
     *
     * @param description The description to be set for the customer type.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
