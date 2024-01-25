// Alex Nouansacksy
// Prog 285b with Queues
// 1/23/2024

package Prog285bQueue;

import static java.lang.System.out;

public class queueClass {
    private static int front;
    private static int back;
    private static int size;
    private static node[] queue;

    public queueClass(int s) {
        front = 0;
        back = 0;
        size = s;
        queue = new node[size];
    }

    static void enqueue(node num) {
        if (back == size) out.println("Full.");
        else {
            queue[back] = num;
            back++;
        }
    }

    static void dequeue() {
        if (front == back) out.println("Empty.");
        else {
            for (int i = 0; i < back - 1; i++) {
                queue[i] = queue[i + 1];
            }
            if (back < size) queue[back] = null;
            back--;
        }
    }

    static void displayQueue() {
        if (front == back) out.println("Empty.");
        else {
            for (int i = 0; i < back; i++) {
                queue[i].setcom();
                out.println(queue[i]);
            }
        }
    }
}
/*

Queue Length: 12
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