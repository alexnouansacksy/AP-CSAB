package BigLinkedList;

public class node {
    private int myNum;
    public node next;

    private node (int num) {
        myNum = num;
        next = null;
    }

    public int getval() {return myNum;}
    public String toString() {return myNum + "";}


}
