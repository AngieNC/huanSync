package com.u2team.huansync.event.equipment.model.classes;

/**
 * /**
 *
 * @author Cristina Jerez Salas
 
 * Represents an Equipment entity in the system. This class holds details about
 * equipment such as ID, name, quantity, and status.
 */
public class Equipment {

    private long equipmentId;
    private String nameEquipment;
    private long quantity;
    private StatusEquipmentEnum statusEquipmentEnum;

    /**
     * Default constructor for creating an empty Equipment instance.
     */
    public Equipment() {
    }

    /**
     * Constructs an Equipment instance with specified details.
     *
     * @param equipmentId Unique identifier for the equipment.
     * @param nameEquipment Name of the equipment.
     * @param quantity Quantity of the equipment available.
     * @param statusEquipmentEnum Current status of the equipment.
     */
    public Equipment(long equipmentId, String nameEquipment, long quantity, StatusEquipmentEnum statusEquipmentEnum) {
        this.equipmentId = equipmentId;
        this.nameEquipment = nameEquipment;
        this.quantity = quantity;
        this.statusEquipmentEnum = statusEquipmentEnum;
    }

    /**
     * Gets the ID of the equipment.
     *
     * @return The equipment ID.
     */
    public long getEquipmentId() {
        return equipmentId;
    }

    /**
     * Sets the ID for the equipment.
     *
     * @param equipmentId The new ID of the equipment.
     */
    public void setEquipmentId(long equipmentId) {
        this.equipmentId = equipmentId;
    }

    /**
     * Gets the name of the equipment.
     *
     * @return The name of the equipment.
     */
    public String getNameEquipment() {
        return nameEquipment;
    }

    /**
     * Sets the name of the equipment.
     *
     * @param nameEquipment The new name of the equipment.
     */
    public void setNameEquipment(String nameEquipment) {
        this.nameEquipment = nameEquipment;
    }

    /**
     * Gets the quantity of the equipment.
     *
     * @return The quantity of the equipment.
     */
    public long getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the equipment.
     *
     * @param quantity The new quantity of the equipment.
     */
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the status of the equipment as an enum value.
     *
     * @return The current status of the equipment.
     */
    public StatusEquipmentEnum getStatusEquipmentEnum() {
        return statusEquipmentEnum;
    }

    /**
     * Converts a string representation of equipment status to its corresponding
     * StatusEquipmentEnum value.
     *
     * @param statusEquipmentEnum The string representation of the equipment
     * status.
     * @return The corresponding StatusEquipmentEnum value, or null if the input
     * does not match any status.
     */
    public StatusEquipmentEnum getStatusEquipmentEnum(String statusEquipmentEnum) {
        if (statusEquipmentEnum.equalsIgnoreCase("ON_SITE")) {
            return StatusEquipmentEnum.ON_SITE;
        }
        if (statusEquipmentEnum.equalsIgnoreCase("IN_STOCK")) {
            return StatusEquipmentEnum.IN_STOCK;
        }
        return null;
    }

    /**
     * Sets the status of the equipment.
     *
     * @param statusEquipmentEnum The new status of the equipment.
     */
    public void setStatusEquipmentEnum(StatusEquipmentEnum statusEquipmentEnum) {
        this.statusEquipmentEnum = statusEquipmentEnum;
    }

    /**
     * Returns a string representation of the Equipment object.
     *
     * @return String containing the equipment's details.
     */
    @Override
    public String toString() {
        return "Equipment{" + "equipmentId=" + equipmentId + ", nameEquipment=" + nameEquipment + ", quantity=" + quantity + ", statusEquipmentEnum=" + statusEquipmentEnum + '}';
    }
}
