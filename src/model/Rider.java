package model;

public class Rider extends User{
    Location source, destination;

    public Rider(Rider rider, Location source, Location destination) {
        super(rider.name, rider.gender, rider.age);
        this.source = source;
        this.destination = destination;
    }

    public Rider(String name, Gender gender, int age) {
        super(name, gender, age);
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Rider{" +
                "name='" + name + '\'' +
                ", gender='" + gender.toString() + '\'' +
                ", age=" + age +
                '}';
    }
}
