// Alex Nouansacksy
// Prog506t
// 09/06/2023

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import static java.lang.System.out;

public class Prog506t {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog506t.txt"));
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

                offense offenseStats = new offense (atBats, walks, hitByPitches,
                        sacrifices, hits, singles, doubles, triples, homeruns);
                offenseStats.calculate();

                defense defenseStats = new defense (assists, putouts, errors);
                player wow = new player(name, offenseStats, defenseStats);
                defenseStats.calculate();

                list.add(wow);
            }
            // 	A: The player with the most hits.
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
            ArrayList<player> temp = new ArrayList<>();
            temp = list;
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
            int totalAtBats;
            int totalBases;
        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
/*
for (player player : list) out.printf("\n%s %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f", player.getName(), player.getAtBats(),
                    player.getWalks(), player.getHitByPitches(), player.getSacrifices(), player.getHits(),
                    player.getSingles(), player.getDoubles(), player.getTriples(), player.getHomeRuns(),
                    player.getAssists(), player.getPutouts(), player.getErrors());
 */