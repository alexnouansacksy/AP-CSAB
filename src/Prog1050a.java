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
            out.println("\nHow many sales were made to Europe?\n" + cnt);

            // How many items of Cereal were bought by Cambodia?
            cnt = 0;
            for (String[] strings : list)
                if (strings[0].equals("Europe") && strings[2].equals("Cereal")) cnt+= Integer.parseInt(strings[8]);
            out.println("\nHow many items of Cereal were bought by Cambodia?\n" + cnt);

            // What was the profit on all of the meat?
            double total = 0;
            for (int i = 1; i < list.size(); i++) {
                String[] strings = list.get(i);
                total+= Double.parseDouble(strings[13]);
            }
            out.println("\nWhat was the profit on all of the meat?\n" + total);

            // What percentage of the sales were High Priority?
            int hcnt = 0;
            for (String[] strings : list) {
                if (strings[4].equals("H")) hcnt++;
                cnt++;
            }
            out.println("\n What percentage of the sales were High Priority?\n" + hcnt + "/" + cnt + " or ");
            out.printf("%.2f", ((double) hcnt/cnt) * 10);
            out.print("%");





        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
