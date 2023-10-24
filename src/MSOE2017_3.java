// Alex Nouansacksy
// MSOE 2017 Question 3
// 10/24/2023
import java.util.*;
import static java.lang.System.out;

public class MSOE2017_3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.print("Word 1: ");
        String word1 = keyboard.next();
        out.print("Word 2: ");
        String word2 = keyboard.next();

        for (int i = 0; i < word1.length(); i++)
            for (int j = 0; j < word2.length(); j++)
                if (word1.substring(i, i + 1).equals(word2.substring(j, j + 1)))
                    out.println("(" + (i+1) + "," + (j+1) + ")");
    }
}
/*
Word 1: dog
Word 2: bot
(2,2)

Process finished with exit code 0

Word 1: cat
Word 2: dog

Process finished with exit code 0

Word 1: crisis
Word 2: oasis
(3,4)
(4,3)
(4,5)
(5,4)
(6,3)
(6,5)

Process finished with exit code 0

 */