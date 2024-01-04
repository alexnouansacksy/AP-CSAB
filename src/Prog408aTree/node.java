package Prog408aTree;

public class node {
    private int myId;
    private int myScore;
    public node myleft;
    public node myright;

    public node (int id, int score) {
        myId = id;
        myScore = score;
        myleft = null;
        myright = null;
    }

    public int getID() {return myId;}
    public int getScore() {return myScore;}

    public String toString() {return myId + "\t" + myScore;}
}