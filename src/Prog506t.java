// Alex Nouansacksy
// Prog506t
// 09/06/2023

import java.io.File;
import java.io.IOException;
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

                list.add(wow);
            }
            player mostHits = list.get(0);
            for (int i = 0; i <list.size(); i++) {
                if (list.get(i). )
            }


        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
/*
out.printf("%s %d %d %d %d %d %d %d %d %d %d %d %d", wow.getName(), offenseStats.getAb(),
                        offenseStats.getBb(), offenseStats.getHp(), offenseStats.getSac(), offenseStats.getHits(),
                        offenseStats.getb1(), offenseStats.getb2(), offenseStats.getb3(), offenseStats.getHr(),
                        defenseStats.getAssists(), defenseStats.getPutouts(), defenseStats.getErrors());
                out.println();
 */
