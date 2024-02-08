// Alex Nouansacksy
// Prog1999t
// 2/5/2024

package Prog1999t;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Prog1999t {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog1999.txt"));
            int len = keyboard.nextInt();
            eel[] eels = new eel[len];

            for (int i = 0; i < len; i++) {
                String firstName = keyboard.next();
                String lastName = keyboard.next();

                int[][] eaten = new int[3][5];

                for (int j = 0; j < 3; j++)
                    for (int k = 0; k < 5; k++)
                        eaten[j][k] = keyboard.nextInt();

                LinkedList<String> namesEaten = new LinkedList<>();

                String temp = keyboard.next();
                while (!temp.equals("-1")){
                    namesEaten.add(temp);
                    temp = keyboard.next();
                }

                eel eel = new eel((firstName + " " + lastName), eaten, namesEaten);
                eels[i] = eel;
            }

            ArrayList<bunny> bunnies = new ArrayList<bunny>();
            while (keyboard.hasNext()) {
                String name = keyboard.next();
                int soldTo = keyboard.nextInt();
                Set<String> people = new HashSet<>();

                for (int i = 0; i < soldTo; i++) people.add(keyboard.next());
                int cnt = keyboard.nextInt();

                Map<Integer, String> wow = new HashMap<Integer, String>();

                for (int i = 0; i < cnt; i++) {
                    int magicNumber = keyboard.nextInt();
                    String magicQuality = keyboard.next();
                    wow.put(magicNumber, magicQuality);
                }

                TreeSet<Integer> tree = new TreeSet<>();

                Random rand = new Random();
                for (int i = 0; i < 100; i++) tree.add(rand.nextInt(100000) + 1);

                bunny claire = new bunny(name, people, wow, tree);
                bunnies.add(claire);
            }

            // Which eel ate the most fish?
            out.println("For the Eeels: ");
            out.println("1) Which eel ate the most fish?");
            int mostEatenCnt = 0;
            String mostEaten = "";
            for (eel eel : eels) {
                int thingseaten = 0;
                int[][] eaten = eel.getEaten();
                for (int[] ints : eaten) for (int j = 0; j < eaten[0].length; j++) thingseaten += ints[j];

                if (thingseaten > mostEatenCnt) {
                    mostEatenCnt = thingseaten;
                    mostEaten = eel.getName();
                }
            }
            out.print("\t" + mostEaten + " ate the most fish, with " + mostEatenCnt + " fish.");
            out.println();

            // How much did it cost to feed all of the eels on the 2nd Tuesday?
            out.println("2) How much did it cost to feed all of the eels on the 2nd Tuesday?");
            int total = 0;
            for (eel eel : eels) {
                int[][] eaten = eel.getEaten();
                int fishes = eaten[1][1]; // second week, second day
                total += (2 * fishes);
            }
            out.println("\t" + "It costed $" + total + " to feed all the eels on the 2nd Tuesday");

            // If fish cost 1 on Monday, 2 on Tuesday … all the way to 5 on Friday, which eel costs the most to feed?
            out.println("3) If fish cost 1 on Monday, 2 on Tuesday … all the way to 5 on Friday, which eel costs the most to feed?");
            int mostFeed = 0;
            String mostFed = "";
            for (eel eel : eels) {
                int cost = 0;
                int[][] eaten = eel.getEaten();
                for (int[] ints : eaten) for (int j = 0; j < eaten[0].length; j++) cost += ints[j] * (j + 1);

                if (cost > mostFeed) {
                    mostFeed = cost;
                    mostFed = eel.getName();
                }
            }
            out.println("\t" + mostFed + " costed the most to feed, with $" + mostFeed);

            // If fish cost 1 on Monday, 2 on Tuesday … all the way to 5 on Friday, which eel costs the most to feed on week1? Week2? Week3?
            out.println("4) If fish cost 1 on Monday, 2 on Tuesday … all the way to 5 on Friday, which eel costs the most to feed on week1? Week2? Week3?");
            int fed1 = 0;
            String name1 = "";
            int fed2 = 0;
            String name2 = "";
            int fed3 = 0;
            String name3 = "";

            for (eel eel : eels) {
                int cost1 = 0;
                int cost2 = 0;
                int cost3 = 0;

                int[][] eaten = eel.getEaten();
                for (int i = 0; i < 5; i++) {
                    cost1 += eaten[0][i];
                    cost2 += eaten[1][i];
                    cost3 += eaten[2][i];
                }
                if (cost1 > fed1) {
                    fed1 = cost1;
                    name1 = eel.getName();
                } if (cost2 > fed2) {
                    fed2 = cost2;
                    name2 = eel.getName();
                } if (cost3 > fed3) {
                    fed3 = cost3;
                    name3 = eel.getName();
                }
            }

            out.println("\t" + name1 + " costed the most to feed on week 1 with $" + fed1);
            out.println("\t" + name2 + " costed the most to feed on week 2 with $" + fed2);
            out.println("\t" + name3 + " costed the most to feed on week 3 with $" + fed3);

            // What is the name of the longest fish that each eel has eaten, and which eel ate the longest fish?
            out.println("5) What is the name of the longest fish that each eel has eaten, and which eel ate the longest fish?");
            int longestFish = 0;
            String longestFishName = "";
            String longestFishOwner = "";
            for (eel eel : eels) {
                LinkedList<String> eaten = eel.getNamesEaten();
                for (String s : eaten) if (s.length() > longestFish){
                    longestFish = s.length();
                    longestFishName = s;
                    longestFishOwner = eel.getName();
                }
            }
            out.println("\t" + longestFishOwner + " ate the longest fish, " + longestFishName);

            // Did any of the eels eat a fish of the same name?
            out.println("6) Did any of the eels eat a fish of the same name?");
            boolean same = false;
            for (int i = 0; i < 5; i++) {
                LinkedList<String> eaten = eels[i].getNamesEaten();
                LinkedList<String> eaten2 = eels[i].getNamesEaten();
                for (String s : eaten)
                    for (String string : eaten2) if (s.equals(string)) same = true;
            }
            if (same) out.println("\tYes");
            else out.println("\tNo");

            // What day was the most expensive day to feed the eels? Monday, Tuesday, …
            out.println("7) What day was the most expensive day to feed the eels? Monday, Tuesday, …" );
            int monday = 0;
            int tuesday = 0;
            int wednesday = 0;
            int thursday = 0;
            int friday = 0;
            for(eel eel : eels) {
                int[][] eaten = eel.getEaten();
                monday += (eaten[0][0] + eaten[1][0] + eaten[2][0]);
                tuesday += (eaten[0][1] + eaten[1][1] + eaten[2][1]);
                wednesday += (eaten[0][2] + eaten[1][2] + eaten[2][2]);
                thursday += (eaten[0][3] + eaten[1][3] + eaten[2][3]);
                friday += (eaten[0][4] + eaten[1][4] + eaten[2][4]);
            }
            int max = Integer.max(monday, Integer.max(tuesday, Integer.max(wednesday, Integer.max(thursday, friday))));
            if (max == monday) out.print("\t + Monday");
            if (max == tuesday) out.print("\t + Tuesday");
            if (max == wednesday) out.print("\t + Wednesday");
            if (max == thursday) out.print("\t + Thursday");
            if (max == friday) out.print("\t Friday");
            out.print(" with $" + max);

            // Calculate the total number of unique individuals that the bunnies sold feet to.
            out.println("\n\nFor the bunnies");
            out.println("1) Calculate the total number of unique individuals that the bunnies sold feet to.");
            int tot = 0;
            for (bunny claire : bunnies) {
                Set<String> soldTo = claire.getSoldTo();
                tot += soldTo.size();
            }
            out.println("\tSold to " + tot + " unique individuals.");

            // Check the numbers in all of the bunny’s trees, total the largest and smallest number of each tree.
            out.println("2) Check the numbers in all of the bunny’s trees, total the largest and smallest number of each tree. ");
            tot = 0;
            for (bunny claire: bunnies) {
                TreeSet<Integer> ints = claire.getInts();
                tot += ints.first();
                tot += ints.last();
            }
            out.println("\tTotal of largest and smallest numbers is " + tot);

            // Calculate the total number of Magic Hats for all of the bunnies.
            out.println("3) Calculate the total number of Magic Hats for all of the bunnies.");
            tot = 0;
            for (bunny claire: bunnies) tot += claire.getHats().size();
            out.println("\t" + tot + " total hats.");

            // Calculate the bunny that has the most letters in all of its magic hats.
            out.println("4) Calculate the bunny that has the most letters in all of its magic hats.");
            int mostLetters = 0;
            String mostLettersName = "";
            for (bunny claire: bunnies) {
                int sum = 0;
                Map<Integer, String> wow = claire.getHats();
                Set<Integer> keys = wow.keySet();
                for (Integer integer : keys) {
                    String curr = wow.get(integer);
                    tot += curr.length();
                }
                if (tot > mostLetters) {
                    mostLetters = tot;
                    mostLettersName = claire.getName();
                }
            }
            out.println("\t" + mostLettersName + " has the most letters in all of its magic hats.");

            // Which bunny has the single longest name for its magic hat.
            out.println("5) Which bunny has the single longest name for its magic hat.");
            int longestHat = 0;
            String hatName = "";
            String hatPerson = "";
            for (bunny claire: bunnies) {
                Map<Integer, String> wow = claire.getHats();
                Set<Integer> keys = wow.keySet();
                for (Integer integer : keys) {
                    String curr = wow.get(integer);
                    if (curr.length() > longestHat){
                        longestHat = curr.length();
                        hatPerson = claire.getName();
                        hatName = curr;
                    }
                }
            }
            out.println("\t" + hatPerson + " has the longest name for its hat, "+ hatName);

            // Get rid of the bunny with the fewest number of magic hats.
            out.println("6) Get rid of the bunny with the fewest number of magic hats.");
            int fewLoc = -1;
            int few = 9999;
            for (int i = 0; i < bunnies.size(); i++) {
                int hats = bunnies.get(i).getHats().size();
                if (hats < few) {
                    few = hats;
                    fewLoc = i;
                }
            }
            out.println("\tRemoved " + bunnies.get(fewLoc).getName() + " for having the fewest hats, " + few);
            bunnies.remove(fewLoc);

            out.println("7) The bunnies had a big sale but Jill and Pill were the only to show up and buy.  Add Jill to each of the Sets of purchasers and Pill to all of the odd bunnies as a purchaser.");
            for (int i = 0; i < bunnies.size(); i++) {
                bunny claire = bunnies.get(i);
                Set<String> set = claire.getSoldTo();
                set.add("Jill");
                if (i % 2 == 1) set.add("Pill");
                bunny b = new bunny(claire.getName(), set, claire.getHats(), claire.getInts());
                bunnies.remove(i);
                bunnies.add(i, b);
            }

            out.println("8) The first bunny just purchased a magic hat with a number of 100 which polymorphs and the last bunny bought a magic hat with a number of 101 which shrinks.");
            Map<Integer, String> curr = bunnies.get(0).getHats();
            curr.put(100, "polymorph");
            bunnies.remove(0);
            bunny b = new bunny(bunnies.get(0).getName(), bunnies.get(0).getSoldTo(), curr, bunnies.get(0).getInts());
            bunnies.add(0, b);

            curr = bunnies.get(bunnies.size() - 1).getHats();
            curr.put(101, "shrink");
            bunnies.remove(bunnies.size() - 1);
            b = new bunny(bunnies.get(bunnies.size() - 1).getName(), bunnies.get(bunnies.size() - 1).getSoldTo(), curr, bunnies.get(bunnies.size() - 1).getInts());
            bunnies.add(b);

            out.println("9) The second bunny lost his second magic hat.");
            curr = bunnies.get(1).getHats();
            curr.remove(8);
            b = new bunny(bunnies.get(1).getName(), bunnies.get(1).getSoldTo(), curr, bunnies.get(1).getInts());
            bunnies.remove(1);
            bunnies.add(1, b);

            out.println("10) Fred is not allowed to be a customer of any bunny any more.  Delete Fred from the set of purchasers from all of the bunnies.");
            for (bunny claire : bunnies) {
                Set<String> soldTo = claire.getSoldTo();
                soldTo.remove("Fred");
            }

            out.println("11) How many of the bunnies has Pill been a customer?");
            int cnt = 0;
            for (bunny claire: bunnies) {
                Set<String> soldTo = claire.getSoldTo();
                if (soldTo.contains("Pill")) cnt++;
            }
            out.println("\t" + cnt);

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}

