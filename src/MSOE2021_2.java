// Alex Nouansacksy
// MSOE 2021 Question 2
// 4/2/2024

import java.util.*;
import static java.lang.System.out;

public class MSOE2021_2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner (System.in);

        out.print("ounces: ");
        int ounces = (keyboard.nextInt());
        keyboard.nextLine();
        out.print("cups: ");
        String input = keyboard.nextLine();

        String[] cups = input.split(" ");
        int cnt = 0;
        while (ounces > 0) {
            ounces -= (Integer.parseInt(cups[cnt]) + 1);
            if (ounces > 0) cnt++;
        }
        out.printf("Filled %d cups.", cnt);
    }
}

/*
ounces: 34
cups: 4 6 6 4 4 8 6
Filled 5 cups.
Process finished with exit code 0
 */