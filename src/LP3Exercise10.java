// Alex Nouansacksy
// LP3-10 w/classes
// 09/05/2023
import java.util.*;
import static java.lang.System.out;
public class LP3Exercise10 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.print("Enter the number of burgers: ");
        int burgers = keyboard.nextInt();
        out.print("Enter the number of fries: ");
        int fries = keyboard.nextInt();
        out.print("Enter the number of sodas: ");
        int sodas = keyboard.nextInt();
        out.print("Enter amount tendered: ");
        double cash = keyboard.nextDouble();


        ClLP3Exercise10 wow = new ClLP3Exercise10(burgers, fries, sodas, cash);
        wow.calculate();
        wow.print();
    }
}
