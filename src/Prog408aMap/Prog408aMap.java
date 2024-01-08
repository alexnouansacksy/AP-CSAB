// Alex Nouansacksy
// Prog408a Map
// 1/5/2024
package Prog408aMap;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog408aMap {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prg408a.dat"));
            Map<Integer, node> wow = new HashMap<Integer, node>();
            while (keyboard.hasNext()) {
                int id = keyboard.nextInt();
                int score = keyboard.nextInt();

                node claire = new node(id, score);
                wow.put(id, claire);
            }

            Set<Integer> keys = wow.keySet();
            Iterator<Integer> key = keys.iterator();

            int max = 0;

            while (key.hasNext()) {
                int claire = wow.get(key.next()).getScore();
                if (claire > max) max = claire;
            }

            out.println("ID\tScore");


            keys = wow.keySet();

            for (int i = max; i >= 0; i--) {
                key = keys.iterator();

                while (key.hasNext()) {
                    node claire = wow.get(key.next());
                    if (claire.getScore() == i) out.println(claire);
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
321	245
323	245
113	243
218	243
302	242
208	242
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