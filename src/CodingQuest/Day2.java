package CodingQuest;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class Day2 {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(new File("src/CodingQuest/Day2Data.txt"));
            int passengerLength = 0;
            int shipLength = 0;

            while (keyboard.hasNext()) {
                String ip = keyboard.next();

                int length = Integer.parseInt(ip.substring(4, 8), 16);
                String sourceAddress = ip.substring(24, 32);

                boolean passWifi = true;
                boolean ship = true;
                for (int i = 0; i < 8; i += 2) {
                    int num = Integer.parseInt(sourceAddress.substring(i, i + 2), 16);
                    if (i == 0) {
                        if (num != 10) passWifi = false;
                        if (num != 192) ship = false;
                    }

                    if (i == 2) {
                        if (num != 0) passWifi = false;
                        if (num != 168) ship = false;
                    }

                    if (i == 4) {
                        if (num > 254) passWifi = false;
                        if (num > 254) ship = false;
                    }

                    if (i == 6) {
                        if (num > 254) passWifi = false;
                        if (num > 254) ship = false;
                    }
                }

                if (passWifi) passengerLength += length;
                if (ship) shipLength += length;

                String destinationIP = ip.substring(32, 40);

                passWifi = true;
                ship = true;

                for (int i = 0; i < 8; i += 2) {
                    int num = Integer.parseInt(destinationIP.substring(i, i + 2), 16);

                    if (i == 0) {
                        if (num != 10) passWifi = false;
                        if (num != 192) ship = false;
                    }

                    if (i == 2) {
                        if (num != 0) passWifi = false;
                        if (num != 168) ship = false;
                    }

                    if (i == 4) {
                        if (num > 254) passWifi = false;
                        if (num > 254) ship = false;
                    }

                    if (i == 6) {
                        if (num > 254) passWifi = false;
                        if (num > 254) ship = false;
                    }
                }

                if (passWifi) {
                    passengerLength += length;
                }
                if (ship) {
                    shipLength += length;
                }
            }
            out.println(shipLength + "/" + passengerLength);

        } catch (IOException e) {
            out.print("File not found.");
        }
    }
}