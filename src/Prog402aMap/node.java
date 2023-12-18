package Prog402aMap;

public class node {
    private int myID;
    private int myScore;
    private double myDiff;

    public node (int id, int score) {
        myID = id;
        myScore = score;
    }

    public void setDiff(double avg) {
        myDiff = myScore - avg;
    }

    public int getID() {return myID;}
    public int getScore() {return myScore;}
    public double getDiff() {return myDiff;}

    public String toString() {return myID + String.format("\t\t%d\t\t%.2f", myScore, myDiff);}

}
