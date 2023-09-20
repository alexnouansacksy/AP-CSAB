// Alex Nouansacksy
// Prog506t
// 09/06/2023

package Prog506t;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Prog506t {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog506t.txt"));
            Scanner input = new Scanner(System.in);
            ArrayList<player> list = new ArrayList<player>();

            while (keyboard.hasNext()){
                String first = keyboard.next();
                String last = keyboard.next();
                String name = first + " " + last;

                int atBats = keyboard.nextInt();
                int walks = keyboard.nextInt();
                int hitByPitches = keyboard.nextInt();
                int sacrifices = keyboard.nextInt();
                int hits = keyboard.nextInt();
                int singles = keyboard.nextInt();
                int doubles = keyboard.nextInt();
                int triples = keyboard.nextInt();
                int homeruns = keyboard.nextInt();

                int assists = keyboard.nextInt();
                int putouts = keyboard.nextInt();
                int errors = keyboard.nextInt();

                offense offenseStats = new offense(atBats, walks, hitByPitches,
                        sacrifices, hits, singles, doubles, triples, homeruns);
                offenseStats.calculate();

                defense defenseStats = new defense(assists, putouts, errors);
                player wow = new player(name, offenseStats, defenseStats);
                defenseStats.calculate();

                list.add(wow);
            }
            // 	A: The Prog506t.player with the most hits.
            player mostHits = list.get(0);
            for (player player : list) if (player.getHits() > mostHits.getHits()) mostHits = player;
            out.print("A. " + mostHits.getName() + " has the most hits with " + mostHits.getHits() + " hits.");

            // B: The two players with the highest batting average.

            player highestBatting = list.get(0);
            player secondHighBatting = list.get(0);

            for (player player : list) {
                if(player.getbattingavg() > highestBatting.getbattingavg()){
                    secondHighBatting = highestBatting;
                    highestBatting = player;
                }
                else if (player.getbattingavg() > secondHighBatting.getbattingavg()) secondHighBatting = player;
            }

            out.printf("\nB. The players %s and %s have the highest battle averages, with %.3f and %.3f", highestBatting.getName(),
                    secondHighBatting.getName(), highestBatting.getbattingavg(), secondHighBatting.getbattingavg());

            // C: The two players with the worst fielding percentage.
            player worstFielding = list.get(0);
            player secondWorstFielding = list.get(0);

            for (player player : list) {
                if(player.getFielding() < worstFielding.getFielding()) {
                    secondWorstFielding = worstFielding;
                    worstFielding = player;
                }
                else if (player.getFielding() < secondWorstFielding.getFielding()) secondWorstFielding = player;
            }

            out.printf("\nC. The players %s and %s have the worst fielding averages, with %.2f and %.2f", worstFielding.getName(),
                    secondWorstFielding.getName(), worstFielding.getFielding(), secondWorstFielding.getFielding());

            // 	D: The team sorted in on base percentage order.
            ArrayList<player> sorted = new ArrayList<>();
            ArrayList<player> temp = new ArrayList<>(list);
            while (!temp.isEmpty()) {
                player lowest = temp.get(0);
                int loc = 0;
                for (int i = 0; i < temp.size(); i++) {
                    if (temp.get(i).getonbasepercentage() < lowest.getonbasepercentage()) {
                        lowest = temp.get(i);
                        loc = i;
                    }
                }
                sorted.add(temp.get(loc));
                temp.remove(loc);
            }

            out.print("\nD. Players sorted in on base percentage order.");
            for (player player : sorted) out.printf("\n%s with %.2f", player.getName(), player.getonbasepercentage());

            // 	E: The teams slugging percentage.
            double totalBases = 0;
            double totalAtBats = 0;

            for (player player : list) {
                totalBases += (player.getSingles() + (player.getDoubles() * 2) + (player.getTriples() * 3) + player.getHomeRuns() * 4);
                totalAtBats += player.getAtBats();
            }
            double teamSlug = totalBases / totalAtBats;
            out.print("\nE. The team's slugging percentage is " + teamSlug);


            // F. Total Hits
            int totalHits = 0;
            for (player player : list) { totalHits += player.getHits();}
            out.print("\nF. The team has " + totalHits + " total hits.");

            // G. Closest fielding percentage to the average;
            double averageFielding = 0;
            for (player player : list) averageFielding += player.getFielding();
            averageFielding /= list.size();

            double smallestdiff = 10000;
            player closest = list.get(0);
            for (player player : list) {
                double diff = Math.abs(player.getFielding() - averageFielding);
                if (diff < smallestdiff) {
                    smallestdiff = diff;
                    closest = player;
                }
            }

            out.printf("\nG. The average fielding percentage for the team is %f. Closest person is %s with %f", averageFielding, closest.getName(), closest.getFielding());

            // H: The user of the system should be asked if they want to see 1. The most or 2. The least of A.singles, B.doubles, C. Triples, D. Home runs and the system should print the appropriate player(s)
            out.print("\nH. Do you want to see stats for (A) Singles (B) Doubles (C) Triples (D) Homeruns: ");
            String option1 = input.next();
            out.print("\tDo you want to see the player(s) with (1) the most or (2) the least: ");
            int option2 = input.nextInt();

            ArrayList<player> mostSingles = new ArrayList<player>();
            ArrayList<player> leastSingles= new ArrayList<player>();
            ArrayList<player> mostDoubles= new ArrayList<player>();
            ArrayList<player> leastDoubles= new ArrayList<player>();
            ArrayList<player> mostTriples= new ArrayList<player>();
            ArrayList<player> leastTriples= new ArrayList<player>();
            ArrayList<player> mostHrs= new ArrayList<player>();
            ArrayList<player> leastHrs= new ArrayList<player>();

            double most1s = list.get(0).getSingles();
            double least1s = list.get(0).getSingles();
            double most2s = list.get(0).getDoubles();
            double least2s = list.get(0).getDoubles();
            double most3s = list.get(0).getTriples();
            double least3s = list.get(0).getTriples();
            double most4s = list.get(0).getHomeRuns();
            double least4s = list.get(0).getHomeRuns();

            for (player player : list) {
                if (player.getSingles() > most1s) most1s = player.getSingles();
                if (player.getSingles() < least1s) least1s = player.getSingles();
                if (player.getDoubles() > most2s) most2s = player.getDoubles();
                if (player.getDoubles() < least2s) least2s = player.getDoubles();
                if (player.getTriples() > most3s) most3s = player.getTriples();
                if (player.getTriples() < least3s) least3s = player.getTriples();
                if (player.getHomeRuns() > most4s) most4s = player.getHomeRuns();
                if (player.getHomeRuns() < least4s) least4s = player.getHomeRuns();
            }

            for (player player : list) {
                if (player.getSingles() == most1s) mostSingles.add(player);
                if (player.getSingles() == least1s) leastSingles.add(player);
                if (player.getDoubles() == most2s) mostDoubles.add(player);
                if (player.getDoubles() == least2s) leastDoubles.add(player);
                if (player.getTriples() == most3s) mostTriples.add(player);
                if (player.getTriples() == least4s) leastTriples.add(player);
                if (player.getHomeRuns() == most4s) mostHrs.add(player);
                if (player.getHomeRuns() == least4s) leastHrs.add(player);
            }

            switch (option1) {
                case "A" -> {
                    if (option2 == 1) for (player player : mostSingles) out.println("\t" +"\t" +  player.getName());
                    if (option2 == 2) for (player player : leastSingles) out.println("\t" + "\t" + player.getName());
                }
                case "B" -> {
                    if (option2 == 1) for (player player : mostDoubles) out.println("\t" + "\t" + player.getName());
                    if (option2 == 2) for (player player : leastDoubles) out.println("\t" + "\t" + player.getName());
                }
                case "C" -> {
                    if (option2 == 1) for (player player : mostTriples) out.println("\t" +"\t" +  player.getName());
                    if (option2 == 2) for (player player : leastTriples) out.println("\t" + "\t" + player.getName());
                }
                case "D" -> {
                    if (option2 == 1) for (player player : mostHrs) out.println("\t" +"\t" +  player.getName());
                    if (option2 == 2) for (player player : leastHrs) out.println("\t" +"\t" +  player.getName());
                }
            }
            // 	I: The player with the lowest batting average was traded for Jordan Guzman 105 4 5 6 27 15 4 4 4 18 19 3

            offense GuzmanOff = new offense (105, 4, 5, 6, 27, 15, 4, 4, 4);
            GuzmanOff.calculate();
            defense GuzmanDef = new defense(18, 19, 3);
            GuzmanDef.calculate();
            player Guzman = new player("Jordan Guzman", GuzmanOff, GuzmanDef);

            player lowestBatting = list.get(0);
            int loc = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getbattingavg() < lowestBatting.getbattingavg()) {
                    lowestBatting = list.get(i);
                    loc = i;
                }
            }

            out.printf("I. The player with the lowest batting average was %s, and was traded out for Jordan Guzman", list.get(loc).getName());

            list.remove(loc);
            list.add(loc, Guzman);
            // J: Reprint the stats for sections E, F and G with the updated team members

            out.println("\nJ: Reprinting the stats for sections E, F and G with the updated team members");
            // 	E: The teams slugging percentage.

            for (player player : list) {
                totalBases += (player.getSingles() + (player.getDoubles() * 2) + (player.getTriples() * 3) + player.getHomeRuns() * 4);
                totalAtBats += player.getAtBats();
            }
             teamSlug = totalBases / totalAtBats;
            out.print("\tE. The team's slugging percentage is " + teamSlug);


            // F. Total Hits
            totalHits = 0;
            for (player player : list) { totalHits += player.getHits();}
            out.print("\n\tF. The team has " + totalHits + " total hits.");

            // G. Closest fielding percentage to the average;
            averageFielding = 0;
            for (player player : list) averageFielding += player.getFielding();
            averageFielding /= list.size();

             smallestdiff = 10000;
             closest = list.get(0);
            for (player player : list) {
                double diff = Math.abs(player.getFielding() - averageFielding);
                if (diff < smallestdiff) {
                    smallestdiff = diff;
                    closest = player;
                }
            }

            out.printf("\n\tG. The average fielding percentage for the team is %f. Closest person is %s with %f", averageFielding, closest.getName(), closest.getFielding());


        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
