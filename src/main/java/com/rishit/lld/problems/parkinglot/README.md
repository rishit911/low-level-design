# 🚗 Parking Lot – Low Level Design (LLD)

## 📌 Problem Statement
Design a **Parking Lot System** that supports:
- Different vehicle types (Car, Bike, Truck).
- Different slot types (Compact, Bike, Large).
- Parking/Unparking with ticket generation.
- Pricing strategy (per hour rates).
- A Singleton ParkingLot manager.

---

## 🏗️ Class Diagram

ParkingLot (Singleton)
├── List<ParkingSlot>
├── Map<String, Ticket> activeTickets
├── parkVehicle(Vehicle): Ticket
└── unparkVehicle(ticketId): void

ParkingSlot
├── slotId
├── slotType (SlotType)
├── parkedVehicle (Vehicle)

Vehicle (abstract)
├── Car
├── Bike
└── Truck

Ticket
├── ticketId
├── vehicle
├── slot
├── entryTime, exitTime
├── price

PricingStrategy (interface)
└── HourlyPricingStrategy

yaml
Copy code

---

## 📂 Folder Structure
parkinglot/
│── Enums.java # VehicleType, SlotType
│── Vehicle.java # Base class
│── Car.java, Bike.java, Truck.java
│── ParkingSlot.java # Slot details
│── Ticket.java # Ticket model
│── PricingStrategy.java # Strategy pattern
│── ParkingLot.java # Singleton manager
│── README.md # This file

yaml
Copy code

---

## ▶️ How to Run

### 1. Compile & Run with Maven
From repo root:
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.rishit.lld.demos.ParkingLotDemo"
✅ Sample Output
java
Copy code
✅ Vehicle KA01AB1234 parked at slot A1 (Ticket: 8cda...f12)
✅ Vehicle KA02XY4567 parked at slot B1 (Ticket: 123a...89b)
✅ Vehicle KA03PQ7890 parked at slot C1 (Ticket: 77c2...9dd)
🚗 Vehicle KA01AB1234 unparked. Total Price = ₹20
🚗 Vehicle KA02XY4567 unparked. Total Price = ₹10
⚠️ Invalid Ticket!
🔑 Design Highlights
Singleton Pattern → Only one ParkingLot manager.

Strategy Pattern → Pricing calculation (easy to extend with daily/flat pricing).

Inheritance → Car, Bike, Truck extend Vehicle.

Clean Separation → Core logic in problems/, demo runner in demos/.

🎯 Extensions (for interviews)
Add multiple levels/floors.

Add reservation system.

Add admin dashboard for available/free slots.

Implement real-time notifications (Observer pattern).

yaml
Copy code

---

👉 Now, in your **root README.md**, add a link under **Problems**:

```markdown
## Problems
- [Parking Lot](src/main/java/com/rishit/lld/problems/parkinglot/README.md)