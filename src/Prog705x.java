// Alex Nouansacksy
// Prog705x
// 10/19/2023

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Prog705x {
    public static void main(String[] args) {
        try {
            Scanner poem = new Scanner(new File("data/prog512h.dat"));
            Scanner key = new Scanner(new File("data/prog705x.txt"));

            ArrayList<String> poemLines = new ArrayList<>();
            while (poem.hasNext()) poemLines.add(poem.nextLine());

            ArrayList<String[]> poemwords = new ArrayList<>();

            for (int i = 0; i < poemLines.size(); i++) {
                String[] words = poemLines.get(i).split(" ");
                poemwords.add(words);
            }

            String secretWord = "";
            ArrayList<Integer> keys = new ArrayList<>();
            while (key.hasNext()) keys.add(key.nextInt());

            for (int a : keys) {
                String b = a + "";
                if (a < 1000) b = "0" + b;
                int line = a / 100;
                a -= line * 100;
                int word = a / 10;
                a-= word * 10;
                int character = a;
                line--;
                word--;
                character--;
                secretWord = secretWord + poemwords.get(line)[word].charAt(character);
                out.println(b + " " + poemwords.get(line)[word].charAt(character));
            }
            out.println("The magic word would be " + secretWord);
        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
/*
0831 c
0112 o
0722 o
0914 l
0821 b
1243 e
1551 a
1724 n
1816 s
The magic word would be coolbeans

Process finished with exit code 0
 */