// Alex Nouansacksy
// MSOE 2023 Question 2
// 11/26/2023
package MSOE2023;

import java.util.Scanner;

//Problem 2 --- Attractive Alliteration
public class Problem2 {
    public static void main(String args[]) {
        System.out.println("Give your sentence");

        Scanner george = new Scanner(System.in);
        String temp = "";

        while(!temp.endsWith("$$")) {
            temp += " " + george.next();
        }

        helper(temp.substring(1));
    }

    public static void helper(String input) {
        String words[] = input.substring(0, input.length() - 3).split(" ");
        int longest = 0;
        String phrase = "";

        for(int i = 0; i < words.length; i++) {
            int tempLong = 1;
            String letter = words[i].substring(0, 1);
            String tempPhrase = words[i];

            for(int j = i + 1; j < words.length; j++) {
                if(words[j].substring(0, 1).equalsIgnoreCase(letter)) {
                    tempLong++;
                    tempPhrase += " " + words[j];
                } else {
                    break;
                }
            }

            if(tempLong > longest) {
                longest = tempLong;
                phrase = tempPhrase;
            }
        }

        System.out.println(phrase);
    }
}
/* output
Give your sentence
Multiple Marvins in Indonesia say Sibyl sells sea shells by the sea shore. $$
say Sibyl sells sea shells

Process finished with exit code 0
 */