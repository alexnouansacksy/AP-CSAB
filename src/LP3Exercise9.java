// Alex Nouansacksy
// LP3-9 w/ classes
// 09/05/2023
import java.util.*;
import static java.lang.System.out;
public class LP3Exercise9 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.println("Enter your birthdate: ");
        out.print("Year: ");
        int birthYear = keyboard.nextInt();
        out.print("Month: ");
        int birthMonth = keyboard.nextInt();
        out.print("Day: ");
        int birthDay = keyboard.nextInt();
        out.println("Enter today's date: ");
        out.print("Year: ");
        int year = keyboard.nextInt();
        out.print("Month: ");
        int month = keyboard.nextInt();
        out.print("Day: ");
        int day = keyboard.nextInt();

        ClLP3Exercise9 wow = new ClLP3Exercise9(birthYear, birthMonth, birthDay, year, month, day);
        wow.setStuff();
        wow.calculate();
        wow.print();

    }

}
