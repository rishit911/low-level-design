package com.rishit.lld.problems.parkinglot;

import com.rishit.lld.problems.parkinglot.Enums.VehicleType;

public class Truck extends Vehicle {
    public Truck(String numberPlate){
        super(numberPlate, VehicleType.TRUCK);
    }
}
