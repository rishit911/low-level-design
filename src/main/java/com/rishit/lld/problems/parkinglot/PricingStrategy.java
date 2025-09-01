package com.rishit.lld.problems.parkinglot;

public interface PricingStrategy {
    double calculatePrice(Ticket ticket);
}

class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Ticket ticket) {
        switch(ticket.getVehicle().getType()){
            case BIKE: return ticket.getParkingDurationInHours() * 10;
            case CAR: return ticket.getParkingDurationInHours() * 20;
            case TRUCK: return ticket.getParkingDurationInHours() * 30;
            default: return 0;
        }
    }
}
