package CodingQuest;

public class Day1Class {
    private String myname;
    private double cost;

    public Day1Class(String name) {
        myname = name;
        cost = 0;
    }

    public void addCost(double n) {cost += n;}
    public void minusCost(double n) {cost -= n;}
    public String getName() {return myname;}
    public double getCost() {return cost;}

}
