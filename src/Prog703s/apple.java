package Prog703s;

public class apple extends computer{
    private String myColor;

    public apple (String name, int num, double value, String col) {
        super(name, num, value);
        myColor = col;
    }

    public String getColor() {return myColor;}
}
