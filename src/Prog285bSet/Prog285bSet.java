// Alex Nouansacksy
// Prog285b with Sets
// 12/12/2023

package Prog285bSet;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog285bSet {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog285b.dat"));
            Set<node> wow = new HashSet<node>();

            while (keyboard.hasNext()) {
                int id = keyboard.nextInt();
                int code = keyboard.nextInt();
                double sales = keyboard.nextDouble();

                node claire = new node(id, code, sales);
                wow.add(claire);
            }

            for (node a : wow) {
                a.setcom();
                if (!(a.getcom() == 0)) out.println(a.toString());
            }

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
/*
138 17 6375.0 677.5
203 8 3250.0 243.75
264 17 4150.0 410.5
103 5 4000.0 300.0
218 5 5000.0 375.0
235 5 5250.0 396.25
101 17 2250.0 213.75
192 8 8125.0 640.625
118 8 7350.0 574.75
291 17 750.0 71.25
125 5 6500.0 502.5

Process finished with exit code 0
 */