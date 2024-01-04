// Alex Nouansacksy
// Prog408a Binary Tree Class
// 1/4/2024

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog408aBinaryTreeClass {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prg408a.dat"));

            Set<claire> test = new TreeSet<>();
            Set<claire> wow = Collections.synchronizedSet(test);


            while (keyboard.hasNext()) {
                wow.add(new claire(keyboard.nextInt(), keyboard.nextInt()));
            }

            Iterator<claire> things = wow.iterator();

            int max = 0;
            while (things.hasNext()) {
                claire thing = things.next();
                if (thing.getScore() > max) max = thing.getScore();
            }

            for (int i = max; i >= 0; i--) {
                things = wow.iterator();
                while (things.hasNext()) {
                    claire thing = things.next();
                    if (thing.getScore() == i) {
                        int id = thing.getID();
                        int score = thing.getScore();
                        out.println(id + "\t" + score);
                    }
                }
            }

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}

class claire implements Comparable<claire> {
    int id;
    int score;

    public claire(int id, int score) {
        this.id = id;
        this.score = score;
    }


    public int getID() {return id;}
    public int getScore() {return score;}
    // compareTo method to sort in
    // ascending order
    public int compareTo(claire obj) {return obj.score - this.score;}

    // override toString() method
    // for display purpose
    public String toString() {return this.id + "\t" + this.score;}
}

/* output
365	265
306	262
115	257
311	256
123	253
325	246
323	245
113	243
208	242
104	239
110	238
223	230
213	229
207	228
203	224
222	223

Process finished with exit code 0
 */


