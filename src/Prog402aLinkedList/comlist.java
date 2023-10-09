// Prog 402a with Linked Lists
// Alex Nouansacksy
// 10/04/2023

package Prog402aLinkedList;

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

    public double getAverage() {
        if (myroot == null) return 0;
        node temp = myroot;
        int tot = 0;
        while (temp != null) {
            tot+= temp.getScore();
            temp = temp.next;
        }
        double average = tot / (double) getCount();
        return average;
    }

    public void setAverages() {
        if (myroot == null) return;
        node temp = myroot;
        while (temp != null) {
            temp.setDiff(getAverage());
            temp = temp.next;
        }
    }

    public void print() {
        if (myroot == null) return;
        node temp = myroot;
        while (temp != null) {
            out.printf("%d\t%d\t\t%.2f\n", temp.getID(), temp.getScore(), temp.getDiff());
            temp = temp.next;
        }
    }
}
/*
ID	Score	Diff
115	257		14.38
123	253		10.38
116	246		3.38
113	243		0.38
112	239		-3.62
104	239		-3.62
110	238		-4.62
218	243		0.38
208	242		-0.62
222	223		-19.62
223	230		-12.62
213	229		-13.62
207	228		-14.62
203	224		-18.62
305	265		22.38
306	262		19.38
311	256		13.38
325	246		3.38
321	245		2.38
323	245		2.38
301	242		-0.62
 */