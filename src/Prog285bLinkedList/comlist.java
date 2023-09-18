// Alex Nouansacksy
// 9/18/2023
// comlist for 285b Linked List
package Prog285bLinkedList;
import static java.lang.System.out;
public class comlist {
    private node myroot;

    public comlist() {
        myroot = null;
    }

    public void addfirst(node stuff) {
        if (myroot == null) {
            myroot = stuff;
            return;
        }

        stuff.next = myroot;
        myroot = stuff;
    }

    public void addlast(node stuff) {
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
    public void delete () {
        if (myroot == null) return;
        while ((myroot != null) && myroot.getCom() == 0) myroot = myroot.next;
        if (myroot == null) return;

        node prev = myroot;
        node temp = myroot.next;

        while (temp != null) {
            if (temp.getCom() == 0) {
                prev.next = temp.next;
                temp = temp.next;
            }
            else {
                prev = temp;
                temp = temp.next;
            }

        }
    }
    public void calc() {
        if (myroot == null) {
            return;
        }

        node temp = myroot;
        while(temp != null) {
            temp.setcom();
            temp = temp.next;
        }

    }

    public void print() {
        if(myroot == null) {
            out.println("The list is empty");
            return;
        }

        node temp = myroot;
        while(temp != null) {
            out.println(temp); // same thing as out.println(temp.toString);
            temp = temp.next;
        }
    }


}
/*
101 17 2250.0 213.75
103 5 4000.0 300.0
117 3 7350.0 0.0
118 8 7350.0 574.75
125 5 6500.0 502.5
138 17 6375.0 677.5
192 8 8125.0 640.625
203 8 3250.0 243.75
218 5 5000.0 375.0
235 5 5250.0 396.25
264 17 4150.0 410.5
291 17 750.0 71.25

101 17 2250.0 213.75
103 5 4000.0 300.0
118 8 7350.0 574.75
125 5 6500.0 502.5
138 17 6375.0 677.5
192 8 8125.0 640.625
203 8 3250.0 243.75
218 5 5000.0 375.0
235 5 5250.0 396.25
264 17 4150.0 410.5
291 17 750.0 71.25

Process finished with exit code 0
 */
