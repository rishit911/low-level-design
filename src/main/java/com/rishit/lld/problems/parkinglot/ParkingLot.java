package com.rishit.lld.problems.parkinglot;

import com.rishit.lld.problems.parkinglot.Enums.SlotType;
import com.rishit.lld.problems.parkinglot.Enums.VehicleType;
import java.util.*;

public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingSlot> slots = new ArrayList<>();
    private Map<String, Ticket> activeTickets = new HashMap<>();
    private PricingStrategy pricingStrategy = new HourlyPricingStrategy();

    private ParkingLot() {
        slots.add(new ParkingSlot("A1", SlotType.COMPACT));
        slots.add(new ParkingSlot("A2", SlotType.COMPACT));
        slots.add(new ParkingSlot("B1", SlotType.BIKE));
        slots.add(new ParkingSlot("C1", SlotType.LARGE));
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingSlot slot : slots) {
            if (slot.isAvailable() && isSlotSuitable(slot, vehicle)) {
                slot.assignVehicle(vehicle);
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, slot);
                activeTickets.put(ticket.getTicketId(), ticket);
                System.out.println("Vehicle " + vehicle.getNumberPlate() + " parked at slot" + slot.getSlotId()
                        + " (Ticket: " + ticket.getTicketId() + ")");
                return ticket;
            }
        }
        System.out.println("No available slots for " + vehicle.getType());
        return null;
    }

    public void unparkVehicle(String ticketId) {
        if (!activeTickets.containsKey(ticketId)) {
            System.out.println("Invalid Ticket");
            return;
        }
        Ticket ticket = activeTickets.remove(ticketId);
        ticket.closeTicket();
        ticket.setPrice(pricingStrategy.calculatePrice(ticket));
        ticket.getSlot().removeVehicle();
        System.out.println(
                "Vehicle " + ticket.getVehicle().getNumberPlate() + " unparked. Total Price = " + ticket.getPrice());
    }

    private boolean isSlotSuitable(ParkingSlot slot, Vehicle vehicle) {
        if (vehicle.getType() == VehicleType.BIKE && slot.getSlotType() == SlotType.BIKE)
            return true;
        if (vehicle.getType() == VehicleType.CAR && slot.getSlotType() == SlotType.COMPACT)
            return true;
        if (vehicle.getType() == VehicleType.TRUCK && slot.getSlotType() == SlotType.LARGE)
            return true;
        return false;
    }
}