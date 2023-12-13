// Alex Nouansacksy
// Prog 213b with Sets
// 12/13/2023

import java.util.*;
import static java.lang.System.out;

public class Prog213bSet {
    public static double pricePer(int n) {
        double cost;
        if (n < 100) cost = 5.95;
        else if (n < 200) cost = 5.75;
        else if (n < 300) cost = 5.40;
        else cost = 5.15;
        return cost;
    }

    public static void main(String[] args) {
        Set<Integer> wow = new HashSet<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            int num = rand.nextInt((400 - 1 + 1) - 1); // (max - min - 1 ) + 1
            wow.add(num);
        }

        Iterator<Integer> things = wow.iterator();

        while (things.hasNext()) {
            int claire = things.next();
            double price = pricePer(claire);
            double amountDue = claire * price;
            out.println("Quantity: " + claire);
            out.println("Price: $" + price);
            out.printf("Amount Due: $%.2f\n", amountDue);
            out.println();
        }
    }
}

/*
Quantity: 130
Price: $5.75
Amount Due: $747.50

Quantity: 4
Price: $5.95
Amount Due: $23.80

Quantity: 106
Price: $5.75
Amount Due: $609.50

Quantity: 331
Price: $5.15
Amount Due: $1704.65

Quantity: 334
Price: $5.15
Amount Due: $1720.10

Quantity: 143
Price: $5.75
Amount Due: $822.25

Quantity: 336
Price: $5.15
Amount Due: $1730.40

Quantity: 273
Price: $5.4
Amount Due: $1474.20

Quantity: 84
Price: $5.95
Amount Due: $499.80

Quantity: 214
Price: $5.4
Amount Due: $1155.60

Quantity: 22
Price: $5.95
Amount Due: $130.90

Quantity: 86
Price: $5.95
Amount Due: $511.70

Quantity: 87
Price: $5.95
Amount Due: $517.65

Quantity: 376
Price: $5.15
Amount Due: $1936.40

Quantity: 59
Price: $5.95
Amount Due: $351.05

Quantity: 219
Price: $5.4
Amount Due: $1182.60

Quantity: 220
Price: $5.4
Amount Due: $1188.00

Quantity: 285
Price: $5.4
Amount Due: $1539.00

Quantity: 125
Price: $5.75
Amount Due: $718.75

Quantity: 159
Price: $5.75
Amount Due: $914.25


Process finished with exit code 0

 */