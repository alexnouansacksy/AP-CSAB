package MSOE2023;

import static java.lang.System.out;
import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String vehicle1 = keyboard.nextLine();
        String vehicle2 = keyboard.nextLine();
        String vehicle1type;
        String vehicle2type;

        if (vehicle1.contains("car")) {
            vehicle1type = "car";
            vehicle2type = "bus";
        } else {
            vehicle1type = "bus";
            vehicle2type = "car";
        }

        String winner = "";

        boolean vehicle1crash = false;
        boolean vehicle2crash = false;

        if(vehicle1.length() - vehicle1.indexOf(vehicle1type) - 3 > 0) vehicle1crash = true;
        if(vehicle2.length() - vehicle2.indexOf(vehicle2type) - 3 > 0) vehicle2crash = true;

        if (vehicle1crash && !vehicle2crash) winner = vehicle2type + " wins";
        if (vehicle2crash && !vehicle1crash) winner = vehicle1type + " wins";
        if (vehicle1crash && vehicle2crash) winner = "scratch";
        if (!vehicle1crash && !vehicle2crash && vehicle1.length() == vehicle2.length()) winner = "tie";
        if (!vehicle1crash && !vehicle2crash && vehicle1.length() > vehicle2.length()) winner = vehicle1type + " wins";
        if (!vehicle1crash && !vehicle2crash && vehicle1.length() < vehicle2.length()) winner = vehicle2type + " wins";

        out.println(winner);



    }
}
