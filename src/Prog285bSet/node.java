package Prog285bSet;

public class node {
    private int myid;
    private int mycode;
    private double mysales;
    private double mycom;

    public node (int id, int c, double s) {
        myid = id;
        mycode = c;
        mysales = s;
        mycom = 0;
    }

    public void setcom() {
        if ((mycode == 5) || (mycode == 8)) {
            if (mysales <= 5000) mycom = .075 * mysales;
            else mycom = .075 * 5000 + (mysales - 5000) * .085;
        }

        if (mycode == 17) {
            if (mysales <= 3500) mycom = 0.095 * mysales;
            else mycom = .095 * 3500 + (mysales - 3500) * .12;
        }
    }

    public int getid () {return myid;}
    public double getcom() {return mycom;}
    public int getcode() {return mycode;}
    public double getsales() {return mysales;}

    public void setdata(int id, int code, double sales, double commission) {
        myid = id;
        mycode = code;
        mysales = sales;
        mycom = commission;
    }

    public String toString() {
        return myid + " " + mycode + " " + mysales + " " + mycom;
    }

}
