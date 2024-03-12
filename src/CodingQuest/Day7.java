package CodingQuest;

import java.util.*;
import java.io.*;

public class Day7 {
    public static ArrayList<ArrayList<String>> folders = new ArrayList<ArrayList<String>>();

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("src/CodingQuest/info.txt"));
            double sum = 0;

            String line = input.nextLine();
            while (input.hasNext()) {
                line = input.nextLine();
                ArrayList<String> f = new ArrayList<String>();
                while (!line.substring(0, 6).equals("Folder") && input.hasNext()) {
                    f.add(line);
                    line = input.nextLine();
                }
                if (!input.hasNext()) {
                    f.add(line);
                }
                folders.add(f);
            }

            for (int a = 0; a < folders.size(); a++) {
                ArrayList<String> f = folders.get(a);
                for (int b = 0; b < f.size(); b++) {
                    if (f.get(b).indexOf("temporary") >= 0 || f.get(b).indexOf("delete") >= 0) {
                        if (f.get(b).indexOf("FOLDER") >= 0) {
                            sum += deleteFolder(Integer.parseInt(f.get(b).substring(f.get(b).indexOf("FOLDER") + 7, f.get(b).length() - 1)));

                        } else {
                            sum += Integer.parseInt(f.get(b).split(" ")[3]);
                            System.out.println(f.get(b).split(" ")[3]);
                        }
                        f.set(b, "empty");
                    }
                }
            }
            System.out.println(sum);
        } catch (IOException e) {
            System.out.print("NO");
        }
    }

    public static double deleteFolder(int i) {
        double sum = 0;
        ArrayList<String> f = folders.get(i);
        for (int b = 0; b < f.size(); b++) {
            if (f.get(b).indexOf("FOLDER") >= 0) {
                sum += deleteFolder(Integer.parseInt(f.get(b).substring(f.get(b).indexOf("FOLDER") + 7, f.get(b).length() - 1)));
            } else {

                sum += Integer.parseInt(f.get(b).split(" ")[3]);
                System.out.println(f.get(b).split(" ")[3]);
            }
            f.set(b, "empty");
        }
        return sum;
    }
}
