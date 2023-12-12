package AdventOfCode2023;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prob2 {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("src/AdventOfCode2023/prob2.txt"));
            int tot = 0;
            while (keyboard.hasNext()) {
                String junk = keyboard.next();
                int gameNumber = keyboard.nextInt();
                junk = keyboard.next();
                String a = keyboard.nextLine();
                Boolean ans = true;
                String[] list = a.split(";");
                for (int i = 0; i < list.length; i++) {
                    String b = list[i];
                    String[] wow = b.split(",");
                    for (int j = 0; j < wow.length; j++) {
                        String d = wow[j];
                        String[] fred = d.split(" ");
                        int nn = Integer.parseInt(d.substring(0, 1));
                        if (fred[1].equals("Red")) {

                        }



                    }
                }
            }



        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
