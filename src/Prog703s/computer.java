package Prog703s;

public class computer implements comps{
    private String myName;
    private int myNumber;
    private double myValue;

    public computer (String name, int num, double val) {
        myName = name;
        myValue = val;
        myNumber = num;
    }

    public String getName() {return myName;}
    public int getNumber() {return myNumber;}
    public double getValue() {return myValue;}
}
