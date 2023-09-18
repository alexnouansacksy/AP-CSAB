// Alex Nouansacksy
// 9/18/2023
// 285b Linked List
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
