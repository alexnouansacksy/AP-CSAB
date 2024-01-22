// Alex Nouansacksy
// Prog 703s
// 01/22/2024
package Prog703s;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Prog703s {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog703s.txt"));

            ArrayList<computer> list = new ArrayList<computer>();

            while (keyboard.hasNext()) {

                int num = keyboard.nextInt();
                String name = keyboard.next();
                int number = keyboard.nextInt();
                double value = keyboard.nextDouble();

                if (num == 1) {
                    String a = keyboard.next();
                    computer b = new apple(name, number, value, a);
                    list.add(b);
                } else if (num == 2) {
                    double a = keyboard.nextDouble();
                    computer b = new windows(name, number, value, a);
                    list.add(b);
                } else if (num == 3) {
                    int a = keyboard.nextInt();
                    computer b = new linux(name, number, value, a);
                    list.add(b);

                }
            }

            int greengold = 0;
            int windows7 = 0;
            int specialcode5 = 0;

            for (computer x : list) {
                if (x instanceof apple) {
                    if (((apple) x).getColor().equals("Green") || ((apple) x).getColor().equals("Gold")) greengold++;
                } else if (x instanceof windows) {
                    if (((windows) x).getVersionNumber() == 7.0) windows7++;
                } else if (x instanceof linux) {
                    if ( ((linux) x).getMySpecialCode() % (double) 10 == 5) specialcode5 ++;
                }
            }

            out.println("Number of Green or Gold Computers: " + greengold);
            out.println("Number of machines running Windows 7.0: " + windows7);
            out.println("Number of special codes ending in a 5: " + specialcode5 + "\n");

            for (computer x : list) {
                if (x instanceof apple) {
                    out.println("Apple Computer\n" + x.getName() + "\n" + x.getNumber() + "\n" + x.getValue() + "\n" + ((apple) x).getColor() + "\n");
                } else if (x instanceof windows) {
                    out.println("Windows Computer\n" + x.getName() + "\n" + x.getNumber() + "\n" + x.getValue() + "\n" + ((windows) x).getVersionNumber() + "\n");
                } else if (x instanceof linux) {
                    out.println("Linux Computer\n" + x.getName() + "\n" + x.getNumber() + "\n" + x.getValue() + "\n" + ((linux) x).getMySpecialCode() + "\n");
                }
            }

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
/*
Number of Green or Gold Computers: 1
Number of machines running Windows 7.0: 2
Number of special codes ending in a 5: 4

Apple Computer
Bill
1
1250.0
Red

Windows Computer
Gerry
2
758.65
7.0

Linux Computer
Linny
3
1578.85
15785.0

Apple Computer
Cranky
8
1275.0
Red

Windows Computer
Gerbal
15
1758.65
7.258

Linux Computer
Linda
15
578.85
157.0

Apple Computer
Frankster
11
1450.0
Blue

Windows Computer
Greg
22
1778.65
7.11

Linux Computer
Lodi
32
2878.85
15.0

Apple Computer
Bounty
17
1330.0
Yellow

Windows Computer
Gerald
26
1558.65
7.0

Linux Computer
Like
31
1600.85
17575.0

Apple Computer
Bounce
16
1175.0
Red

Windows Computer
George
21
1758.65
7.01

Linux Computer
Lid
32
1222.85
155.0

Apple Computer
Binky
17
1850.0
Green


Process finished with exit code 0

 */