/*
For the Eeels:
1) Which eel ate the most fish?
	Patt Anne ate the most fish, with 975 fish.
2) How much did it cost to feed all of the eels on the 2nd Tuesday?
	It costed $422 to feed all the eels on the 2nd Tuesday
3) If fish cost 1 on Monday, 2 on Tuesday … all the way to 5 on Friday, which eel costs the most to feed?
	Patt Anne costed the most to feed, with $3038
4) If fish cost 1 on Monday, 2 on Tuesday … all the way to 5 on Friday, which eel costs the most to feed on week1? Week2? Week3?
	Patt Anne costed the most to feed on week 1 with $354
	Boby Wine costed the most to feed on week 2 with $313
	Patt Anne costed the most to feed on week 3 with $325
5) What is the name of the longest fish that each eel has eaten, and which eel ate the longest fish?
	Patt Anne ate the longest fish, Julianna
6) Did any of the eels eat a fish of the same name?
	Yes
7) What day was the most expensive day to feed the eels? Monday, Tuesday, …
	 Friday with $799

For the bunnies
1) Calculate the total number of unique individuals that the bunnies sold feet to.
	Sold to 17 unique individuals.
2) Check the numbers in all of the bunny’s trees, total the largest and smallest number of each tree.
	Total of largest and smallest numbers is 405991
3) Calculate the total number of Magic Hats for all of the bunnies.
	24 total hats.
4) Calculate the bunny that has the most letters in all of its magic hats.
	Vince has the most letters in all of its magic hats.
5) Which bunny has the single longest name for its magic hat.
	Joan has the longest name for its hat, Julianna
6) Get rid of the bunny with the fewest number of magic hats.
	Removed Joan for having the fewest hats, 4
7) The bunnies had a big sale but Jill and Pill were the only to show up and buy.  Add Jill to each of the Sets of purchasers and Pill to all of the odd bunnies as a purchaser.
8) The first bunny just purchased a magic hat with a number of 100 which polymorphs and the last bunny bought a magic hat with a number of 101 which shrinks.
9) The second bunny lost his second magic hat.
10) Fred is not allowed to be a customer of any bunny any more.  Delete Fred from the set of purchasers from all of the bunnies.
11) How many of the bunnies has Pill been a customer?
	3

Process finished with exit code 0
 */
