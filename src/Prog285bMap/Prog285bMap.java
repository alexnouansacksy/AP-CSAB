// Alex Nouansacksy
// Prog 285b with Maps
// 12/14/2023

package Prog285bMap;
import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog285bMap {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog285b.dat"));
            Map<Integer, node> wow = new HashMap<Integer, node>();
            while (keyboard.hasNext()) {
                int id = keyboard.nextInt();
                int code = keyboard.nextInt();
                double sales = keyboard.nextDouble();

                node claire = new node(id, code, sales);
                wow.put(id, claire);
            }

            Set<Integer> keys = wow.keySet();
            Iterator<Integer> key = keys.iterator();

            while (key.hasNext()) {
                node claire = wow.get(key.next());
                claire.setcom();
                if (!(claire.getcom() == 0)) out.println(claire.toString());
            }
        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
/*
192 8 8125.0 640.625
291 17 750.0 71.25
101 17 2250.0 213.75
118 8 7350.0 574.75
103 5 4000.0 300.0
264 17 4150.0 410.5
138 17 6375.0 677.5
218 5 5000.0 375.0
203 8 3250.0 243.75
235 5 5250.0 396.25
125 5 6500.0 502.5

Process finished with exit code 0
 */