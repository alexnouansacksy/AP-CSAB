package Prog285bLinkedList;

public class node {
    private int myid;
    private int mycode;
    private double mysales;
    private double mycom;
    public node next;

    public node(int id, int code, double sales) {
        myid = id;
        mycode = code;
        mysales = sales;
        mycom = 0;
        next = null;
    }

    public int getID() {return myid;}
    public int getCode() {return mycode;}
    public double getSales() {return mysales;}
    public double getCom() {return mycom;}

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

    public String toString() {
        return myid + " " + mycode + " " + mysales + " " + mycom;
    }
}
