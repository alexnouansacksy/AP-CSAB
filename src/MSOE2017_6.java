// Alex Nouansacksy
// MSOE 2017 Question 6
// 3/27/2024
import static java.lang.System.out;
import java.util.*;

public class MSOE2017_6 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.print("Enter num: ");
        int num = keyboard.nextInt();
        ArrayList<Integer> factors = primeFactors(num);
        int result = num;
        for (int i = 0; i < factors.size(); i++) {
            result *= (1 + (1 / (double)factors.get(i)));
        }
        out.println(result);
    }

    public static ArrayList<Integer> primeFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        while (n % 2 == 0) {
            if(!factors.contains(2)) factors.add(2);
            n /= 2;
        }
        for (int i = 3; i < Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                if(!factors.contains(i)) factors.add(i);
                n = n / i;
            }
        }
        if (n > 2)
            factors.add(n);
        return factors;
    }
}
/*
Enter num: 1
1

Process finished with exit code 0

Enter num: 2
3

Process finished with exit code 0

Enter num: 3
4

Process finished with exit code 0

Enter num: 4
6

Process finished with exit code 0

Enter num: 6
12

Process finished with exit code 0

Enter num: 30
72

Process finished with exit code 0
 */
