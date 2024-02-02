package LP3;// Alex Nouansacksy
// LP 3-3
// 09/05/2023
import java.util.*;
import static java.lang.System.out;
public class LP3Exercise3 {
    public static void main(String[] args) {
        out.println("College Calculator");
        Scanner keyboard = new Scanner (System.in);
        out.print("Rent Cost: ");
        double rent = keyboard.nextDouble();
        out.print("Tuition Cost: ");
        double tuition = keyboard.nextDouble();
        out.print("Books Cost: ");
        double books = keyboard.nextDouble();
        out.print("Food Cost: ");
        double food = keyboard.nextDouble();
        out.print("Extra Costs: ");
        double extra = keyboard.nextDouble();
        out.print("Scholarships Total:");
        double scholarships = keyboard.nextDouble();
        out.print("Grants Total:");
        double grants = keyboard.nextDouble();

        double expenses = rent + tuition + books + food + extra;
        double offset = scholarships + grants;
        double total = expenses - offset;
        if (total < 0) out.print("Your total cost is $0!");
        else out.print("Your total cost is $" + total);
    }
}

// Output
/*
College Calculator
Rent Cost: 1000
Tuition Cost: 1000
Books Cost: 2000
Food Cost: 3000
Extra Costs: 5000
Scholarships Total:10000
Grants Total:500
Your total cost is $1500

*/