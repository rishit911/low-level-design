package com.rishit.lld.problems.parkinglot;

import com.rishit.lld.problems.parkinglot.Enums.VehicleType;

public class Car extends Vehicle {
    public Car(String numberPlate){
        super(numberPlate, VehicleType.CAR);
    }
}
