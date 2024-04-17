package Marquette2024;
import java.util.*;
import static java.lang.System.out;

public class Prob2 {
    public static boolean isPalindrome(String input) {
        input = input.replace(" ", "");
        input = input.toLowerCase();
        String palindrome = new String();
        for (int i = input.length(); i > 0; i--) {
            palindrome = palindrome + (input.substring(i - 1, i));
        }
        if (palindrome.toString().equals(input)) return true;
        else return false;
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String word = keyboard.nextLine();
        if (isPalindrome(word)) out.println("True");
        else out.println("False");
    }
}
