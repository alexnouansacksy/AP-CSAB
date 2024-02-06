// Alex Nouansacksy
// Prog 1060h Queue
// 2/1/2024

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
                }
                if (thing.equals("R")) {
                    String type = a.substring(1);
                    if (type.equals("S")) if (!list.get(0).isEmpty()) rented.add(list.get(0).remove());
                    if (type.equals("C")) if (!list.get(1).isEmpty()) rented.add(list.get(1).remove());
                    if (type.equals("M")) if (!list.get(2).isEmpty()) rented.add(list.get(2).remove());
                    if (type.equals("W")) if (!list.get(3).isEmpty()) rented.add(list.get(3).remove());
                    if (type.equals("L")) if (!list.get(4).isEmpty()) rented.add(list.get(4).remove());
                }
                if (thing.equals("C")) {
                    out.println("\nRented");
                    Iterator<node> iterator = rented.iterator();
                    while (iterator.hasNext()) out.println(iterator.next());
                }
                if (thing.equals("A")) {
                    String type = a.substring(1, 2);
                    int days = Integer.parseInt(a.substring(2, 3));
                    String[] temp = a.split(" ");
                    double newMiles = Double.parseDouble(temp[1]);
                    String name = temp[2];

                    double oldMiles =0;
                    double traveled = 0;

                    double perMile = 0;
                    double perDay = 0;


                    Iterator<node> iterator = rented.iterator();
                    while (iterator.hasNext()) {
                        node current = iterator.next();
                        String currentName = current.getName().strip();
                        if (currentName.equals(name)) {
                            oldMiles = current.getMiles();
                            perMile = current.mileCost();
                            perDay = current.dayCost();
                        }
                    }

                    traveled = newMiles - oldMiles;
                    double milesCost = traveled * perMile;
                    double daysCost = days * perDay;

                    out.println("\nCar " + name);
                    out.println("Beginning Mileage " + oldMiles);
                    out.println("Ending Mileage " + newMiles);
                    out.println("Miles driven " + traveled + " @ " + perMile + " = " + milesCost);
                    out.println("days driven " + days + " @ " + perDay + " = " + daysCost);
                    out.println("Cartype " + type);
                    out.println("\nAmount Due: " + (milesCost + daysCost));

                    Queue<node> newRented = new LinkedList<node>();

                    iterator = rented.iterator();
                    while (iterator.hasNext()) {
                        node current = iterator.next();
                        String currentName = current.getName().strip();
                        if (!currentName.equals(name)) newRented.add(current);
                    }

                    rented = newRented;

                    if (type.equals("S")) list.get(0).add(new node(name, newMiles, daysCost, milesCost));
                    if (type.equals("C")) list.get(1).add(new node(name, newMiles, daysCost, milesCost));
                    if (type.equals("M")) list.get(2).add(new node(name, newMiles, daysCost, milesCost));
                    if (type.equals("W")) list.get(3).add(new node(name, newMiles, daysCost, milesCost));
                    if (type.equals("L")) list.get(4).add(new node(name, newMiles, daysCost, milesCost));
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


/* output

Listing for Sub Comapct
Yugo      	3456.3
Chevette  	1710.1
RX7       	4002.1
Sentra    	3007.0

Listing for Compact
Shadow    	831.2
Topaz     	412.5
Contour   	1091.7
Fiero     	1541.4

Listing for Midsize
Cutlass   	930.7
Mystique  	117.4
LaBaron   	831.2
Cougar    	1442.2

Listing for Wagon
Delta88   	2417.7
Caprice   	4522.8
Bonneville	5100.0

Listing for Luxury
Cadillac  	1234.5
Lincoln   	8400.2
Corvette  	10341.7

Listing for Sub Comapct

Listing for Compact

Listing for Midsize
Cougar    	1442.2

Listing for Wagon
Caprice   	4522.8
Bonneville	5100.0

Listing for Luxury
Lincoln   	8400.2
Corvette  	10341.7

Rented
Yugo      	3456.3
Chevette  	1710.1
RX7       	4002.1
Sentra    	3007.0
Shadow    	831.2
Topaz     	412.5
Contour   	1091.7
Fiero     	1541.4
Cutlass   	930.7
Mystique  	117.4
LaBaron   	831.2
Delta88   	2417.7
Cadillac  	1234.5

Car Yugo
Beginning Mileage 3456.3
Ending Mileage 3640.0
Miles driven 183.69999999999982 @ 0.22 = 40.41399999999996
days driven 2 @ 18.0 = 36.0
Cartype S

Amount Due: 76.41399999999996

Car Cadillac
Beginning Mileage 1234.5
Ending Mileage 2801.2
Miles driven 1566.6999999999998 @ 0.37 = 579.679
days driven 2 @ 34.0 = 68.0
Cartype L

Amount Due: 647.679

Car Contour
Beginning Mileage 1091.7
Ending Mileage 2031.7
Miles driven 940.0 @ 0.25 = 235.0
days driven 3 @ 20.5 = 61.5
Cartype C

Amount Due: 296.5

Listing for Sub Comapct
Yugo	3640.0

Listing for Compact
Contour	2031.7

Listing for Midsize
Cougar    	1442.2

Listing for Wagon
Caprice   	4522.8
Bonneville	5100.0

Listing for Luxury
Lincoln   	8400.2
Corvette  	10341.7
Cadillac	2801.2

Rented
Chevette  	1710.1
RX7       	4002.1
Sentra    	3007.0
Shadow    	831.2
Topaz     	412.5
Fiero     	1541.4
Cutlass   	930.7
Mystique  	117.4
LaBaron   	831.2
Delta88   	2417.7

Process finished with exit code 0

 */