package Marquette2024;
import java.util.*;

public class CountandSay {
    // Method to generate the nth term in the "Count and Say" sequence
    public static String countAndSay(int n) {
        n--;

        // Starting term of the sequence
        String s = "1";

        //TODO: Create a "Count and Say" method in this method space to change String s
        // into the correct value based on the parameters of the problem.
        // Example: when n = 1, s = 1. When n = 2, s = 11. When n = 2, s = 21. and so on

        for (int a = 0; a < n; a++) {
            int count = 0;
            String c = "";
            String out = "";
            for (int i = 0; i < s.length(); i++) {
                if (c == "") {
                    c = s.substring(i, i + 1);
                    count = 1;
                } else if (s.substring(i, i + 1).equals(c)) {
                    count++;
                } else {
                    out += "" + count + c;
                    count = 1;
                    c = s.substring(i, i + 1);
                }
            }

            out += "" + count + c;
            s = out;
        }
        return s;
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input an Integer: ");
        // Read an integer from the user
        int input = scanner.nextInt();
        // Print the nth term in the "Count and Say" sequence
        System.out.println(countAndSay(input));
    }
}