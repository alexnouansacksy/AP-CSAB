package MSOE2023;
import static java.lang.System.out;
import java.util.*;

public class Problem6 {
    public static String[] traffic(String[] old) {
        String[] newArray = new String[old.length];
        for (int i = 0; i < old.length; i++) {newArray[i] = old[i];}

        for (int i = old.length - 1; i >= 1; i--) {
            if (old[i].equals(".") && old[i-1].equals("c")) {
                newArray[i-1] = ".";
                newArray[i] = "c";
            } else if (i == old.length-1 && old[i].equals("c")) {
                newArray[i] = ".";
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int length = keyboard.nextInt();
        String starting = keyboard.next();

        String[] road = new String[length];

        for (int i = 0; i < length; i++) road[i] = ".";

        for (int i = 0; i < starting.length(); i++) {
            if (starting.substring(i, i+1).equals("c")) {
                road[i] = "c";
            } else {
                road[i] = ".";
            }
        }

        boolean isC = true;
        int ticks = 0;
        while (isC) {
            ticks++;
            road = traffic(road);
            isC = false;
            for (String a: road) if (a.equals("c")) isC = true;
        }
        out.println("It takes " + ticks + " ticks to clear the traffic.");
    }
}
