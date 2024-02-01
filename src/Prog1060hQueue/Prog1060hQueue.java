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
            Queue<node> rented = new LinkedList<node>();

            for (int i = 0; i < 5; i++) list.add(new LinkedList<node>());

            double SCostDay = 0;
            double SCostMile = 0;
            double CCostDay = 0;
            double CCostMile = 0;
            double MCostDay = 0;
            double MCostMile = 0;
            double WCostDay = 0;
            double WCostMile = 0;
            double LCostDay = 0;
            double LCostMile = 0;

            while (rates.hasNext()) {
                String a = rates.nextLine();
                String[] line = a.split(" ");
                String type = line[0].substring(0, 1);
                double costDay = Double.parseDouble(line[0].substring(1));
                double costMile = Double.parseDouble(line[1]);

                if (type.equals("S")) {
                    SCostDay = costDay;
                    SCostMile = costMile;
                } else if (type.equals("C")) {
                    CCostDay = costDay;
                    CCostMile = costMile;
                } else if (type.equals("M")) {
                    MCostDay = costDay;
                    MCostMile = costMile;
                } else if (type.equals("W")) {
                    WCostDay = costDay;
                    WCostMile = costMile;
                } else {
                    LCostDay = costDay;
                    LCostMile = costMile;
                }

            }

            while (inventory.hasNext()) {
                String a = inventory.nextLine();
                String type = a.substring(0, 1);
                String car = a.substring(1, 11);
                String mileage = a.substring(11);
                double miles = Double.parseDouble(mileage);

                if (type.equals("S")) {
                    node vehicle = new node(car, miles, SCostDay, SCostMile);
                    list.get(0).add(vehicle);
                } else if (type.equals("C")) {
                    node vehicle = new node(car, miles, CCostDay, CCostMile);
                    list.get(1).add(vehicle);
                } else if (type.equals("M")){
                    node vehicle = new node(car, miles, MCostDay, MCostMile);
                    list.get(2).add(vehicle);
                } else if (type.equals("W")) {
                    node vehicle = new node(car, miles, WCostDay, WCostMile);
                    list.get(3).add(vehicle);
                } else {
                    node vehicle = new node(car, miles, LCostDay, LCostMile);
                    list.get(4).add(vehicle);
                }
            }

            while (transact.hasNext()) {
                String a = transact.nextLine();
                String thing = a.substring(0, 1);
                if (thing.equals("L")) {
                    String type = a.substring(1);
                    display(list, type);
                } if (thing.equals("R")) {
                    String type = a.substring(1);
                    if (type.equals("S")) if (!list.get(0).isEmpty()) rented.add(list.get(0).remove());
                    if (type.equals("C")) if (!list.get(1).isEmpty()) rented.add(list.get(1).remove());
                    if (type.equals("M")) if (!list.get(2).isEmpty()) rented.add(list.get(2).remove());
                    if (type.equals("W")) if (!list.get(3).isEmpty()) rented.add(list.get(3).remove());
                    if (type.equals("L")) if (!list.get(4).isEmpty()) rented.add(list.get(4).remove());
                } if (thing.equals("C")) {
                    out.println("\nRented");
                    Iterator<node> iterator = rented.iterator();
                    while (iterator.hasNext()) out.println(iterator.next());
                    }
                }
        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }

    public static void display(ArrayList<Queue<node>> list, String a) {
        if (a.equals("S")){
            out.println("\nListing for Sub Comapct");
            for (node node : list.get(0)) {out.println(node);}
        } else if (a.equals("C")) {
            out.println("\nListing for Compact");
            for (node node : list.get(1)) {out.println(node);}
        } else if (a.equals("M")) {
            out.println("\nListing for Midsize");
            for (node node : list.get(2)) {out.println(node);}
        } else if (a.equals("W")) {
            out.println("\nListing for Wagon");
            for (node node : list.get(3)) {out.println(node);}
        } else {
            out.println("\nListing for Luxury");
            for (node node : list.get(4)) {out.println(node);}
        }
    }
}
