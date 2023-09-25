package BigLinkedList;

import static java.lang.System.out;

public class comlist {
    private node myroot;

    public comlist() {myroot = null;}

    // Add a node to the front of the list
    public void addfront (node stuff) {
        if (myroot == null) {
            myroot = stuff;
            return;
        }

        stuff.next = myroot;
        myroot = stuff;
    }
    // Print the list
    public void printList() {
        if(myroot == null) {
            out.println("The list is empty");
            return;
        }
        node temp = myroot;
        while(temp != null) {
            out.print(temp + " ");
            temp = temp.next;
        }
        out.println();

    }
    // Add a node to the back of the list
    public void addlast(node stuff) {
        if (myroot == null) {
            myroot = stuff;
            return;
        }

        node temp = myroot;
        while (temp.next != null) temp = temp.next;
        temp.next = stuff;
    }

    // Print the number of nodes
    public int getCount() {
        int cnt = 0;
        if (myroot == null) return cnt;
        node temp = myroot;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    //Insert a  node into a certain spot if possible
    public void addNum(node num, int spot) {
        if (myroot == null) {
            out.println("Linked List is empty, try adding a number at spot 0 instead.");
            return;
        }
        if (spot > getCount() + 1) {
            out.println("Linked List is only " + getCount() + " nodes long, try a smaller number.");
            return;
        }
        if (spot == 1) addfront(num);
        node temp = myroot;
        for (int i = 0; i < spot - 1; i ++) {
            temp = temp.next;
        }
        node newNode = num;
        newNode.next = temp.next;
        temp.next = newNode;

    }

    // Check to see if list is empty
    public boolean isEmpty() {
        return myroot == null;
    }

    // Check to see if a number exists
    public boolean isThere(int n) {
        if (myroot == null) return false;
        node temp = myroot;
        while (temp != null){
            if (temp.getval() == n) return true;
            temp = temp.next;
        }
        return false;
    }

    // Get first number
    public int getfirst() {
        if (myroot == null) {
            out.println("List is empty.");
            return 0;
        }
        else return myroot.getval();
    }

    // Get last public
    public int getLast() {
        if (myroot == null) {
            out.println("The list is empty.");
        }
        node temp = myroot;
        while (temp.next != null) temp = temp.next;
        return temp.getval();
    }

    // Get a number at a certain spot;
    public int getSpot (int spot) {
        node temp = myroot;
        if (myroot == null) {
            out.println("The list is empty.");
            return -1;
        } else if ( spot > getCount() - 1) {
            out.println("Invalid index for size " + getCount());
        } else {
            for (int i = 0; i < spot; i ++) {
                temp = temp.next;
            }
            return temp.getval();
        }
        return -1;
    }
    // Get rid of first node;
    public void removeFirst() {
        if (myroot == null) {
            out.println("The list is empty.");
            return;
        }
        node temp = myroot;
        while (temp.next != null) {
            temp.setVal(temp.next.getval());
            temp = temp.next;
        }
        temp = myroot;
        while (temp.next.next != null) {temp = temp.next;}
        temp .next= null;
    }
    // Get rid of last node
    public void removeLast() {
        if (myroot == null) {
            out.println("The list is empty.");
            return;
        }
        node temp = myroot;
        while (temp.next.next != null) {temp = temp.next;}
        temp .next= null;
    }
    // Count the number of nodes under 10
    public int countLess10() {
        if (myroot == null) {
            out.println("The list is empty.");
            return -1;
        }
        int less10 = 0;
        node temp = myroot;
        while (temp.next != null) {
            if (temp.getval() < 10) less10++;
            temp = temp.next;
        }
        return less10;
    }
    // Get rid of a node at a certain point
    public void removeSpot (int num){
        if (myroot == null) {
            out.println("The list is empty.");
            return;
        }
        node temp = myroot;
        for (int i = 0; i < getCount() - 1; i++) {
            if (i == num - 1) {temp.next = temp.next.next;}
            else temp = temp.next;
        }
    }

    // Print in reverse order
    public void printReverseSetup() {
        node temp = myroot;
        printReverse(temp);
    }
    public void printReverse(node temp) {
        if (temp == null) return;
        printReverse(temp.next);
        out.print(temp.getval() + " ");
    }


}


