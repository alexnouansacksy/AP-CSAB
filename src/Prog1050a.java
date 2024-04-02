// Alex Nouansacksy
// Prog1050a
// 4/1/2024

import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.out;

public class Prog1050a {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("langdat/Lang1050.csv"));
            ArrayList<String[]> list = new ArrayList<>();
            while (keyboard.hasNext()) {
                String a = keyboard.nextLine();
                String[] b = a.split(",");
                list.add(b);
            }

            // How many sales were made to Europe?
            int cnt = 0;
            for (String[] strings : list) if (strings[0].equals("Europe")) cnt++;
            out.println("How many sales were made to Europe?\n" + cnt);

            // How many items of Cereal were bought by Cambodia?
            cnt = 0;
            for (String[] strings : list)
                if (strings[0].equals("Europe") && strings[2].equals("Cereal")) cnt+= Integer.parseInt(strings[8]);
            out.println("How many items of Cereal were bought by Cambodia?\n" + cnt);

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
