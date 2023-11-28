// Alex Nouansacksy
// MSOE 2023 Question 4
// 11/26/2023


package MSOE2023;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Problem4 {
    public static void main(String args[]) {
        double littleNorth = 0.0;
        double littleEast = 0.0;
        double bigNorth = 0.0;
        double bigEast = 0.0;

        System.out.println("What are the directions?");

        Scanner george = new Scanner(System.in);

        String dir[] = george.nextLine().split(", ");
        double sqrtTwoOverTwo = Math.sqrt(2) / 2d;
        DecimalFormat two = new DecimalFormat("#.00");

        for(String aDir: dir) {
            double northFactor = 0.0;
            double eastFactor = 0.0;
            if(aDir.endsWith("X")) {
                System.out.println("Dig in the area from (" + two.format(littleNorth) + " N, " + two.format(littleEast) + " E) to (" + two.format(bigNorth) + " N, " + two.format(bigEast) + " E)");
            } else if(aDir.toUpperCase().endsWith("N")) {
                northFactor = 1 * Integer.parseInt(aDir.substring(0, aDir.length() - 1));
            } else if(aDir.toUpperCase().endsWith("NE")) {
                northFactor = sqrtTwoOverTwo * Integer.parseInt(aDir.substring(0, aDir.length() - 2));
                eastFactor = sqrtTwoOverTwo * Integer.parseInt(aDir.substring(0, aDir.length() - 2));
            } else if(aDir.toUpperCase().endsWith("E")) {
                eastFactor = 1 * Integer.parseInt(aDir.substring(0, aDir.length() - 1));
            } else if(aDir.toUpperCase().endsWith("SE")) {
                northFactor = -sqrtTwoOverTwo * Integer.parseInt(aDir.substring(0, aDir.length() - 2));
                eastFactor = sqrtTwoOverTwo * Integer.parseInt(aDir.substring(0, aDir.length() - 2));
            } else if(aDir.toUpperCase().endsWith("S")) {
                northFactor = -1 * Integer.parseInt(aDir.substring(0, aDir.length() - 1));
            } else if(aDir.toUpperCase().endsWith("SW")) {
                northFactor = -sqrtTwoOverTwo * Integer.parseInt(aDir.substring(0, aDir.length() - 2));
                eastFactor = -sqrtTwoOverTwo * Integer.parseInt(aDir.substring(0, aDir.length() - 2));
            } else if(aDir.toUpperCase().endsWith("W")) {
                eastFactor = -1 * Integer.parseInt(aDir.substring(0, aDir.length() - 1));
            } else if(aDir.toUpperCase().endsWith("NW")) {
                northFactor = sqrtTwoOverTwo * Integer.parseInt(aDir.substring(0, aDir.length() - 2));
                eastFactor = -sqrtTwoOverTwo * Integer.parseInt(aDir.substring(0, aDir.length() - 2));
            }

            littleNorth += northFactor * 0.62;
            littleEast += eastFactor * 0.62;
            bigNorth += northFactor * 0.68;
            bigEast += eastFactor * 0.68;
        }
    }
}
/*output
What are the directions?
10N, 5E, 2Sw, 3e, X
Dig in the area from (5.32 N, 4.08 E) to (5.84 N, 4.48 E)

Process finished with exit code 0
 */
