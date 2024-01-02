// Alex Nouansacksy
// Prog408a Array
// 1/2/2024
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class Prog408aArray {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prg408a.dat"));
            int[][] list = new int[21][2];
            int cnt = 0;
            while (keyboard.hasNext()) {
                list[cnt] = new int[] {keyboard.nextInt(), keyboard.nextInt()};
                cnt++;
            }
            int maxscore = list[0][1];
            for (int i = 0; i < list.length; i++) {
                int id = list[i][0];
                int score = list[i][1];
                if (score > maxscore) maxscore = score;
            }
            out.println("Id\tScore");
            for (int i = maxscore; i >= 0; i--) {
                for (int j = 0; j < list.length; j++) {
                    int id = list[j][0];
                    int score = list[j][1];
                    if (score == i) out.println(id + "\t" + score);
                }
            }


        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}

/* output
Id	Score
365	265
306	262
115	257
311	256
123	253
325	246
116	246
323	245
321	245
113	243
218	243
208	242
302	242
104	239
112	239
110	238
223	230
213	229
207	228
203	224
222	223

Process finished with exit code 0
 */