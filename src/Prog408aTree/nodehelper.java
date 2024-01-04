// Alex Nouansacksy
// Prog408a Tree
// 1/4/2024
package Prog408aTree;

import static java.lang.System.out;

public class nodehelper {
    private node myroot;

    public void add(node n ) {
        if (myroot == null) {
            myroot = n;
            return;
        }
        node temp = myroot;
        node prev = myroot;
        while (temp != null) {
            if (n.getScore() <= temp.getScore()) {
                prev = temp;
                temp = temp.myleft;
            } else {
                prev = temp;
                temp = temp.myright;
            }
        }
        if (n.getScore() <= prev.getScore()) {
            prev.myleft = n;
        } else {
            prev.myright = n;
        }
    }

    public void print() {print(myroot);}

    public void print(node temp) {
        if (temp == null) return;
        print(temp.myright);
        out.println(temp);
        print(temp.myleft);
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