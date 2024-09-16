package com.u2team.huansync.ticketOffice.accounting.controller;

import com.u2team.huansync.ticketOffice.accounting.model.DAO.InterfaceAccountingDAO;
import com.u2team.huansync.ticketOffice.accounting.model.classes.AccountingDAO;

/**
 * The AccountingController class acts as a controller for managing accounting-related operations.
 */
public class AccountingController {

    // Instance of the InterfaceAccountingDAO for generating accounting reports.
    private InterfaceAccountingDAO accountingDAO;

    /**
     * Constructor to initialize the AccountingController with a default InterfaceAccountingDAO implementation.
     */
    public AccountingController() {
        this.accountingDAO = new AccountingDAO();
    }

    /**
     * Generates various accounting reports using the associated InterfaceAccountingDAO instance.
     */
    public void generateReports() {
        accountingDAO.generateTotalSalesReport();
        accountingDAO.generateCategorySalesReport();
        accountingDAO.generateAvailabilityReport();
        accountingDAO.generateParticipantsReport();
    }
}
