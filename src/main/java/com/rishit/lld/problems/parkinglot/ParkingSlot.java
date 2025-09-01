package com.rishit.lld.problems.parkinglot;

import com.rishit.lld.problems.parkinglot.Enums.SlotType;

public class ParkingSlot {
    private String slotId;
    private SlotType slotType;
    private Vehicle parkedVehicle;

    public ParkingSlot(String slotId, SlotType slotType){
        this.slotId = slotId;
        this.slotType = slotType;
    }

    public boolean isAvailable(){
        return parkedVehicle==null;
    }

    public void assignVehicle(Vehicle vehicle){
        this.parkedVehicle = vehicle;
    }

    public void removeVehicle(){
        this.parkedVehicle = null;
    }

    public Vehicle getVehicle(){
        return parkedVehicle;
    }

    public String getSlotId(){
        return slotId;
    }

    public SlotType getSlotType(){
        return slotType;
    }
}
