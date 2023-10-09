// Prog 402a with Linked Lists
// Alex Nouansacksy
// 10/04/2023
package Prog402aLinkedList;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class Prog402aLinkedList {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prg402a.dat"));
            comlist wow = new comlist();
            while (keyboard.hasNext()) {
                int id = keyboard.nextInt();
                int score = keyboard.nextInt();
                wow.add(new node(id, score));
            }

            wow.setAverages();
            out.println("ID\tScore\tDiff");
            wow.print();

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
