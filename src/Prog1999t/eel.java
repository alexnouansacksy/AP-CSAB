package Prog1999t;

import java.util.*;

public class eel {
    private String name;
    private int[][] eaten;
    LinkedList<String> namesEaten = new LinkedList<>();


    public eel(String a, int[][] b, LinkedList<String> c) {
        name = a;
        eaten = b;
        namesEaten = c;
    }

    public String getName() {return name;}
    public int[][] getEaten() {return eaten;}
    public LinkedList<String> getNamesEaten() {return namesEaten;}
}
