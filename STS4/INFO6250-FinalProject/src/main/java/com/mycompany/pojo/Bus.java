package com.mycompany.pojo;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="bus")
public class Bus {
    
    
    @Id
    @Column(name="BusID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busID;
    
    @Basic
    @Column(name="BusNumber")
    private int busNumber;
    
    @Basic
    @Column(name="SourceLocation")
    private String  sourceLocation;

    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }
    
    @Basic
    @Column(name="DestinationLocation")
    private String destinationLocation;
    
    @Basic
    @Column(name="TotalSeats")
    private int totalSeatsAvailable;
    
    @Basic
    @Column(name="DepartureDate")
    private Date departureDate;

    public int getBusNumber() {
        return busNumber;
    }

        public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public int getTotalSeatsAvailable() {
        return totalSeatsAvailable;
    }

    public void setTotalSeatsAvailable(int totalSeatsAvailable) {
        this.totalSeatsAvailable = totalSeatsAvailable;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

}
