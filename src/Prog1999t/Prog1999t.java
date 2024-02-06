// Alex Nouansacksy
// Prog1999t.Prog1999t
// 2/5/2024

package Prog1999t;
import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog1999t {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog1999.txt"));
            int len = keyboard.nextInt();
            eel[] eels = new eel[len];

            for (int i = 0; i < len; i++) {
                String firstName = keyboard.next();
                String lastName = keyboard.next();

                int[][] eaten = new int[3][5];

                for (int j = 0; j < 3; j++)
                    for (int k = 0; k < 5; k++)
                        eaten[j][k] = keyboard.nextInt();

                LinkedList<String> namesEaten = new LinkedList<>();

                String temp = keyboard.next();
                while (!temp.equals("-1")){
                    namesEaten.add(temp);
                    temp = keyboard.next();
                }

                eel eel = new eel((firstName + " " + lastName), eaten, namesEaten);
                eels[i] = eel;
            }

            while (!keyboard.hasNext()) {

            }


        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
