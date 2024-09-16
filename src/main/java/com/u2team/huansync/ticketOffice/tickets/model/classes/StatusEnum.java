package com.u2team.huansync.ticketOffice.tickets.model.classes;

/**
 * Enum representing the status of a ticket, including descriptions.
 */
public enum StatusEnum {
    RESERVED("It is reserved"), PAID("It is paid");

    private String description;

    /**
     * Constructor for StatusEnum with a description.
     * @param description The description of the status.
     */
    StatusEnum(String description) {
        this.description = description;
    }

    /**
     * Gets the description of the status.
     * @return The description of the status.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the status.
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