/* OUTPUT
A. Nariyah Bolly has the most hits with 28.0 hits.
B. The players Nariyah Bolly and Kennedi Keller have the highest battle averages, with 0.346 and 0.342
C. The players Kennedi Keller and Kaelyn Pryne have the worst fielding averages, with 0.86 and 0.89
D. Players sorted in on base percentage order.
Addison Minich with 0.27
Ava Nelson with 0.27
Alyssa Zimmermann with 0.28
Emily Ayers with 0.29
Lilly Rogula with 0.32
Kaelyn Pryne with 0.32
Hannah Reed with 0.33
Gentry Pel with 0.35
Khushi Lot with 0.36
Karlie Patel with 0.37
Kennedi Keller with 0.39
Nariyah Bolly with 0.40
E. The team's slugging percentage is 0.41789577187807275
F. The team has 282 total hits.
G. The average fielding percentage for the team is 0.924352. Closest person is Karlie Patel with 0.916667
H. Do you want to see stats for (A) Singles (B) Doubles (C) Triples (D) Homeruns: A
	Do you want to see the player(s) with (1) the most or (2) the least: 1
		Karlie Patel
		Nariyah Bolly
		Gentry Pel
I. The player with the lowest batting average was Ava Nelson, and was traded out for Jordan Guzman
J: Reprinting the stats for sections E, F and G with the updated team members
	E. The team's slugging percentage is 0.42531522793404464
	F. The team has 292 total hits.
	G. The average fielding percentage for the team is 0.926318. Closest person is Jordan Guzman with 0.925000
Process finished with exit code 0
 */