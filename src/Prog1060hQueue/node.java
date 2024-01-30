package Prog1060hQueue;

public class node {
    private String name;
    private double mileage;

    public node(String car, double miles) {
        name = car;
        mileage = miles;
    }

    public String toString() {return name + "\t" + mileage;}
}
