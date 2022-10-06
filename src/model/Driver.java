package model;

public class Driver extends User{
    Vehicle vehicle;
    Location location;
    boolean availability=true;

    public Driver(String name, Gender gender, int age, Vehicle vehicle, Location location) {
        super(name, gender, age);
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.vehicle = vehicle;
        this.location = location;
    }

    public Driver(String name, Gender gender, int age, Vehicle vehicle, Location location, boolean availability) {
        super(name, gender, age);
        this.vehicle = vehicle;
        this.location = location;
        this.availability = availability;
    }

    public Driver(Driver driver, boolean availability){
        this(driver.name, driver.gender, driver.age, driver.vehicle, driver.location, availability);
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Location getLocation() {
        return location;
    }

    public boolean getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", gender='" + gender.toString() + '\'' +
                ", age=" + age +
                ", vehicle=" + vehicle +
                ", location=" + location +
                '}';
    }
}
