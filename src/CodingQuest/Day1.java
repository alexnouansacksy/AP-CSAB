// Alex Nouansacksy
// Coding Quest Day 1
// 3/4/2024

package CodingQuest;

import java.io.File;
import java.io.IOException;
import java.util.*;
import static java.lang.System.out;

public class Day1 {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("src/CodingQuest/Day1Data.txt"));
            ArrayList<Day1Class> list = new ArrayList<>();

            while (keyboard.hasNext()) {
                String a = keyboard.nextLine();
                String[] temp = a.split(" ");
                String name = temp[0].substring(0, temp[0].length() - 1);

                boolean in = false;

                Day1Class b = new Day1Class(name);
                for (Day1Class n : list){
                        if (n.getName().equals(name)) in = true;}

                if (!in) list.add(b);


                for (Day1Class day1Class : list) {
                        if (name.equals(day1Class.getName())) {
                            if (temp[1].equals("Seat") || temp[1].equals("Meals") || temp[1].equals("Luggage") ||
                                    temp[1].equals("Fee") || temp[1].equals("Tax")) {
                                day1Class.addCost(Double.parseDouble(temp[2]));
                            }
                            else if (temp[1].equals("Discount") || temp[1].equals("Rebate")) {
                                day1Class.minusCost(Double.parseDouble(temp[2]));
                            }
                        }
                    }


            }
            double min = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCost() < min) min = list.get(i).getCost();
            }
            out.println("the lowest cost is: " + min);

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}

