// Alex Nouansacksy
// LP 3-5
// 09/05/2023
import java.util.*;
import static java.lang.System.out;
public class LP3Exercise5 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.print("Enter the change in cents: ");
        int change = keyboard.nextInt();

        int quarters = change / 25;
        change -= (quarters * 25);

        int dimes = change / 10;
        change -= (dimes * 10);

        int nickels = change / 5;
        change -= (nickels * 5);

        int pennies =  change;
        out.println("The minimum number of coins is: ");
        out.println("Quarters: " + quarters);
        out.println("Dimes: " + dimes);
        out.println("Nickels: "+ nickels);
        out.println("Pennies: " + pennies);

    }
}

//output
/*
Enter the change in cents: 212
The minimum number of coins is:
Quarters: 8
Dimes: 1
Nickels: 0
Pennies: 2

Process finished with exit code 0
 */