package Prog408aLinkedList;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class Prog408aLinkedList {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prg408a.dat"));
            comlist claire = new comlist();

            while (keyboard.hasNext()) {
                int id = keyboard.nextInt();
                int score = keyboard.nextInt();
                claire.add(new node(id, score));
            }


            out.println("Id\tScore");
            for (int i = claire.max(); i >= 0; i--) {
                claire.print(i);
            }

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
