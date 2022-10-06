package model;

public class Vehicle {
    String name;
    String number;

    public Vehicle(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
