// Alex Nouansacksy
// LP3-14 w/classes
// 09/05/2023
import java.util.*;
import static java.lang.System.out;
public class LP3Exericse14 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.println("Election Results for New York: ");
        out.print("Awbrey: ");
        int awbreyNY = keyboard.nextInt();
        out.print("Martinez: ");
        int martinezNY = keyboard.nextInt();

        out.println("Election Results for New Jersey: ");
        out.print("Awbrey: ");
        int awbreyNJ = keyboard.nextInt();
        out.print("Martinez: ");
        int martinezNJ = keyboard.nextInt();

        out.println("Election Results for Connecticut: ");
        out.print("Awbrey: ");
        int awbreyCT = keyboard.nextInt();
        out.print("Martinez: ");
        int martinezCT = keyboard.nextInt();

        ClLP3Exercise14 wow = new ClLP3Exercise14(awbreyNY, martinezNY, awbreyNJ, martinezNJ, awbreyCT, martinezCT);
        wow.calculate();
        wow.print();
    }
}
