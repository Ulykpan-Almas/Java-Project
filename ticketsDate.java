package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class ticketsDate implements Serializable {
    private String operationType;
    ArrayList<tickets> tickets=new ArrayList<>();
    private tickets ticket;

    public ticketsDate(String operationType, ArrayList<com.company.tickets> tickets, com.company.tickets ticket) {
        this.operationType = operationType;
        this.tickets = tickets;
        this.ticket = ticket;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<com.company.tickets> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<com.company.tickets> tickets) {
        this.tickets = tickets;
    }

    public com.company.tickets getTicket() {
        return ticket;
    }

    public void setTicket(com.company.tickets ticket) {
        this.ticket = ticket;
    }
}
