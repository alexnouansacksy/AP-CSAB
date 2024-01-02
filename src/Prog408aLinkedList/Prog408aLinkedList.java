package Prog408aLinkedList;

import Prog402aLinkedList.comlist;
import Prog402aLinkedList.node;

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

            for (int i = 0; i < claire.getCount(); i++) {
                int id = claire.get(i)[0];
                int score = claire.get(i)[1];
                if (score > maxscore) maxscore = score;
            }

            out.println("Id\tScore");
            for (int i = maxscore; i >= 0; i--) {
                for (int j = 0; j < claire.size(); j++) {
                    int id = claire.get(j)[0];
                    int score = claire.get(j)[1];
                    if (score == i) out.println(id + "\t" + score);
                }
            }
        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
