package Prog1060hQueue;

public class node {
    private String name;
    private double mileage;
    private double perDay;
    private double perMile;

    public node(String car, double miles, double costDay, double costMile) {
        name = car;
        mileage = miles;
        perDay = costDay;
        perMile = costMile;
    }

    public double getMiles() {return mileage;}
    public String getName() {return name;}
    public double dayCost() {return perDay;}
    public double mileCost() {return perMile;}

    public String toString() {return name + "\t" + mileage;}
}
