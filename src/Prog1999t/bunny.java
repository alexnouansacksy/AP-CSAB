package Prog1999t;

import java.util.*;
public class bunny {
    private String name;
    private Set<String> soldTo;
    private Map<Integer, String> hats;

    private TreeSet<Integer> ints;

    public bunny(String a, Set<String> b, Map<Integer, String> c, TreeSet<Integer> d) {
        name = a;
        soldTo = b;
        hats = c;
        ints = d;
    }

    public String getName() {return name;}
    public Set<String> getSoldTo() {return soldTo;}
    public Map<Integer, String> getHats() {return hats;}
    public TreeSet<Integer> getInts() {return ints;}


}
