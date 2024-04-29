// Alex Nouansacksy
// Marquette 2024 #5
// 4/29/2024

package Marquette2024;
import java.util.*;
import static java.lang.System.out;

public class Prob5 {
    public static int calculateReservoirCapacity(List<String> commands) {
        double ans = 0;
        ArrayList<String> reservoir = new ArrayList<>();
        reservoir.add("#");
        int xd = 0;
        int yd = 0;
        int x = 0;
        int y = 0;
        for (String s: commands) {
            int num = Integer.parseInt(s.substring(2));
            if (s.substring(0, 1).equals("L")) {
                for (int i = 0; i < num; i++) {
                    if (x > 0) reservoir.set(y, reservoir.get(y).substring(0, x - 1) + "#" + reservoir.get(y).substring(x));
                    if (x <= 0) {
                        xd ++;
                        reservoir.set(y, "#" + reservoir.get(y));
                        x++;
                    }
                    x--;
                }
            }

            if (s.substring(0, 1).equals("R")) {
                for (int i = 0; i < num; i++) {
                    if (x < xd) reservoir.set(y, reservoir.get(y).substring(0, x + 1) + "#" + reservoir.get(y).substring(x + 2));
                    if (x >= xd) {
                        xd ++;
                        reservoir.set(y, reservoir.get(y) + "#");
                    }
                    x++;
                }
            }

            if (s.substring(0, 1).equals("U")) {
                for (int i = 0; i < num; i++) {
                    if (y > 0) reservoir.set(y - 1, reservoir.get(y-1).substring(0, x) + "#" + reservoir.get(y - 1).substring(x + 1));
                    if (y <= 0) {
                        yd ++;
                        String a = "";
                        for (int j = 0; j < xd + 1; j++) {
                            if (j == x) a = a + "#";
                            else  a = a + ".";
                        }
                        reservoir.add(0, a);

                    }
                    y--;
                }
            }

            if (s.substring(0, 1).equals("D")) {
                for (int i = 0; i < num; i++) {
                    if (y < yd) reservoir.set(y + 1, reservoir.get(y+1).substring(0, x) + "#" + reservoir.get(y + 1).substring(x + 1));
                    if (y >= yd) {
                        yd ++;
                        String a = "";
                        for (int j = 0; j < xd + 1; j++) {
                            if (j == x) a = a + "#";
                            else  a = a + ".";
                        }
                        reservoir.add(a);

                    }
                    y++;
                }
            }

            for (int n = 0; n < reservoir.size(); n++) {
                String curr = reservoir.get(n);
                while (curr.length() < xd) curr = curr + ".";
                reservoir.set(n, curr);
            }

        }

        for (int r = 0; r < reservoir.size(); r++) {
            out.println(reservoir.get(r));
        }
        out.println();

        boolean replace = false;
        for (int r = 0; r < reservoir.size(); r++) {
            String line = reservoir.get(r);
            for (int c = 0; c < line.length() - 1; c++) {
                if (!replace && line.substring(c, c + 1).equals("#") && line.substring(c + 1, c + 2).equals(".")) {
                    replace = true;
                } else if (replace) {
                    if (line.substring(c, c + 1).equals(".")) {
                        line = line.substring(0, c) + "#" + line.substring(c + 1);
                    } else if (line.substring(c, c + 1).equals("#")) {
                        replace = false;
                        while (c < line.length() && line.substring(c, c + 1).equals(".")) {
                            c++;
                        }
                    }
                }
            }
            reservoir.set(r, line);
            replace = false;
        }

        for (int r = 0; r < reservoir.size(); r++) {
            String line = reservoir.get(r);
            for (int c = 0; c < line.length(); c++) {
                if (line.substring(c, c + 1).equals("#")) {
                    ans++;
                }
            }
        }
        for (String s : reservoir) out.println(s);
        return (int) Math.round(ans);
    }

    // It is unnecessary to edit the "main" function of each problem's provided code skeleton.
// The main function is written for you in order to help you conform to input and output formatting requirements.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> commands = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) { // Check for an empty line to break the loop
                break;
            }
            commands.add(line);
        }
        System.out.println(calculateReservoirCapacity(commands));
        scanner.close();
    }
}

/*
R 6
D 5
L 2
D 2
R 2
D 2
L 5
U 2
L 1
U 2
R 2
U 3
L 2
U 2

#######
#.....#
###...#
..#...#
..#...#
###.###
#...#..
##..###
.#....#
.######

#######
#######
#######
..#####
..#####
#######
#####..
#######
.######
.######
62

Process finished with exit code 0
 */
