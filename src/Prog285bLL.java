// Alex Nouansacksy
// Prog285b Linked Lists
// 9/13/2023
import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class Prog285bLL {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog285b.dat"));
            comlist wow = new comlist();
            while (keyboard.hasNext()) {
                int id = keyboard.nextInt();
                int c = keyboard.nextInt();
                double s = keyboard.nextDouble();

                node pill = new node(id, c, s);
                wow.addfirst(pill);
            }

            wow.calc;
        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
