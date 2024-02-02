package MSOE2018;// Alex Nouansacksy
// MSOE 2018 Question 1
// 10/09/2023
import static java.lang.System.out;
import java.util.*;

public class MSOE2018_1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.print("Enter sentence: ");
        String sentence = keyboard.nextLine();
        for (int i = 0; i < sentence.length() - 2; i++) {
            if (sentence.charAt(i) == 'I' && sentence.charAt(i+1) == 39 && sentence.charAt(i+2) == 'm')
                sentence = sentence.substring(0, i) + "I am" + sentence.substring(i + 3);
            if (sentence.charAt(i) == 'I' && sentence.charAt(i+1) == 39 && sentence.substring(i+2, i+4) .equals("ve"))
                sentence = sentence.substring(0, i) + "I have" + sentence.substring(i + 4);
            if (sentence.charAt(i) == 'I' && sentence.charAt(i+1) == 39 && sentence.substring(i+2, i+4).equals("ll"))
                sentence = sentence.substring(0, i) + "I will" + sentence.substring(i + 4);
        }

        out.print(sentence);

    }
}

/*
Enter sentence: I'd like to buy a candy bar but I'll settle for a carrot.
I'd like to buy a candy bar but I will settle for a carrot.
Process finished with exit code 0


Enter sentence: I'm
I am
Process finished with exit code 0

Enter sentence: I've
I have
Process finished with exit code 0

 */