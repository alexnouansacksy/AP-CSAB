package BigLinkedList;

public class node {
    private int myNum;
    public node next;

    public node (int num) {
        myNum = num;
        next = null;
    }

    public void setVal(int num) {
        myNum = num;
    }

    public int getval() {return myNum;}
    public String toString() {return myNum + "";}
}
