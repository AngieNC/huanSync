/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import com.u2team.huansync.ticketOffice.client.model.classes.Customer;
import com.u2team.huansync.ticketOffice.client.model.classes.builders.CustomerBuilder;
import com.u2team.huansync.ticketOffice.client.model.classes.builders.CustomerConcreteBuilder;

/**
 * Data Access Object (DAO) implementation for managing Customer entities in a database.
 *
 * Usage example:
 * <pre>{@code
 * CustomerDAO customerDAO = new CustomerDAO();
 *
 * // Retrieve a customer by ID
 * Customer customer = customerDAO.getById(1);
 *
 * // Retrieve all customers
 * List<Customer> allCustomers = customerDAO.getAll();
 *
 * // Save a new customer
 * Customer newCustomer = new Customer();
 * // Set customer properties...
 * customerDAO.save(newCustomer);
 *
 * // Update an existing customer
 * Customer existingCustomer = customerDAO.getById(1);
 * // Modify customer properties...
 * customerDAO.update(existingCustomer);
 *
 * // Delete a customer by ID
 * customerDAO.delete(1);
 * }</pre>
 *
 * @author SANTOS
 */
public class CustomerDAO implements IDao<Customer> {

    /**
     * Retrieves a customer by its unique identifier.
     *
     * @param id The unique identifier of the customer.
     * @return The customer with the specified identifier, or null if not found.
     */
    @Override
    public Customer getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_customers WHERE customerId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                CustomerBuilder customerBuilder = new CustomerConcreteBuilder();
                Customer sqlCustomer = customerBuilder.customerId(rs.getLong("customerId"))
                        .nameCustomer(rs.getString("nameCustomer"))
                        .document(rs.getString("document"))
                        .gender(rs.getString("gender"))
                        .birthDate(LocalDate.parse(rs.getString("birthDate")))
                        .email(rs.getString("emailCustomer"))
                        .phoneNumber(rs.getString("phoneNumber"))
                        .customerTypeEnum(rs.getString("typeCustomer"))
                        .build();

                return sqlCustomer;
            } else {
                System.out.println("Error: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Searches for a participant with the specified identifier.
     *
     * @param id The identifier of the participant to be searched.
     * @return true if the participant is found, false otherwise.
     */
    @Override
    public boolean searchParticipant(int id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String query = "SELECT * FROM tbl_customers WHERE customerId = ?";
        int idParticipant = id;
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(query)) {
            ps.setInt(1, idParticipant);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves a list of all customers.
     *
     * @return A list containing all customers.
     */
    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();

        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_customers";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                CustomerBuilder customerBuilder = new CustomerConcreteBuilder();

                Customer sqlCustomer = customerBuilder.customerId(rs.getLong("customerId"))
                        .nameCustomer(rs.getString("nameCustomer"))
                        .document(rs.getString("document"))
                        .gender(rs.getString("gender"))
                        .birthDate(LocalDate.parse(rs.getString("birthDate")))
                        .email(rs.getString("emailCustomer"))
                        .phoneNumber(rs.getString("phoneNumber"))
                        .customerTypeEnum(rs.getString("typeCustomer"))
                        .build();

                customerList.add(sqlCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    /**
     * Saves a new customer to the database.
     *
     * @param customer The customer to be saved.
     */
    @Override
    public void save(Customer customer) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_customers(nameCustomer , document, gender , birthDate , emailCustomer , phoneNumber , typeCustomer) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getDocument());
            ps.setString(3, customer.getGender());
            ps.setString(4, customer.getBirthDate().toString());
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getPhoneNumber());
            ps.setString(7, customer.getCustomerTypeEnum().name());

            int rows = Operations.insert_update_delete_db(ps);

            if (rows <= 0) {
                System.out.println("Cannot insert customer");
            } else {
                System.out.println("Successful insert customer");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing customer in the database.
     *
     * @param customer The customer to be updated.
     */
    @Override
    public void update(Customer customer) {
        Customer sqlCustomer = getById(customer.getCustomerId());

        if (sqlCustomer != null) {
            sqlCustomer.setName(customer.getName());
            sqlCustomer.setDocument(customer.getDocument());
            sqlCustomer.setGender(customer.getGender());
            sqlCustomer.setBirthDate(customer.getBirthDate());
            sqlCustomer.setEmail(customer.getEmail());
            sqlCustomer.setPhoneNumber(customer.getPhoneNumber());
            sqlCustomer.setCustomerTypeEnum(customer.getCustomerTypeEnum());

            String stmInsert = """
                UPDATE tbl_customers
                SET nameCustomer = ?,
                    document = ?,
                    gender = ?,
                    birthDate = ?,
                    emailCustomer = ?,
                    phoneNumber = ?,
                    typeCustomer = ?
                    WHERE customerId = ?;      
                               """;

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
                ps.setString(1, customer.getName());
                ps.setString(2, customer.getDocument());
                ps.setString(3, customer.getGender());
                ps.setString(4, customer.getBirthDate().toString());
                ps.setString(5, customer.getEmail());
                ps.setString(6, customer.getPhoneNumber());
                ps.setString(7, customer.getCustomerTypeEnum().name());
                ps.setLong(8, sqlCustomer.getCustomerId());

                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update customer");
                } else {
                    System.out.println("Successful update customer");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("not found results customer");

        }
    }

    /**
     * Deletes a customer by its unique identifier from the database.
     *
     * @param customerId The unique identifier of the customer to be deleted.
     */
    @Override
    public void delete(long customerId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_customers WHERE customerId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, customerId);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete client");
                return;
            } else {
                System.out.println("not exists client");
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete client");
        return;
    }
}
