package Prog602bQueue;

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
                out.println(queue[i]);
            }
        }
    }
}
