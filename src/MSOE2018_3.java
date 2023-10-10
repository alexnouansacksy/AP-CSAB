// Alex Nouansacksy
// MSOE 2018 Question 3
// 10/10/2023
import java.util.*;
import static java.lang.System.out;
import java.lang.Math;

public class MSOE2018_3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int minutes = 0;
        out.print("Enter minutes: ");
        minutes = keyboard.nextInt();

        double degrees =  360 * ( (double) minutes / 60);

        double x = 0;
        double y = 0;
        double test = Math.toRadians(degrees);


        if (degrees > 270) degrees -= 270;
        else if (degrees > 180) degrees -= 180;
        else if (degrees > 90) degrees -= 90;

        x = Math.cos(test);
        y = Math.sin(test);
        double temp =  x;
        x = y;
        y = temp;


        out.printf("Minute hand is at (x, y): %.2f, %.2f", x, y);

    }
}

/*
Enter minutes: 45
Minute hand is at (x, y): -1.00, 0.00
Process finished with exit code 0

Enter minutes: 10
Minute hand is at (x, y): 0.87, 0.50
Process finished with exit code 0

Enter minutes: 35
Minute hand is at (x, y): -0.50, -0.87
Process finished with exit code 0

Enter minutes: 5
Minute hand is at (x, y): 0.50, 0.87
Process finished with exit code 0
 */