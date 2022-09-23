package com.mycompany.pojo;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ticket")
public class Ticket {

    @Id
    @Column(name="TicketID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;
    
   
    @Basic
    @Column(name="BookingDate")
    private Date dateOfBookingTicket;
    
    @Basic
    @Column(name="TravelDate")
    private Date dateOfTravel;
    
    @Basic
    @Column(name="TicketRegistrationNumber")
    private int ticketRegistrationNumber;
    
    @Basic
    @Column(name="NumberOfAdults")
    private int numberOfAdults;
    
    @Basic
    @Column(name="NumberOfChildren")
    private int numberOfChildren;
    
    @Basic
    @Column(name="EmailID")
    private String emailAddress;
    
    @Basic
    @Column(name="BusNumber")
    private int busNumber;

    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }
    
    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public Date getDateOfBookingTicket() {
        return dateOfBookingTicket;
    }

    public void setDateOfBookingTicket(Date dateOfBookingTicket) {
        this.dateOfBookingTicket = dateOfBookingTicket;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getTicketRegistrationNumber() {
        return ticketRegistrationNumber;
    }

    public void setTicketRegistrationNumber(int ticketRegistrationNumber) {
        this.ticketRegistrationNumber = ticketRegistrationNumber;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

}
