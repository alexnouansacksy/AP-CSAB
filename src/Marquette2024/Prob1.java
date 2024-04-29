// Alex Nouansacksy
// Marquette 2024 #1
// 4/29/2024

package Marquette2024;
import java.util.*;
import static java.lang.System.out;

public class Prob1 {
    public static void main(String[] args) {
        ArrayList<Double> nums = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            double input = keyboard.nextDouble();
            nums.add(input);
        }
        out.println();
        out.println(Math.sqrt(Math.pow(nums.get(2) - nums.get(0), 2) + Math.pow(nums.get(3) - nums.get(1), 2)));
    }
}

/* output
5
4
-3
7

8.54400374531753

Process finished with exit code 0
 */