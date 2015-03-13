class Vehicle { // implicit extends Object
    void start() { }
    int getColor() { return 9; }
}
class Car extends Vehicle {
    void start() { }
    void setDoors(int n) { }
}
class Truck extends Vehicle {
    void start() { }
    void setPayload(int n) { }
}

Truck t;
t = new Truck();
t.start();
t.setPayload(32);
