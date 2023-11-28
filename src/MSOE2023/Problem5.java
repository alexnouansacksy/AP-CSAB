// Alex Nouansacksy
// MSOE 2023 Question 5
// 11/26/2023

package MSOE2023;
import static java.lang.System.out;
import java.util.*;

public class Problem5 {
    public static String checkLetter(String a) {
        if (a.equals("O")) return "0";
        else if (a.equals("L") || a.equals("I")) return "1";
        else if (a.equals("Z")) return "2";
        else if (a.equals("E") || a.equals("M") || a.equals("W")) return "3";
        else if (a.equals("A")) return "4";
        else if (a.equals("S")) return "5";
        else if (a.equals("G")) return "6";
        else if (a.equals("T")) return "7";
        else if (a.equals("B") || a.equals("X")) return "8";
        else if (a.equals("J") || a.equals("P")) return "9";
        else return "_";
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        while (keyboard.hasNext()) {
            words.add(keyboard.next().toUpperCase());
        }
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() != 6) {
                words.remove(i);
                i--;
            }
        }
        for (String a: words) {
            String one = a.substring(3, 4);
            String two = a.substring(4, 5);
            String three = a.substring(5);

            one = checkLetter(one);
            two = checkLetter(two);
            three = checkLetter(three);
            a = a.substring(0, 3) + one + two + three;
            if (!a.contains("_")) out.println(a);

        }
    }
}
/*ouput

dazzle
cinemas
circle
days
impose
cipher
cinema

DAZ213
IMP053
CIN334

Process finished with exit code 0


 */