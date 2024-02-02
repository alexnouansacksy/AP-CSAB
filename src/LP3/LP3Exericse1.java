package LP3;// Alex Nouansacksy
// LP 3-1
// 09/05/2023
import java.util.*;
import static java.lang.System.out;
    public class LP3Exericse1 {
        public static void main(String[] args) {
            Scanner keyboard = new Scanner(System.in);
            out.print("Enter a time less than 4.5 seconds: ");
            double time = keyboard.nextInt();
            double height = 100 - (4.9 * time * time);
            out.print("The height of the object is: " + height + " meters");
        }
    }

// Output
// Enter a time less than 4.5 seconds: 2
// The height of the object is: 80.4 meters
