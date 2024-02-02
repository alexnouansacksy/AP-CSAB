package MSOE2018;// Alex Nouansacksy
// MSOE 2018 #5
// 10//11/2023

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class MSOE2018_5 {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("data/msoe2018_5.txt"));
            ArrayList<String> list = new ArrayList<>();
            while (keyboard.hasNext()) list.add(keyboard.nextLine());
            String result = "";
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).length() - 5; j++) {
                    int length = Integer.parseInt(list.get(i).substring(j, j+1));
                    char next = list.get(i).charAt(j+1);
                    if (next == ' ')
                        for (int k = 0; k < length; k++) result = result + " ";
                    else
                        for (int k = 0; k < length; k++) result = result + next;
                    j++;
                }
                out.println(result);
                result = "";
            }


        } catch (IOException e) {
            out.println("Can't find data file!");
        }
    }
}

/*
ZZZZ
  Z
 Z
ZZZZ

Process finished with exit code 0
 */