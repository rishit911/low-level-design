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


📂 Folder Structure
parkinglot/
│── Enums.java
│── Vehicle.java
│── Car.java, Bike.java, Truck.java
│── ParkingSlot.java
│── Ticket.java
│── PricingStrategy.java
│── ParkingLot.java
│── README.md   <-- this file

▶️ How to Run
Compile & Run with Maven

From project root:

mvn clean compile
mvn exec:java -Dexec.mainClass="com.rishit.lld.demos.ParkingLotDemo"

✅ Sample Output
✅ Vehicle KA01AB1234 parked at slot A1 (Ticket: 8cda...f12)
✅ Vehicle KA02XY4567 parked at slot B1 (Ticket: 123a...89b)
✅ Vehicle KA03PQ7890 parked at slot C1 (Ticket: 77c2...9dd)
🚗 Vehicle KA01AB1234 unparked. Total Price = ₹20
🚗 Vehicle KA02XY4567 unparked. Total Price = ₹10
⚠️ Invalid Ticket!

🔑 Design Highlights

Singleton Pattern → ParkingLot ensures only one manager exists.

Strategy Pattern → PricingStrategy allows multiple billing methods.

Inheritance → Car, Bike, Truck extend Vehicle.

Extensible → Easy to add more vehicles, slot types, or pricing rules.