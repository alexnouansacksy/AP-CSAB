// Alex Nouansacksy
// MSOE 2023 Question 3
// 11/27/2023

package MSOE2023;
import static java.lang.System.out;
import java.util.*;

public class Problem3 {
    public static int diameter(int longest) {
        int diameter;

        if (longest /100 < 1) {
            diameter = 5;
        } else if (longest / 100 < 2) {
            diameter = 8;
        } else {
            diameter = 12;
        }
        return diameter;
    }

    public static int tubelength(int shortest) {
        return shortest + 2;
    }

    public static double getWrapping(int tubelength, int diameter) {
        int length = tubelength + 2;
        double circumference = diameter * Math.PI;
        circumference *= 1.1;
        circumference += (2 * diameter);
        return circumference * tubelength;
    }

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

        int tubeLength;
        int circumference;
        double totalwrapping = 0;
        for (int[] ints : list) {
            if (ints[0] > ints[1]) {
                tubeLength = tubelength(ints[1]);
                circumference = diameter(ints[0]);
            } else {
                tubeLength = tubelength(ints[0]);
                circumference = diameter(ints[1]);
            }

            out.println(ints[0] + " by " + ints[1]);
            out.println("tube length: " + tubeLength + "\tdiameter: " + circumference);
            double wrapping = getWrapping(tubeLength, circumference);
            totalwrapping += wrapping;
        }
        out.println("Total wrapping: " + totalwrapping / (double) 1000);


    }
}
/*
orders: 5
length x width: 23x41
length x width: 80x12
length x width: 240x100
length x width: 10x10
length x width: 900x650
23 by 41
tube length: 25	diameter: 5
80 by 12
tube length: 14	diameter: 5
240 by 100
tube length: 102	diameter: 12
10 by 10
tube length: 12	diameter: 5
900 by 650
tube length: 652	diameter: 12

Total wrapping: 3.468172

Process finished with exit code 0
 */