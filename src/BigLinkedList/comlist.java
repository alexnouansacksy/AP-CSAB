// Alex Nouansacksy
// Big Linked List
// 9/20/2023

package BigLinkedList;

import static java.lang.System.out;
import java.util.*;
import java.util.Iterator;


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
    // Clear the entire list
    public void clear() {
        myroot = null;
    }
    // check for num
    public boolean checkForNum(int n) {
        node temp = myroot;
        if (temp == null) {
            out.println("The list is empty.");
            return false;
        }
        while (temp.next != null) {
            if (temp.getval() == n) {
                out.print("The number " + n + " is in the list.");
                return true;
            }
            temp = temp.next;
        }
        out.print("The number " + n + " is not in the list.");
        return false;
    }
    // Get the number at a certain position
    public int getNum(int pos) {
        node temp = myroot;
        if (temp == null) return -1;
        if (pos > getCount()) return -1;
        for (int i = 0; i < pos; i++) temp = temp.next;
        return myroot.getval();
    }
    // Create a reverse copy of the list
    public comlist getReverse() {
        node temp = myroot;
        comlist reverse = new comlist();
        while (temp != null) {
            node add = new node(temp.getval());
            reverse.addfront(add);
            temp = temp.next;
        }
        return reverse;
    }
    // Create an iterator over the numbers
    public Iterator<Integer> makeInterator() {
        if (myroot == null) return null;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        node temp = myroot;
        while (temp.next != null) {
            nums.add(temp.getval());
            temp = temp.next;
        }
        nums.add(temp.getval());
        return nums.iterator();
    }
    // Average the set of numbers
    public double avg() {
        if (myroot == null) return 0;
        node temp = myroot;
        double avg = 0;
        while (temp.next != null) {
            avg += temp.getval();
            temp = temp.next;
        }
        avg /= getCount();
        return avg;
    }
    // Find the min of the numbers;
    public int min() {
        if (myroot == null) return 0;
        node temp = myroot;
        int min = myroot.getval();
        while (temp.next != null) {
            if (temp.getval() < min) min = temp.getval();
            temp = temp.next;
        }
        return min;
    }
    // Find the max of the numbers;
    public int max() {
        if (myroot == null) return 0;
        node temp = myroot;
        int max = temp.getval();
        while (temp.next != null) {
            if (temp.getval()  > max) max = temp.getval();
            temp = temp.next;
        }
        return max;
    }
    // Find the slot number of the biggest first occurrence
    public int findSlotMaxFirst() {
        if (myroot == null) return -1;
        node temp = myroot;
        int cnt = 0;
        while (temp.next != null) {
            if (temp.getval() == max()) return cnt;
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
    // Find the slot number of the biggest last occurrence
    public int findSlotMaxLast() {
        comlist reverse = getReverse();
        return reverse.findSlotMaxFirst();
    }

    // Sort all the numbers
    public void sort() {
        comlist sorted = new comlist();
        node temp = myroot;
        while (temp.next.getval() != min()) {
            temp = temp.next;
        }

    }



}



