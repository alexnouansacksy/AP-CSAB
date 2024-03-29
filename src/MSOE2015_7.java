// Alex Nouansacksy
// MSOE 2015 Question 7
// 3/29/2024

import java.util.*;
import static java.lang.System.out;

class MSOE2015_7 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        out.print("num: ");
        int num = keyboard.nextInt();

        ArrayList<Integer> tri = new ArrayList<>();

        tri.add(0);
        for (int c = 1; tri.get(c - 1) <= num; c++) tri.add((c * (c + 1)) / 2);
        tri.remove(tri.size() - 1);

        int cnt = num;

        int tri1 = 0;
        int tri2 = 0;
        int tri3 = 0;

        while (cnt != 0) {
            cnt = num;
            tri1 = tri.get(tri.size() - 1);
            cnt -= tri1;

            for (int i : tri) if (i <= cnt) tri2 = i;

            cnt -= tri2;

            for (int i : tri) if (i <= cnt) tri3 = i;

            cnt -= tri3;

            tri.remove(tri.size() - 1);
        }

        out.print(tri1 + " " + tri2 + " " + tri3);
    }
}

/*
num: 30
28 1 1
Process finished with exit code 0
 */