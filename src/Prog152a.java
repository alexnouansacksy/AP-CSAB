// Alex Nouansacksy
// Prog152a
// 04/22/2024
import static java.lang.System.out;
import java.util.*;

public class Prog152a {
    public static int sum(int n, int max) {
        if (n == max) return n;
        else return n + sum(n + 3, max);
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        out.print("Starting Number: ");
        int n = keyboard.nextInt();
        out.print("Ending Number: ");
        int end = keyboard.nextInt();


        int sum = sum(0, 9669);
        out.println("The sum of the multiples of 3, from " + n +  " to " + end + " is " + sum);
    }
}

/*
Starting Number: 0
Ending Number: 9669
The sum of the multiples of 3, from 3 to 9669 is 15586428
 */
