package Prog703s;

public class linux extends computer{
    private int mySpecialCode;

    public linux(String name, int number, double value, int code) {
        super(name, number, value);
        mySpecialCode = code;
    }
    public double getMySpecialCode() {return mySpecialCode;}
}
