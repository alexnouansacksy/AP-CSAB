package MSOE2018;// Alex Nouansacksy
// MSOE 2019 Question 9
// 10/16/2023
import java.util.*;
import static java.lang.System.out;

public class MSOE2018_9 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.print("Enter the string: ");
        String str = keyboard.nextLine().toUpperCase();


        out.print("Enter key: ");
        int key = Integer.valueOf(keyboard.nextLine());
        String binarykey = Integer.toBinaryString(key);

        int cnt = 0;

        for (int i = 0; i < str.length() / 5; i++) {

            char[] list = str.substring(cnt, cnt+5).toCharArray();
            cnt += 5;

            ArrayList<String> binary = new ArrayList<>();
            for (char c : list) {
                c -=32;
                String theBinary = Integer.toBinaryString((int)c);
                if (Integer.toBinaryString(c).equals("0")) {
                    binary.add("000000");
                } else {
                    binary.add(theBinary);
                }
            }

            String all = "";
            for (String s : binary) all = all + s;

            while (binarykey.length() < all.length()) binarykey = "0" + binarykey;

            String xor = "";

            for (int j = 0; j < all.length(); j++) {
                if (all.charAt(j) == '0' && binarykey.charAt(j) == '1' ||
                        all.charAt(j) == '1' && binarykey.charAt(j) == '0')
                    xor = xor + "1";
                    else xor = xor + "0";
            }

            ArrayList<String> newbinary = new ArrayList<>();
            for (int j = 0; j < xor.length() - 5; j++) {
                String thenewbinary = xor.substring(j, j + 6);
                j += 5;
                newbinary.add(thenewbinary);
            }
            for (String s : newbinary) {
                int thing = Integer.parseInt(s, 2);
                thing += 32;
                out.print((char) thing);
            }

            String temp = binarykey.substring(0, 1);
            binarykey = binarykey.substring(1);
            binarykey = binarykey + temp;



        }
    }
}

/*
Enter the string: welcome to msoe
Enter key: 8675309
W$I<"LG++U"ID11
Process finished with exit code 0

 */