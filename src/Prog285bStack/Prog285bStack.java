// Alex Nouansacksy
// Prog 285b with Stacks
// 1/25/2024
package Prog285bStack;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog285bStack {

    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog285b.dat"));
            Stack<node> stack = new Stack<node>();

            while (keyboard.hasNext()) {
                int id = keyboard.nextInt();
                int code = keyboard.nextInt();
                double sales = keyboard.nextDouble();

                node claire = new node(id, code, sales);
                claire.setcom();
                stack.push(claire);
            }
            out.println("Number\tCode\tSales\tCommission");
            while (!stack.isEmpty()){out.println(stack.pop());}

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }

}

/* output
Number	Code	Sales	Commission
291		17		750.0	71.25
264		17		4150.0	410.5
235		5		5250.0	396.25
218		5		5000.0	375.0
203		8		3250.0	243.75
192		8		8125.0	640.625
138		17		6375.0	677.5
125		5		6500.0	502.5
118		8		7350.0	574.75
117		3		7350.0	0.0
103		5		4000.0	300.0
101		17		2250.0	213.75

Process finished with exit code 0

 */