package Prog408aMap;

public class node {
    private int myId;
    private int myScore;

    public node (int id, int score) {
        myId = id;
        myScore = score;
    }

    public int getID() {return myId;}
    public int getScore() {return myScore;}

    public String toString() {return myId + "\t" + myScore;}
}