package Prog703s;

public class windows extends computer{
    private double myVersionNumber;

    public windows (String name, int num, double value, double version) {
        super(name, num, value);
        myVersionNumber = version;
    }
    public double getVersionNumber() {return myVersionNumber;}
}
