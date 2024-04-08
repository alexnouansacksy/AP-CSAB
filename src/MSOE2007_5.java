// Alex Nouansacksy
// MSOE 2007 Question 5
// 4/8/2024

import java.util.*;
import static java.lang.System.out;

public class MSOE2007_5 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.print("enter phrase: ");
        String phrase = keyboard.next();

        ArrayList<String> longest = new ArrayList<>();
        int longestRep = 0;
        int cnt = 1;

        for (int i = 0; i < phrase.length() - 1; i++) {
            String curr = phrase.substring(i, i+1);
            String next = phrase.substring(i+1, i+2);
            if (next.equals(curr)) {
                cnt++;
                if (cnt > longestRep) {
                    longest.clear();
                    longestRep = cnt;
                    longest.add(curr);
                }
                if (cnt == longestRep) {
                    if(!longest.contains(curr)) longest.add(curr);
                }
            }
            else cnt = 1;
        }

        out.print(longestRep + " ");
        for (String s: longest) out.print(s + " ");
    }
}

/*
enter phrase: ABCDDEFGGHABC
2 D G
Process finished with exit code 0
 */