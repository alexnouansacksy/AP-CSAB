// Alex Nouansacksy
// LP 3-6
// 09/05/2023
import java.util.*;
import static java.lang.System.out;
public class LP3Exercise6 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.print("Enter a three-digit number: ");
        int num = keyboard.nextInt();
        int hundreds = num / 100;
        num %= 100;
        int tens = num / 10;
        num %= 10;
        int ones = num;
        out.println("The number in the hundreds place is: " + hundreds);
        out.println("The number in the tens place is: " + tens);
        out.println("The number in the ones place is: " + ones);
    }
}
/*output

Enter a three-digit number: 256
The number in the hundreds place is: 2
The number in the tens place is: 5
The number in the ones place is: 6

Process finished with exit code 0
 */