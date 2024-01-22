// Alex Nouansacksy
// Embry Riddle 1
// 1/22/2024

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class EmbryRiddle1 {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/greetings.txt"));
            int cnt = keyboard.nextInt();
            ArrayList<String> names = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {names.add(keyboard.next());}
            FileWriter myWriter = new FileWriter("C:\\Users\\Alex Nouansacksy\\IdeaProjects\\AP-CSAB\\src\\outputs\\greetings.txt");
            for (String a : names) {myWriter.write("Greetings, " + a + ", welcome to the contest!\n");}
            myWriter.close();

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}
/* greetings.txt
Greetings, David, welcome to the contest!
Greetings, Raymond, welcome to the contest!
Greetings, Janice, welcome to the contest!
 */
