// Alex Nouansacksy
// Prog285b with Binary Trees
// 11/8/2023

package Prog285bTree;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.out;

public class Prog285bTree {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog285b.dat"));
            nodehelper wow = new nodehelper();

            while (keyboard.hasNext()) {
                int id = keyboard.nextInt();
                int code = keyboard.nextInt();
                double sales = keyboard.nextDouble();

                node fred = new node(id, code, sales);
                wow.add(fred);
            }

            wow.calc();
            out.println(wow.getcount());
            wow.inprint();

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
