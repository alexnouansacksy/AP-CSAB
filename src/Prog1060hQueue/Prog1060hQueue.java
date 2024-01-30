package Prog1060hQueue;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog1060hQueue {
    public static void main(String[] args) {
        try {
            Scanner rates = new Scanner(new File("data/rates.dat"));
            Scanner inventory = new Scanner(new File("data/invntory.dat"));
            Scanner transact = new Scanner (new File("data/transact.dat"));

            ArrayList<Queue<node>> list = new ArrayList<>();


            for (int i = 0; i < 5; i++) list.add(new LinkedList<node>());


            while (inventory.hasNext()) {
                String a = inventory.nextLine();
                String type = a.substring(0, 1);
                String car = a.substring(1, 11);
                String mileage = a.substring(11);
                double miles = Double.parseDouble(mileage);

                node vehicle = new node(car, miles);
                if (type.equals("S")) list.get(0).add(vehicle);
                else if (type.equals("C")) list.get(1).add(vehicle);
                else if (type.equals("M")) list.get(2).add(vehicle);
                else if (type.equals("W")) list.get(3).add(vehicle);
                else list.get(4).add(vehicle);
            }

            for (int i = 0; i < 5; i++) {
                for (node node : list.get(i)) {System.out.println(node);}
                out.println("------");
            }

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
