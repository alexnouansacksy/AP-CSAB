// Alex Nouansacksy
// MSOE 2023 Question 3
// 11/27/2023

package MSOE2023;
import static java.lang.System.out;
import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.print("orders: ");
        int orders = keyboard.nextInt();

        int[][] list = new int[orders][2];
        for (int i = 0; i < orders; i++) {
            out.print("length x width: ");
            String widthLength = keyboard.next();
            String length = widthLength.substring(0, widthLength.indexOf('x'));
            String width = widthLength.substring(widthLength.indexOf('x') + 1 );
            list[i][0] = Integer.parseInt(length);
            list[i][1] = Integer.parseInt(width);
        }

        for (int[] ints : list) {out.println(ints[0] + " by " + ints[1]);}
    }
}
