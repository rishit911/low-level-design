# 🚗 Parking Lot – Low Level Design (LLD)

## 📌 Problem Statement
Design a **Parking Lot System** that supports:
- Different vehicle types (Car, Bike, Truck).
- Different slot types (Compact, Bike, Large).
- Parking/Unparking with ticket generation.
- Pricing strategy (per hour rates).
- A Singleton ParkingLot manager.

---

## 🏗️ UML Class Diagram

```mermaid
classDiagram
    %% ==========================
    %% Enums
    %% ==========================
    class VehicleType {
      <<enumeration>>
      CAR
      BIKE
      TRUCK
    }

    class SlotType {
      <<enumeration>>
      COMPACT
      BIKE
      LARGE
    }

    %% ==========================
    %% Vehicle hierarchy
    %% ==========================
    class Vehicle {
      <<abstract>>
      - numberPlate : String
      - type : VehicleType
      + getNumberPlate() : String
      + getType() : VehicleType
    }
    class Car
    class Bike
    class Truck

    Vehicle <|-- Car
    Vehicle <|-- Bike
    Vehicle <|-- Truck

    %% ==========================
    %% ParkingSlot
    %% ==========================
    class ParkingSlot {
      - slotId : String
      - slotType : SlotType
      - parkedVehicle : Vehicle
      + isAvailable() : boolean
      + assignVehicle(v: Vehicle) : void
      + removeVehicle() : void
    }

    %% ==========================
    %% Ticket
    %% ==========================
    class Ticket {
      - ticketId : String
      - vehicle : Vehicle
      - slot : ParkingSlot
      - entryTime : LocalDateTime
      - exitTime : LocalDateTime
      - price : double
      + closeTicket() : void
      + getParkingDurationInHours() : long
      + setPrice(p: double) : void
      + getPrice() : double
    }

    %% ==========================
    %% Pricing Strategy
    %% ==========================
    class PricingStrategy {
      <<interface>>
      + calculatePrice(t: Ticket) : double
    }

    class HourlyPricingStrategy {
      + calculatePrice(t: Ticket) : double
    }

    PricingStrategy <|.. HourlyPricingStrategy

    %% ==========================
    %% ParkingLot (Singleton)
    %% ==========================
    class ParkingLot {
      <<Singleton>>
      - instance : ParkingLot
      - slots : List<ParkingSlot>
      - activeTickets : Map<String, Ticket>
      - pricingStrategy : PricingStrategy
      + getInstance() : ParkingLot
      + parkVehicle(v: Vehicle) : Ticket
      + unparkVehicle(ticketId: String) : void
      - isSlotSuitable(slot: ParkingSlot, v: Vehicle) : boolean
    }

    %% ==========================
    %% Relationships
    %% ==========================
    ParkingLot "1" --> "*" ParkingSlot
    ParkingLot "1" --> "*" Ticket
    Ticket --> Vehicle
    Ticket --> ParkingSlot
    ParkingSlot --> Vehicle
