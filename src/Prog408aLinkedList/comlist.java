// Alex Nouansacksy
// 408a LinkedList
// 1/3/2024
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

    public boolean print(int n) {
        node temp = myroot;
        if (temp == null) {
            out.println("The list is empty.");
            return false;
        }
        while (temp.next != null) {
            if (temp.getScore() == n) {
                out.printf("%d\t%d\n", temp.getID(), temp.getScore());
            }
            temp = temp.next;
        }
        return false;
    }

    public int max() {
        if (myroot == null) return 0;
        node temp = myroot;
        int max = temp.getScore();
        while (temp.next != null) {
            if (temp.getScore()  > max) max = temp.getScore();
            temp = temp.next;
        }
        return max;
    }
}

/* output
ID	Score
365	265
306	262
115	257
311	256
123	253
325	246
116	246
323	245
321	245
113	243
218	243
208	242
302	242
104	239
112	239
110	238
223	230
213	229
207	228
203	224
222	223

Process finished with exit code 0
 */