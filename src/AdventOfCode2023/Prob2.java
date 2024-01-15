// Alex Nouansacksy
// Advent 2 Marble Bag (red green blue)
// 1/15/2024
package AdventOfCode2023;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prob2 {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("src/AdventOfCode2023/prob2.txt"));
            int sum = 0;
            int gameNum = 0;

            ArrayList<String> games = new ArrayList<>();

            while (keyboard.hasNextLine()) {
                String a = keyboard.nextLine();
                games.add(a);
            }

            for (String a: games) {
                gameNum++;
                boolean validGame = true;
                String[] round = a.split(";");
                for (int i = 0; i < round.length; i++) {
                    round[i] = round[i].replaceAll(":", ",");
                    String[] marbles = round[i].split(",");

                    for (int j = 1; j < marbles.length; j++) {
                        String[] marblesCount = marbles[j].split(" ");
                        int numMarbles = Integer.parseInt(marblesCount[1]);
                        if (marbles[j].contains("red")) if (numMarbles > 12) validGame = false;
                        if (marbles[j].contains("blue")) if (numMarbles > 14) validGame = false;
                        if (marbles[j].contains("green")) if (numMarbles > 13) validGame = false;
                    }

                }
                if (!validGame) sum += gameNum;

            }

            out.println(sum);
        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
/* output
2216

Process finished with exit code 0
 */