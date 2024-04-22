package Marquette2024;
import java.util.*;

import static java.lang.System.console;
import static java.lang.System.out;

public class LongestSubstring {

    /*
     *
     * The function should return the number of characters in the largest substring
     * without a repeating character
     *
     * Ex. "abcacbbb" -> 3 "abc" or "bbbb" -> 1 "b"
     *
     * Input:
     * @param: string -> You put in an initial string to find the largest substring
     *
     * Output:
     * Integer
     * The number of characters in the largest substring
     */

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        ArrayList<String> repeat = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            String curr = s.substring(i , i+1);
            if (!repeat.contains(curr)){

                cnt++;
                repeat.add(curr);
                if (cnt > maxLength) maxLength = cnt;
            }
            else{
                cnt = 1;
                repeat.clear();
                repeat.add(curr);
            }
        }
        //Feel free to change variable name
        return maxLength;
    }

    /*
     * It is not necessary for you to change the main.
     * The main was provided to make sure it conforms
     * to the input and output formatting requirements.
     *
     */

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        out.println(lengthOfLongestSubstring(input));
        scanner.close();
    }


}