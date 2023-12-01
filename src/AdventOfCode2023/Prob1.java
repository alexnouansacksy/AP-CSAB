// Alex Nouansacksy
// Problem 1
// 12/1/2023
package AdventOfCode2023;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Prob1 {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("src/AdventOfCode2023/prob1.txt"));
            ArrayList<String> claire = new ArrayList<>();
            while(keyboard.hasNext()) {claire.add(keyboard.nextLine());}

            int total = 0;

            for (String s : claire) {

                int firstNum = 0;
                int secondNum = 0;
                boolean firstNumFound = false;
                int cnt = 0;

                while (!firstNumFound) {
                    if (Character.isDigit(s.charAt(cnt))) {
                        firstNumFound = true;
                        firstNum = Character.getNumericValue(s.charAt(cnt));
                    }
                    cnt++;
                }

                for (int j = 0; j < s.length(); j++) {
                    if (Character.isDigit(s.charAt(j))) {
                        secondNum = Character.getNumericValue(s.charAt(j));
                    }
                }

                total += firstNum * 10 + secondNum;
            }

            out.println(total);
        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}

/*
54951
 */