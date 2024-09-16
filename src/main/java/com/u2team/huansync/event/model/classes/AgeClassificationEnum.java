
package com.u2team.huansync.event.model.classes;

/**
 *
 * @ Christian Pardo
 */
public enum AgeClassificationEnum {
    /**
     * Classification for events suitable for the whole family.
     */
    FAMILY("For the whole family"), 

    /**
     * Classification for events specifically targeting younger audiences.
     */
    YOUNGER("Only for young people"), 

    /**
     * Classification for events meant for adult audiences only.
     */
    ADULT("Adults Only");
    
    private String description;

    /**
     * Constructs an AgeClassificationEnum with a description.
     *
     * @param description A descriptive string for the age classification.
     */
    private AgeClassificationEnum(String description) {
        this.description = description;
    }

    /**
     * Retrieves the description of the age classification.
     *
     * @return The description of the age classification.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description for this age classification.
     *
     * @param description The new description of the age classification.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}