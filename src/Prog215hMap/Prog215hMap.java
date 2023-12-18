package Prog215hMap;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog215hMap {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog215h.txt"));
            Map<Integer, node> wow = new HashMap<Integer, node>();
            int cnt = 0;
            while (keyboard.hasNext()) {
                cnt++;
                node claire = new node (cnt, keyboard.nextDouble(), keyboard.nextDouble(), keyboard.nextDouble(), keyboard.nextDouble(), keyboard.nextDouble(), keyboard.nextDouble(), keyboard.nextDouble(), keyboard.nextDouble());
                wow.put(cnt, claire);
            }

            Set<Integer> keys = wow.keySet();
            Iterator<Integer> key = keys.iterator();

            while (key.hasNext()) {
                node claire = wow.get(key.next());
                claire.calc();
                double average = claire.getAverage();
                out.print(claire.toString());
                out.printf("= %.2f\n\n", average);
            }
        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
/* output
Contestant 1
 8.4 9.1 8.5 8.4 9.1 8.7 8.8 9.1
= 8.77

Contestant 2
 7.0 7.0 7.0 7.0 7.0 7.0 7.0 7.0
= 7.00

Contestant 3
 8.0 7.9 8.0 8.0 8.0 8.0 8.0 8.1
= 8.00

Contestant 4
 6.1 7.1 8.1 8.1 8.2 8.2 7.2 6.2
= 7.48

Contestant 5
 7.2 7.7 7.8 8.8 7.5 6.3 9.2 7.3
= 7.72

Contestant 6
 6.8 6.9 7.3 8.8 6.7 7.7 7.9 6.3
= 7.22


Process finished with exit code 0
 */