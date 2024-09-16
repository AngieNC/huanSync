package com.u2team.huansync.event.equipment.model.classes;

/**
 *  @author Cristina Jerez Salas
 *
 * This enum has values to indicate whether the equipment is in stock or on
 * site.
 */
public enum StatusEquipmentEnum {
    /**
     * Status indicating that the item is available in the warehouse.
     */
    IN_STOCK("The item is in the warehouse"),
    /**
     * Status indicating that the item is currently at the event's location.
     */
    ON_SITE("The item is at the Event's Location");

    private String description;

    /**
     * Constructs a StatusEquipmentEnum with a description.
     *
     * @param description The description of the status.
     */
    private StatusEquipmentEnum(String description) {
        this.description = description;
    }

    /**
     * Gets the description of the equipment status.
     *
     * @return The description of the status.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description for the equipment status.
     *
     * @param description The new description of the status.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
