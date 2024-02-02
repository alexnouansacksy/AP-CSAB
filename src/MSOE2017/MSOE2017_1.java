package MSOE2017;// Alex Nouansacksy
// MSOE 2017 Question 1
// 10/24/2023
import java.util.*;
import static java.lang.System.out;

public class MSOE2017_1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.print("Enter first letter: ");
        String firstLetter = keyboard.next();
        out.print("Enter second letter: ");
        String secondLetter = keyboard.next();
        out.print("Enter word in lowercase: ");
        String word = keyboard.next();
        int cnt = 0;
        int cnt2 = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i+1).equals(firstLetter)) cnt++;
            if (word.substring(i, i+1).equals(secondLetter)) cnt2++;
        }
        if (cnt == cnt2) out.println(firstLetter + " " + secondLetter);
        else if (cnt > cnt2) out.println(firstLetter);
        else out.println(secondLetter);
    }
}

/*
Enter first letter: m
Enter second letter: i
Enter word in lowercase: mississippi
i

Process finished with exit code 0

Enter first letter: i
Enter second letter: p
Enter word in lowercase: mississippi
i

Process finished with exit code 0

Enter first letter: i
Enter second letter: s
Enter word in lowercase: mississippi
i s

Process finished with exit code 0
 */