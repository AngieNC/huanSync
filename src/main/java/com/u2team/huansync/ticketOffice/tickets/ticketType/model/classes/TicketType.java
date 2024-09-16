package com.u2team.huansync.ticketOffice.tickets.ticketType.model.classes;

/**
 * Represents a ticket type with various properties.
 */
public class TicketType {
    private long ticketTypeId;
    private String nameTicketType;
    private String description;
    private double price;

    /**
     * Default constructor for TicketType.
     */
    public TicketType() {
    }

    /**
     * Parameterized constructor for TicketType.
     *
     * @param ticketTypeId   The ID of the ticket type.
     * @param nameTicketType The name of the ticket type.
     * @param description    The description of the ticket type.
     * @param price          The price of the ticket type.
     */
    public TicketType(long ticketTypeId, String nameTicketType, String description, double price) {
        this.ticketTypeId = ticketTypeId;
        this.nameTicketType = nameTicketType;
        this.description = description;
        this.price = price;
    }

    /**
     * Gets the ID of the ticket type.
     *
     * @return The ticket type ID.
     */
    public long getTicketTypeId() {
        return ticketTypeId;
    }

    /**
     * Sets the ID of the ticket type.
     *
     * @param ticketTypeId The ticket type ID to set.
     */
    public void setTicketTypeId(long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    /**
     * Gets the name of the ticket type.
     *
     * @return The name of the ticket type.
     */
    public String getNameTicketType() {
        return nameTicketType;
    }

    /**
     * Sets the name of the ticket type.
     *
     * @param nameTicketType The name of the ticket type to set.
     */
    public void setNameTicketType(String nameTicketType) {
        this.nameTicketType = nameTicketType;
    }

    /**
     * Gets the description of the ticket type.
     *
     * @return The description of the ticket type.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the ticket type.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price of the ticket type.
     *
     * @return The price of the ticket type.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the ticket type.
     *
     * @param price The price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns a string representation of the TicketType object.
     *
     * @return A string representation of the TicketType object.
     */
    @Override
    public String toString() {
        return "TicketType{" +
                "ticketTypeId=" + ticketTypeId +
                ", nameTicketType='" + nameTicketType + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
