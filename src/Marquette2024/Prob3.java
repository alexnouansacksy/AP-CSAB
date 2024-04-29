// Alex Nouansacksy
// Marquette 2024 #3
// 4/29/2024

package Marquette2024;
import java.util.*;
import static java.lang.System.out;

public class Prob3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String sub = keyboard.next();
        String phrase = keyboard.next();
        String[] sublets = sub.split("");

        int prevloc = -1;
        int loc = -1;
        boolean order = true;
        for (int i = 0; i < sublets.length; i++) {
            prevloc = loc;
            loc = phrase.indexOf(sublets[i]);
            if (loc < prevloc) order = false;
        }

        if (order) out.println("True");
        else out.println("False");
    }
}
/* Output
abc ahbgdc
True

Process finished with exit code 0

hello world
False

Process finished with exit code 0
 */