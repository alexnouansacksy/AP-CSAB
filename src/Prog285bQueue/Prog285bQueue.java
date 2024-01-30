// Alex Nouansacksy
// Prog 285b with Queues
// 1/23/2024

package Prog285bQueue;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog285bQueue {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog285b.dat"));
            Queue<node> wow = new LinkedList<node>();

            while (keyboard.hasNext()) {
                int id = keyboard.nextInt();
                int code = keyboard.nextInt();
                double sales = keyboard.nextDouble();

                node claire = new node(id, code, sales);
                claire.setcom();
                wow.add(claire);
            }

            Iterator<node> iterator = wow.iterator();
            while(iterator.hasNext()) out.println(iterator.next());


        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}

/*
101 17 2250.0 213.75
103 5 4000.0 300.0
117 3 7350.0 0.0
118 8 7350.0 574.75
125 5 6500.0 502.5
138 17 6375.0 677.5
192 8 8125.0 640.625
203 8 3250.0 243.75
218 5 5000.0 375.0
235 5 5250.0 396.25
264 17 4150.0 410.5
291 17 750.0 71.25

Process finished with exit code 0
 */
