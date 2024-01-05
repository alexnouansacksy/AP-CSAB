// Alex Nouansacksy
// Prog408a Set
// 1/5/2023
package Prog408aSet;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog408aSet {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prg408a.dat"));
            Set<node> wow = new HashSet<node>();

            while (keyboard.hasNext()){
                int id = keyboard.nextInt();
                int score = keyboard.nextInt();
                node claire = new node(id, score);
                wow.add(claire);
            }

            Iterator<node> things = wow.iterator();

            int max = 0;

            while (things.hasNext()) {
                node claire = things.next();
                if (claire.getScore() > max) max = claire.getScore();
            }

            out.println("ID\tScore");

            for (int i = max; i >= 0; i--) {
                things = wow.iterator();
                while (things.hasNext()) {
                    node claire = things.next();
                    if (claire.getScore() == i) {
                        out.println(claire);
                    }
                }
            }

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
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