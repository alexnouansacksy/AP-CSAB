package Prog408aLinkedList;

public class node {
    private int myId;
    private int myScore;
    public node next;

    public node (int id, int score) {
        myId = id;
        myScore = score;
        next = null;
    }

    public int getID() {return myId;}
    public int getScore() {return myScore;}
}
