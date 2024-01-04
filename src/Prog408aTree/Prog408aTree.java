package Prog408aTree;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog408aTree {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prg408a.txt"));
            nodehelper wow = new nodehelper();
            while (keyboard.hasNext()) {
                int id = keyboard.nextInt();
                int score = keyboard.nextInt();
                node claire = new node(id, score);
                wow.add(claire);
            }

            out.println("ID\tScore");
            wow.print();

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}


