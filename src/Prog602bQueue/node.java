package Prog602bQueue;

public class node {
    private int accountNum;
    private double hours;
    private int code;
    private double amountDue;

    public node(int accNum, double hrs, int theCode) {
        accountNum = accNum;
        hours = hrs;
        code = theCode;
        amountDue = 0;
    }

    public void calc() {
        if (code == 1) amountDue += 50;
        else if (code == 2) amountDue += 150;

        if (hours <= 5) amountDue += 200;
        else if (hours <= 15) amountDue += (200 + 50 * (hours - 5));
        else if (hours > 15) amountDue += (550 + 30 * (hours - 15));
    }

    public String toString() {return accountNum + "\t" + hours + "\t" + code + "\t" + amountDue;}
}
