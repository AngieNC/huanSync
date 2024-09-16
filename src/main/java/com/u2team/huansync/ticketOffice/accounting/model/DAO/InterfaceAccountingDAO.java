package com.u2team.huansync.ticketOffice.accounting.model.DAO;

/**
 * The InterfaceAccountingDAO interface defines the contract for generating various reports related to accounting.
 */
public interface InterfaceAccountingDAO {

    /**
     * Generates a total sales report.
     */
    void generateTotalSalesReport();

    /**
     * Generates a category sales report.
     */
    void generateCategorySalesReport();

    /**
     * Generates an availability report.
     */
    void generateAvailabilityReport();

    /**
     * Generates a participants report.
     */
    void generateParticipantsReport();
}
