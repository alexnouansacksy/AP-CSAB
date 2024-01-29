// Alex Nouansacksy
// Prog 602b Queue
// 1/26/2024

package Prog602bQueue;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog602bQueue {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog602b.txt"));
            Scanner input = new Scanner(System.in);

            out.print("Queue Length: ");
            int length = input.nextInt();
            queueClass wow = new queueClass(length);

            while (keyboard.hasNext()) {
                int accountNum = keyboard.nextInt();
                double hours = keyboard.nextDouble();
                int code = keyboard.nextInt();

                node claire = new node(accountNum, hours,code);
                claire.calc();
                queueClass.enqueue(claire);
            }

            queueClass.displayQueue();

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
/* output
Queue Length: 9
1825	3.25	0	200.0
14063	17.06	1	661.8
17185	7.93	1	396.5
19111	12.0	2	700.0
20045	5.0	1	250.0
21352	5.84	0	242.0
22841	27.9	2	1087.0
23051	1.55	2	350.0
29118	15.02	0	550.6

Process finished with exit code 0
 */