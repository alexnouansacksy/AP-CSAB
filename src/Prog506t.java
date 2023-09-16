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

            player mostHits = list.get(0);
            for (player player : list) if (player.getHits() > mostHits.getHits()) mostHits = player;

            out.print(mostHits.getName() + " has the most hits with " + mostHits.getHits() + " hits.");

            player highestBatting = list.get(0);
            for (player player : list) if (player.getbattingavg() > highestBatting.getbattingavg()) highestBatting = player;

            player secondHighBatting;
            if (highestBatting == list.get(0))  secondHighBatting = list.get(1);
            else  secondHighBatting = list.get(0);

            for (player player : list) if ((player.getbattingavg() > secondHighBatting.getbattingavg()) && player != highestBatting
            ) secondHighBatting = player;

            out.printf("\nThe players %s and %s have the highest battle averages, with %f and %f", highestBatting.getName(),
                    secondHighBatting.getName(), highestBatting.getbattingavg(), secondHighBatting.getbattingavg());

            player worstFielding = list.get(0);
            for (player player : list) {
                if (player.getFielding() < worstFielding.getFielding()) worstFielding = player;
            }

            player secondWorstFielding;
            if (worstFielding == list.get(0))  secondWorstFielding = list.get(1);
            else  secondWorstFielding = list.get(0);

            for (player player : list) if ((player.getFielding() < secondWorstFielding.getFielding())
                    && player != worstFielding) secondWorstFielding = player;

            out.printf("\nThe players %s and %s have the worst fielding averages, with %.2f and %.2f", worstFielding.getName(),
                    secondWorstFielding.getName(), worstFielding.getFielding(), secondWorstFielding.getFielding());

            ArrayList<player> averages = new ArrayList<>();

            player lowestBasePercentage = list.get(0);
            for (player player: list) if (player.getonbasepercentage() < lowestBasePercentage.getonbasepercentage())
                lowestBasePercentage = player;

            for (int i = 0; i < list.size()-1; i++) {
                Boolean added = false;
                for (int j = 1; j < averages.size() - 1; j++) {
                    if (list.get(j).getonbasepercentage() > list.get(j - 1).getonbasepercentage()) {
                        if (averages.size() == 1) averages.add(list.get(j));
                        else {
                            if (list.get(j).getonbasepercentage() < list.get(j+1).getonbasepercentage()){
                                averages.add(list.get(j));
                            }
                        }
                    }
                }
            }

            for (player player : averages) out.printf("\n%s %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f", player.getName(), player.getAtBats(),
                    player.getWalks(), player.getHitByPitches(), player.getSacrifices(), player.getHits(),
                    player.getSingles(), player.getDoubles(), player.getTriples(), player.getHomeRuns(),
                    player.getAssists(), player.getPutouts(), player.getErrors());

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}

