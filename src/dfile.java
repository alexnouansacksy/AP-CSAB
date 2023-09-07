import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class dfile {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/prog285b.dat"));

        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}

//Replit might need: Scanner keyboard = new Scanner(new File(pathname: "../data/prog285b.dat"));
