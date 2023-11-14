// Alex Nouansacksy
// Big Tree Assignment
// 11/13/2023
package BigTree;
import static java.lang.System.out;

public class nodehelper {
    private node myroot;

    public int getcount() {return getcount(myroot);}

    public int getcount (node temp) {
        if (temp == null) return 0;
        return 1+getcount(temp.myleft)+getcount(temp.myright);
    }

    public nodehelper() {
        myroot = null;
    }

    public void add(node n) {
        if (myroot == null) {
            myroot = n;
            return;
        }
        node temp = myroot;
        node prev = myroot;
        while (temp != null) {
            if (n.getnum() <= temp.getnum()) {
                prev = temp;
                temp = temp.myleft;
            } else {
                prev = temp;
                temp = temp.myright;
            }
        }
        if (n.getnum() <= prev.getnum()) {
            prev.myleft = n;
        } else {
            prev.myright = n;
        }
    }

    public void infix() {
        infix(myroot);
    }

    public void infix(node temp) {
        if (temp == null) return;
        infix(temp.myleft);
        out.print(temp.getnum() + " ");
        infix(temp.myright);
    }

    public void prefix() {
        prefix(myroot);
    }

    public void prefix(node temp) {
        if (temp == null) return;
        out.print(temp.getnum() + " ");
        prefix(temp.myleft);
        prefix(temp.myright);
    }

    public void postfix() {
        postfix(myroot);
    }

    public void postfix(node temp) {
        if (temp == null) return;
        postfix(temp.myleft);
        postfix(temp.myright);
        out.print(temp.getnum() + " ");
    }

    public int total() {
        return total(myroot);
    }

    public int total(node temp) {
        if (temp == null) return 0;
        return temp.getnum() + total(temp.myleft) + total(temp.myright);
    }

    public boolean find32() {
        return find32(myroot);
    }

    public boolean find32(node temp) {
        if (temp == null) return false;

        if (temp.getnum() == 32) return true;

        boolean left = find32(temp.myleft);
        if (left) return true;

        boolean right = find32(temp.myright);
        return right;
    }

    public int height() {
        return height(myroot);
    }

    public int height(node temp) {
        if (temp == null) return 0;
        int leftheight = height(temp.myleft);
        int rightheight = height(temp.myright);
        if (leftheight > rightheight) return leftheight + 1;
        else return rightheight + 1;
    }

    int maxwidth() {
        return getmaxwidth(myroot);
    }

    int getmaxwidth(node temp) {
        int maxWidth = 0;
        int width;
        int h = height(temp);

        for (int i = 0; i < h; i++) {
            width = getwidth(temp, i);
            if (width > maxWidth) maxWidth = width;
        }

        return maxWidth;
    }

    int getwidth(node temp, int num) {
        if (temp == null) return 0;

        if (num == 1) return 1;
        else if (num > 1) return getwidth(temp.myleft, num - 1) + getwidth(temp.myright, num - 1);
        return 0;
    }

    public void delete(double s) {
        node prev = myroot;
        node temp = myroot;

        while (s != temp.getnum()) {
            if (s <= temp.getnum()) {
                prev = temp;
                temp = temp.myleft;
            } else {
                prev = temp;
                temp = temp.myright;
            }
        }

        // check to see if it is a leaf
        if (temp.myleft == null && temp.myright == null) {
            if (s <= prev.getnum()) {
                prev.myleft = null;
                return;
            } else {
                prev.myright = null;
                return;
            }
        }

        // check for 1 dead branch
        if (temp.myleft == null || temp.myright == null) {
            if (s <= prev.getnum()) {
                // temp is left
                if (temp.myleft == null) {
                    prev.myleft = temp.myright;
                    return;
                } else {
                    prev.myleft = temp.myleft;
                    return;
                }
            } else {
                if (temp.myright == null) {
                    prev.myright = temp.myleft;
                    return;
                } else {
                    prev.myright = temp.myright;
                    return;
                }
            }
        }
    }

    static double minDiff;
    static double minDiffNode;

    public double findClosest(double num) {return findClosest(myroot, num);}

    public double findClosest(node temp, double num) {
        minDiff = 100000;
        minDiffNode = -1;
        findClosestHelper(temp, num);
        return minDiffNode;
    }

    public void findClosestHelper(node temp, double k) {
        if (temp == null) return;

        if (temp.getnum() == k) {
            minDiffNode = k;
            return;
        }

        if (minDiff > Math.abs(temp.getnum() - k)){
            minDiff = Math.abs(temp.getnum() - k);
            minDiffNode = temp.getnum();
        }

        if (k < temp.getnum()) findClosestHelper(temp.myleft, k);
        else findClosestHelper(temp.myright, k);
    }

}

/* Output
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
