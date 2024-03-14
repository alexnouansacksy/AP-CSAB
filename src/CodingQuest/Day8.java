package CodingQuest;

import java.util.*;
import java.io.*;

public class Day8 {
    public static void main(String[] args) {
        System.out.println(checkDistance(856));
    }

    public static int checkDistance(int dis) {
        if (dis < 0) {
            return 0;
        } else if (dis == 0) {
            return 1;
        }
        return checkDistance(dis - 1) + checkDistance(dis - 2) + checkDistance(dis - 12) + checkDistance(dis - 40);
    }
}
