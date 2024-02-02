// Alex Nouansacksy
// Prog 1060z Priority Queue
// 2/1/2024
package Prog1060zPriorityQueue;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog1060zPriorityQueue {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prg1060z.dat"));
            PriorityQueue<String> list = new PriorityQueue<String>();
            while (keyboard.hasNext()) {
                String a = keyboard.nextLine();
                String task = a.substring(0, 1);
                if (task.equals("W")) {
                    out.println("Processing Queue Report...");
                    PriorityQueue<String> newQueue = new PriorityQueue<String>();
                    while (!list.isEmpty()) {
                        out.println(list.peek());
                        newQueue.add(list.poll());
                    }
                    list = newQueue;
                    out.println("End of Report\n");
                }
                if (task.equals("P")) {
                    if (list.isEmpty()) out.println("Pop denied. Cause: Empty Queue\n");
                    else out.println("Pop accepted. Cause: Available node.\nCurrently Processing job: " + list.poll() + "\n");
                }
                if (task.equals("A")) {
                    list.add(a.substring(1));
                }
            }
        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
/* output
Processing Queue Report...
End of Report

Processing Queue Report...
A11
B12
C13
End of Report

Pop accepted. Cause: Available node.
Currently Processing job: A11

Pop accepted. Cause: Available node.
Currently Processing job: B12

Pop accepted. Cause: Available node.
Currently Processing job: C13

Pop denied. Cause: Empty Queue

Processing Queue Report...
C14
End of Report

Processing Queue Report...
A15
C14
End of Report


Process finished with exit code 0

 */
