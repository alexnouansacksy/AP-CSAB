package Prog402aLinkedList;

public class node {
    private int myID;
    private int myScore;
    private double myDiff;
    public node next;

    public node (int id, int score) {
        myID = id;
        myScore = score;
        next = null;
    }

    public void setDiff(double avg) {
        myDiff = myScore - avg;
    }

    public int getID() {return myID;}
    public int getScore() {return myScore;}
    public double getDiff() {return myDiff;}

}
