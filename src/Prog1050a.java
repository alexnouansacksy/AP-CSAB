// Alex Nouansacksy
// Prog1050a
// 4/1/2024

import java.io.File;
import java.io.IOException;
import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
            out.print("\nWhat percentage of the sales were High Priority?\n" + hcnt + "/" + cnt + " or ");
            out.printf("%.2f", ((double) hcnt/cnt) * 10);
            out.print("%\n");

            // The company had a problem in 2012 and had to recall all of the Fruits sold in 2012, how much profits were lost?
            // 5 or 7
            total = 0;
            out.println("\nThe company had a problem in 2012 and had to recall all of the Fruits sold in 2012, how much profits were lost?");
            for (int i = 1; i < list.size(); i++) {
                String[] strings = list.get(i);
                if ((strings[5].substring(5).equals("2012") ||
                        strings[7].substring(5).equals("2012")) &&
                        strings[2].equals("Fruit")) ;
                total += Double.parseDouble(strings[13]);
            }
            out.println("$" + total + " lost.");

            // How many High priority sales were shipped more than three days of the date of the sale?
            out.println("\nHow many High priority sales were shipped more than three days of the date of the sale?");
            cnt = 0;
            for (int i = 1; i < list.size(); i++) {
                String[] strings = list.get(i);
                if (strings[4].equals("H")){
                    double days = daysBetween(strings[5], strings[7]);
                    if (days > 3) cnt++;
                }
            }
            out.println(cnt);

            // Which country had the single highest Personal Care order that created the most profit in one sale?
            out.println("\nWhich country had the single highest Personal Care order that created the most profit in one sale?");
            String highestcountry = "";
            Double highestprofit = 0.0;
            for (int i = 1; i < list.size(); i++) {
                String[] strings = list.get(i);
                if (strings[2].equals("Personal Care")){
                    if (Double.parseDouble(strings[13]) > highestprofit) {
                        highestprofit = Double.parseDouble(strings[13]);
                        highestcountry = strings[1];
                    }
                }
            }

            out.println(highestcountry + " with $" + highestprofit + " in one order.");

            // Which region bought the most Snacks?
            out.println("\nWhich region bought the most Snacks?");
            ArrayList<String> countries = new ArrayList<>();

            for (int i = 1; i < list.size(); i++) {
                String[] strings = list.get(i);
                String country = strings[1];
                if (!countries.contains(country)) countries.add(country);
            }

            int [] snacks = new int[countries.size()];

            for (int i = 1; i < list.size(); i++) {
                String[] strings = list.get(i);
                String country = strings[1];
                if (strings[2].equals("Snacks")){
                    int snackCnt = Integer.parseInt(strings[8]);
                    for (int j = 0; j < countries.size(); j++) {
                        if (countries.get(j).equals(country)) snacks[j] += snackCnt;
                    }
                }
            }

            int highSnack = 0;
            int highloc = 0;
            for (int i = 0; i < snacks.length; i++) {
                int curr = snacks[i];
                if (curr > highSnack) highSnack = curr;
                highloc = i;
            }
            out.println(countries.get(highloc) + " bought " + highSnack + " snacks.");

            // What are the total number of records of Sales to African nations?
            out.println("\nWhat are the total number of records of Sales to African nations?");
            cnt = 0;
            for (int i = 1; i < list.size(); i++) {
                String[] strings = list.get(i);
                if (strings[0].contains("Africa")) cnt ++;
            }
            out.println(cnt);

            // Now delete all sales to Kuwait.
            double totloss = 0;

            out.println("\nNow delete all sales to Kuwait.");
            for (int i = 1; i < list.size(); i++) {
                String[] strings = list.get(i);
                if (strings[1].equals("Kuwait")) totloss += Double.parseDouble(strings[13]);
                list.remove(i);
                i--;
            }

            // Limit sales of Cosmetics to Uganda to 100, the cost and profit of each sale affected in the array needs to be appropriately changed.
            out.println("Limit sales of Cosmetics to Uganda to 100, the cost and profit of each sale affected in the array needs to be appropriately changed.");
            cnt = 0;

            for (int i = 1; i < list.size(); i++) {
                String[] strings = list.get(i);
                if (strings[1].equals("Uganda") && strings[2].equals("Cosmetics")){
                    cnt++;
                    if (cnt > 100) {
                        totloss += Double.parseDouble(strings[13]);
                        list.remove(i);
                        i--;
                    }
                }
            }

            // We also ran out of Office Supplies.
            out.println("We also ran out of Office Supplies.");
            for (int i = 1; i < list.size(); i++) {
                String[] strings = list.get(i);
                if (strings[2].equals("Office Supplies")) {
                    totloss += Double.parseDouble(strings[13]);
                    list.remove(i);
                    i--;
                }
            }

            // Find any low priority sales and delete those orders from the African countries.
            out.println("Find any low priority sales and delete those orders from the African countries.");

            for (int i = 1; i < list.size(); i++) {
                String[] strings = list.get(i);
                if (strings[0].contains("Africa") && strings[4].equals("L")){
                    totloss += Double.parseDouble(strings[13]);
                    list.remove(i);
                    i--;
                }
            }

            out.println("\nHow much profit did the company lose with the trade war with these African nations?");
            out.println("$" + totloss);

        } catch (IOException e) {
            out.println("Can't find data file!");
        } catch (ParseException e) {
            out.println("idk cuh!");
            throw new RuntimeException(e);
        }
    }

    public static double daysBetween(String sale, String ship) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(sale);
        Date secondDate = sdf.parse(ship);

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diff;
    }
}

/* output
How many sales were made to Europe?
129286

How many items of Cereal were bought by Cambodia?
54256842

What was the profit on all of the meat?
1.962399822942203E11

What percentage of the sales were High Priority?
124987/54756843 or 0.02%

The company had a problem in 2012 and had to recall all of the Fruits sold in 2012, how much profits were lost?
$1.962399822942203E11 lost.

How many High priority sales were shipped more than three days of the date of the sale?
115166

Which country had the single highest Personal Care order that created the most profit in one sale?
Iceland with $250600.0 in one order.

Which region bought the most Snacks?
Fiji bought 1439284 snacks.

What are the total number of records of Sales to African nations?
192442

Now delete all sales to Kuwait.
Limit sales of Cosmetics to Uganda to 100, the cost and profit of each sale affected in the array needs to be appropriately changed.
We also ran out of Office Supplies.
Find any low priority sales and delete those orders from the African countries.

How much profit did the company lose with the trade war with these African nations?
$1.0508214116100014E9

Process finished with exit code 0
 */