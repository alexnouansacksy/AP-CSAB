// Alex Nouansacksy
// Prog 1060b
// 1/29/2024

package Prog1060bQueue;
import static java.lang.System.out;
import java.util.*;

public class queueClass {
    private static int front;
    private static int back;
    private static ArrayList<Integer> queue;

    public queueClass() {
        front = 0;
        back = 0;
        queue = new ArrayList<Integer>();
    }

    static void enqueue(int num) {queue.add(num);}

    static void dequeue(int num) {
        boolean contains = false;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) == num) {
                queue.remove(i);
                contains = true;
            }
        }
        if (!contains) out.println("Number does not exist");
    }

    static void displayQueue() {
        for (int num : queue) out.print(num + " ");
        out.println();
    }
}
