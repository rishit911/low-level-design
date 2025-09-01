package com.rishit.lld.demos;

import com.rishit.lld.problems.parkinglot.*;

public class ParkingLotDemo {
    public static void main(String args[]) throws InterruptedException {
        ParkingLot lot=ParkingLot.getInstance();

        Vehicle car=new Car("KA01AB1234");
        Vehicle bike=new Bike("KA02XY4567");
        Vehicle truck=new Truck("KA03PQ7890");

        Ticket carTicket=lot.parkVehicle(car);
        Ticket bikeTicket=lot.parkVehicle(bike);
        Ticket truckTicket=lot.parkVehicle(truck);

        Thread.sleep(2000);

        lot.unparkVehicle(carTicket.getTicketId());
        lot.unparkVehicle(bikeTicket.getTicketId());
        lot.unparkVehicle("invalid_ticket");
    }
}