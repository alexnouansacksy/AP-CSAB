package MSOE2017;// Alex Nouansacksy
// MSOE 2017 Question 7
// 10/30/2023

import static java.lang.System.out;
import java.util.*;

public class MSOE2017_7 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double ax = 0;
        double ay = 0;
        double bx = 0;
        double by = 0;
        double cx = 0;
        double cy = 0;
        double t = 0;

        out.print("Ax: ");
        ax = keyboard.nextDouble();
        out.print("Ay: ");
        ay = keyboard.nextDouble();

        out.print("Bx: ");
        bx = keyboard.nextDouble();
        out.print("By: ");
        by = keyboard.nextDouble();

        out.print("Cx: ");
        cx = keyboard.nextDouble();
        out.print("Cy: ");
        cy = keyboard.nextDouble();

        out.print("T (0 - 0.5): ");
        t = keyboard.nextDouble();

        double sideAB = Math.sqrt(Math.pow((bx - ax), 2) + Math.pow((by - ay), 2));
        double sideBC = Math.sqrt(Math.pow((cx - bx), 2) + Math.pow((cy - by), 2));
        double sideCA = Math.sqrt(Math.pow((ax - cx), 2) + Math.pow((ay - cy), 2));

        double s = sideAB + sideBC + sideCA;
        s /= 2;
        double area = Math.sqrt(s * (s-sideAB) * (s-sideBC) * (s-sideCA));

        double myT = t * sideBC;
        double sideP = Math.sqrt(Math.pow(sideAB, 2) + Math.pow(myT, 2));
        s = (sideAB + sideP + myT) / 2;
        double area1 = Math.sqrt(s * (s-sideAB) * (s-sideP) * (s-myT));

        myT = t  * sideCA;
        double sideQ = Math.sqrt(Math.pow(sideBC, 2) + Math.pow(myT, 2));
        s = (sideBC + sideQ + myT) / 2;
        double area2 = Math.sqrt(s * (s-sideBC) * (s-sideQ) * (s-myT));

        myT = t * sideAB;
        double sideR = Math.sqrt(Math.pow(sideCA, 2) + Math.pow(myT, 2));
        s = (sideCA + sideR + myT) /2;
        double area3 = Math.sqrt(s* (s-sideCA) * (s-sideR) * (s-myT));


        out.printf("area 1: %.5f area 2: %.5f area 3: %.5f\n", area1, area2, area3);
        out.println("Area = " + area);
        double smallerArea = -1 * (area - (area1 + area2 + area3));


        double ratio = smallerArea / area;
        out.println("Smaller Area = " + smallerArea);
        out.println("Ratio: " + ratio);



    }
}
/*
Ax: 0
Ay: 0
Bx: 3
By: 0
Cx: 3
Cy: 2
T (0 - 0.5): 0.333
area 1: 0.99900 area 2: 1.20065 area 3: 1.80097
Area = 3.000000000000001
Smaller Area = 1.0006214368237716
Ratio: 0.3335404789412571

Process finished with exit code 0
*/

