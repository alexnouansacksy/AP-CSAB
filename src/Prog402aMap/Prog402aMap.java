// Alex Nouansacksy
// Prog 402a with maps
// 12/15/2023

package Prog402aMap;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog402aMap {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prg402a.dat"));
            Map<Integer, node> wow = new HashMap<Integer, node>();
            while (keyboard.hasNext()) {
                int id = keyboard.nextInt();
                int score = keyboard.nextInt();

                node claire = new node(id, score);
                wow.put(id, claire);
            }

            Set<Integer> keys = wow.keySet();
            Iterator<Integer> key = keys.iterator();

            double average = 0;
            int cnt = 0;

            while (key.hasNext()) {
                int claire = wow.get(key.next()).getScore();
                average += claire;
                cnt ++;
            }

            average /= cnt;

            keys = wow.keySet();
            key = keys.iterator();

            out.println("ID\t\tScore\tDifference");

            while (key.hasNext()) {
                node claire = wow.get(key.next());
                claire.setDiff(average);
                out.println(claire.toString());
            }

            out.printf("\nAverage Score: %.2f", average);


        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
/* output
ID		Score	Difference
321		245		2.38
323		245		2.38
325		246		3.38
104		239		-3.62
203		224		-18.62
301		242		-0.62
110		238		-4.62
207		228		-14.62
112		239		-3.62
208		242		-0.62
113		243		0.38
305		265		22.38
306		262		19.38
115		257		14.38
116		246		3.38
213		229		-13.62
311		256		13.38
218		243		0.38
123		253		10.38
222		223		-19.62
223		230		-12.62

Average Score: 242.62
Process finished with exit code 0

 */