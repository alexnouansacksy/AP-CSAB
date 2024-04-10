// Alex Nouansacksy
// MSOE 2009 #2
// 4/8/2024

import java.awt.datatransfer.FlavorTable;
import java.util.*;
import java.lang.Math;

import static java.lang.Math.toRadians;
import static java.lang.System.out;

public class MSOE2009_2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        out.print("your latitude: ");
        double latitude = keyboard.nextDouble();
        double a1 = toRadians(latitude);

        out.print("your longitude: ");
        double longitude = keyboard.nextDouble();
        double o1 = toRadians(longitude);

        out.print("car latitude: ");
        latitude = keyboard.nextDouble();
        double a0 = toRadians(latitude);

        out.print("car longitude: ");
        longitude = keyboard.nextDouble();
        double o0 = toRadians(longitude);

        double distance = 3963.1 * Math.acos(Math.cos(a0) * Math.cos(o0) * Math.cos(a1) * Math.cos(o1) +
                Math.cos(a0) * Math.sin(o0) * Math.cos(a1) * Math.sin(o1) + Math.sin(a0) * Math.sin(a1));

        out.println(distance + " miles");
    }
}

/*
your latitude: 43.043
your longitude: -87.905
car latitude: 43.045
car longitude: -87.918
0.6715641671039231 miles

Process finished with exit code 0

 */
