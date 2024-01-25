// Alex Nouansacksy
// Prog 285b with Queues
// 1/23/2024

package Prog285bQueue;

import java.io.*;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Prog285bQueue {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog285b.dat"));
            Scanner input = new Scanner(System.in);

            out.print("Queue Length: ");
            int length = input.nextInt();
            queueClass wow = new queueClass(length);

            while (keyboard.hasNext()) {
                int id = keyboard.nextInt();
                int code = keyboard.nextInt();
                double sales = keyboard.nextDouble();

                node claire = new node(id, code, sales);
                queueClass.enqueue(claire);
            }

            queueClass.displayQueue();
        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}


