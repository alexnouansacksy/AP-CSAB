package Prog408aLinkedList;


import static java.lang.System.out;

public class comlist {
    private node myroot;

    public comlist() {
        myroot = null;
    }

    public void add(node stuff) {
        if (myroot == null) {
            myroot = stuff;
            return;
        }

        node temp = myroot;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = stuff;

    }

    public int getCount() {
        if (myroot == null) return 0;
        node temp = myroot;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        return cnt;
    }

    public void print() {
        if (myroot == null) return;
        node temp = myroot;
        while (temp != null) {
            out.printf("%d\t%d", temp.getID(), temp.getScore());
            temp = temp.next;
        }
    }
}