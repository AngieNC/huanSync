package com.u2team.huansync.ticketOffice.model.DAO;

import java.util.List;

public interface IDao<T> {
    
    T getById(long id);
    
    List<T> getAllTicketOffice();
    
    void insertTicketOffice(T t);
    
    void updateTicketOffice(T t);
    
    void deleteTicketOffice(long id);

}
