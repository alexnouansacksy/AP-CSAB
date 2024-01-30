// Alex Nouansacksy
// Prog 1060b w/ Queues
// 1/29/2024

package Prog1060bQueue;

import Prog285bQueue.node;

import java.util.*;
import static java.lang.System.out;

public class Prog1060bQueue {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String option = "";
        Queue<Integer> wow = new LinkedList<>();
        while (!option.equals("E")) {
            options();
            option = keyboard.next();
            if (option.equals("A")) {
                out.print("enter number ");
                wow.add(keyboard.nextInt());
                out.println("This is the list");
                Iterator<Integer> iterator = wow.iterator();
                while(iterator.hasNext()) out.println(iterator.next());
            } else if (option.equals("D")) {
                out.print("enter number ");
                wow.add(keyboard.nextInt());
                out.println("This is the list");
                Iterator<Integer> iterator = wow.iterator();
                while (iterator.hasNext()) out.println(iterator.next());
            }
            else if (option.equals("E")) {
                out.println("This is the list");
                Iterator<Integer> iterator = wow.iterator();
                while(iterator.hasNext()) out.println(iterator.next());            }
        }
    }

    public static void options() {
        out.print("Enter task A)dd, D)elete, E)exit: ");
    }
}

/* output
Enter task A)dd, D)elete, E)exit: A
enter number 10
This is the list
10
Enter task A)dd, D)elete, E)exit: A
enter number 15
This is the list
10 15
Enter task A)dd, D)elete, E)exit: A
enter number 2
This is the list
10 15 2
Enter task A)dd, D)elete, E)exit: D
enter number 10
This is the list
15 2
Enter task A)dd, D)elete, E)exit: D
enter number 2
This is the list
15
Enter task A)dd, D)elete, E)exit: D
enter number 15
This is the list

Enter task A)dd, D)elete, E)exit: A
enter number 7
This is the list
7
Enter task A)dd, D)elete, E)exit: D
enter number 8
Number does not exist
This is the list
7
Enter task A)dd, D)elete, E)exit: A
enter number 12
This is the list
7 12
Enter task A)dd, D)elete, E)exit: D
enter number 12
This is the list
7
Enter task A)dd, D)elete, E)exit: E

Process finished with exit code 0
 */

