// Alex Nouansacksy
// Marquette 2024 #7
// _/__/2024

package Marquette2024;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Prob7 {

    public static double previousAnswer = 0;
    /**
     * TODO: Write a function that takes an equation as a string and returns the answer. 
     * The equation will be in the form of a string with the following operators: +, -, *, /, and ^.
     * The equation could contain the string "ans" which will be replaced with the previous answer.
     * If the equation is invalid, print an error message and return -1.
     * If the solution is negative, print "null"
     * The addition of helper functions is suggested but not required.
     * @param  (String) expression --> a string that represents an equation
     * @return (Doubles) result --> the answer to the equation
     */
    public static Double calculate(String expression) {
        expression = expression.replaceAll("ans", "" + previousAnswer);
        expression += "S";

        ArrayList<Double> nums = new ArrayList<>();
        ArrayList<String> operations = new ArrayList<>();

        int isNum = -1;
        for (int i = 0; i < expression.length(); i++) {
            if (isNumber(expression.substring(i, i + 1))) {
                if (isNum == -1) {
                    isNum = i;
                }
                if (!isNumber(expression.substring(i + 1, i + 2))) {
                    nums.add(Double.parseDouble(expression.substring(isNum, i + 1)));
                }
            } else if (!isNumber(expression.substring(i, i + 1))) {
                operations.add(expression.substring(i, i + 1));
                isNum = -1;
            }

        }

        operations.remove(operations.size() - 1);

        for (int c = 0; c < operations.size(); c++) {
            if (operations.get(c).equals(("^"))) {
                nums.set(c, Math.pow(nums.get(c), nums.remove(c + 1)));
                operations.remove(c);
                c--;
            }
        }

        for (int c = 0; c < operations.size(); c++) {
            if (operations.get(c).equals(("*"))) {
                nums.set(c, nums.get(c) * nums.remove(c + 1));
                operations.remove(c);
                c--;
            } else if (operations.get(c).equals(("/"))) {
                nums.set(c, nums.get(c) / nums.remove(c + 1));
                operations.remove(c);
                c--;
            }
        }

        for (int c = 0; c < operations.size(); c++) {
            if (operations.get(c).equals(("+"))) {
                nums.set(c, nums.get(c) + nums.remove(c + 1));
                operations.remove(c);
                c--;
            } else if (operations.get(c).equals(("-"))) {
                nums.set(c, nums.get(c) - nums.remove(c + 1));
                operations.remove(c);
                c--;
            }
        }
        return nums.get(0);
    }

    public static boolean isNumber(String a) {
        if (a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/") || a.equals("^") || a.equals("S")) return false;
        else return true;
    }

    /*
     * It is unnecessary to edit the "main" method of each problem's provided code
     * skeleton. The main method is written for you in order to help you conform to
     * input and output formatting requirements.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression;
        double answer = 0;
        expression = scanner.nextLine();
        while (!expression.equals("exit")) {
            answer = calculate(expression);
            previousAnswer = answer;
            expression = scanner.nextLine();
        }
        System.out.printf("= %.5f\n", answer);
        scanner.close();
    }
}