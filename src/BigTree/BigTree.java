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





    }
}
