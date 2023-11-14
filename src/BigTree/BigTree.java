// Alex Nouansacksy
// Big Tree Assignment
// 11/13/2023
package BigTree;
import java.util.*;
import static java.lang.System.out;

public class BigTree {
    public static void main(String[] args) {
        Random rand = new Random();
        nodehelper claire = new nodehelper();

        out.println("Make a list of 50 nodes with numbers from 1 to 100 in each node\n" +
                "Print the numbers as the tree was created");
        for (int i = 0; i < 50; i++) {
            int max = 100;
            int num = rand.nextInt(max - 1);
            node wow = new node(num);
            claire.add(wow);
            out.print(wow.getnum() + " ");
        }
        out.println();

        out.println("\nPrint the tree in NLR, LNR and LRN forms");
        out.print("NLR (prefix): ");
        claire.prefix();
        out.println();
        out.print("LNR (infix): ");
        claire.infix();
        out.println();
        out.print("LRN (postfix): ");
        claire.postfix();
        out.println();

        out.println("\nPrint the total of the numbers in the tree");
        out.println(claire.total());
        out.println();

        out.println("Print whether or not the number 32 is in the tree");
        if (claire.find32()) out.println("32 is in the list.");
        else out.println("32 is not in the list.");

        out.println("\nPrint the depth of the tree.");
        out.println(claire.height());

        out.println("\nPrint the width of the tree.");
        out.println(claire.maxwidth());

        out.println("\nAdd a new node 51 and 102 to the tree and print the tree in LNR format.");
        claire.add(new node(51));
        claire.add(new node(102));
        claire.infix();

        out.println("\n\nTake out the node that is closest to ½ the average of all of the nodes of the tree (probably a number around 25)");
        double average = claire.total();
        average /= (double) claire.getcount();
        average /= 2;
        double closest = claire.findClosest(average);
        out.println("Removing the number " + closest);
        claire.delete(closest);
        claire.infix();

    }
}
/*
Make a list of 50 nodes with numbers from 1 to 100 in each node
Print the numbers as the tree was created
89 41 92 69 53 61 56 75 16 85 72 66 66 88 46 41 35 93 9 58 37 18 21 46 46 78 38 49 6 91 41 23 5 86 18 98 25 87 83 96 72 92 38 92 82 87 75 66 29 12

Print the tree in NLR, LNR and LRN forms
NLR (prefix): 89 41 16 9 6 5 12 41 35 18 18 21 23 25 29 37 38 38 41 69 53 46 46 46 49 61 56 58 66 66 66 75 72 72 75 85 78 83 82 88 86 87 87 92 91 92 92 93 98 96
LNR (infix): 5 6 9 12 16 18 18 21 23 25 29 35 37 38 38 41 41 41 46 46 46 49 53 56 58 61 66 66 66 69 72 72 75 75 78 82 83 85 86 87 87 88 89 91 92 92 92 93 96 98
LRN (postfix): 5 6 12 9 18 29 25 23 21 18 38 41 38 37 35 41 16 46 46 49 46 58 56 66 66 66 61 53 72 75 72 82 83 78 87 87 86 88 85 75 69 41 92 92 91 96 98 93 92 89

Print the total of the numbers in the tree
2848

Print whether or not the number 32 is in the tree
32 is not in the list.

Print the depth of the tree.
10

Print the width of the tree.
11

Add a new node 51 and 102 to the tree and print the tree in LNR format.
5 6 9 12 16 18 18 21 23 25 29 35 37 38 38 41 41 41 46 46 46 49 51 53 56 58 61 66 66 66 69 72 72 75 75 78 82 83 85 86 87 87 88 89 91 92 92 92 93 96 98 102

Take out the node that is closest to ½ the average of all of the nodes of the tree (probably a number around 25)
Removing the number 29.0
5 6 9 12 16 18 18 21 23 25 35 37 38 38 41 41 41 46 46 46 49 51 53 56 58 61 66 66 66 69 72 72 75 75 78 82 83 85 86 87 87 88 89 91 92 92 92 93 96 98 102
Process finished with exit code 0
 */