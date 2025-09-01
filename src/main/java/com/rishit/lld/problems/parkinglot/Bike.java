package com.rishit.lld.problems.parkinglot;

import com.rishit.lld.problems.parkinglot.Enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String numberPlate){
        super(numberPlate, VehicleType.BIKE);
    }
}
