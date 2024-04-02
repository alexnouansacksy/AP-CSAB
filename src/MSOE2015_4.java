// Alex Nouansacksy
// MSOE 2015 Question 4
// 3/27/2024
import java.util.*;
import static java.lang.System.out;

public class MSOE2015_4 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            out.print("Enter num: ");
            double num = keyboard.nextDouble();
            list.add(num);

            if (list.size() >= 3) {
                ArrayList<Double> temp = new ArrayList<>(list);
                Double max = Collections.max(temp);
                temp.remove(max);
                max = Collections.max(temp);
                temp.remove(max);
                max = Collections.max(temp);
                out.println(max);
            }
        }
    }
}
/*
Enter num: -5.3
Enter num: 3.7
Enter num: -5.3
-5.3
Enter num: 4.8
-5.3
Enter num: 3.7
3.7
Enter num: 12.5
3.7
Enter num: 13.7
4.8
Enter num: 8.3
8.3
Enter num: 1.2
8.3
Enter num: 5.2
8.3

Process finished with exit code 0
 */
