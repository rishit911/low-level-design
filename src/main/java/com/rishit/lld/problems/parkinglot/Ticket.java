package com.rishit.lld.problems.parkinglot;

import java.time.*;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSlot slot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double price;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSlot slot){
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
    }

    public void closeTicket(){
        this.exitTime = LocalDateTime.now();
    }

    public long getParkingDurationInHours(){
        return Duration.between(entryTime, exitTime).toHours() + 1;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public String getTicketId(){
        return ticketId;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public ParkingSlot getSlot(){
        return slot;
    }
}
