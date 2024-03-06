package CodingQuest;

import java.io.File;
import java.io.IOException;
import java.util.*;
import static java.lang.System.out;

public class Day3 {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("src/CodingQuest/Day3Data.txt"));
            ArrayList<String> list = new ArrayList<>();
            int cnt;
            cnt = keyboard.nextInt();
            for (int i = 0; i < cnt; i++) list.add(".");

            while (keyboard.hasNext()) {
                cnt = keyboard.nextInt();
                for (int i = 0; i < cnt; i++) list.add("#");

                cnt = keyboard.nextInt();
                for (int i = 0; i < cnt; i++) list.add(".");
            }
            cnt = 0;
            for (int i = 0; i < 80; i++) {
                for (int j = 0; j < 100; j++) {
                    out.print(list.get(cnt));
                    cnt++;
                }
                out.println();
            }
            out.println(cnt);
        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
