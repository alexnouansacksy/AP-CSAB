// Alex Nouansacksy
// Big Tree Assignment
// 11/13/2023
package BigTree;
import static java.lang.System.out;

public class nodehelper {
    private node myroot;

    public nodehelper() {myroot = null;}
    public void add(node n ) {
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

    public void infix() {infix(myroot);}

    public void infix(node temp) {
        if (temp == null) return;
        infix(temp.myleft);
        out.print(temp.getnum() + " ");
        infix(temp.myright);
    }

    public void prefix() {prefix(myroot);}

    public void prefix(node temp) {
        if (temp == null) return;
        out.print(temp.getnum() + " ");
        prefix(temp.myleft);
        prefix(temp.myright);
    }

    public void postfix() {postfix(myroot);}

    public void postfix(node temp) {
        if (temp == null) return;
        postfix(temp.myleft);
        postfix(temp.myright);
        out.print(temp.getnum() + " ");
    }

    public int total() {return total(myroot);}

    public int total(node temp) {
        if (temp == null) return 0;
        return temp.getnum() + total(temp.myleft) + total(temp.myright);
    }

    public boolean find32() {return find32(myroot);}

    public boolean find32(node temp) {
        if (temp == null) return false;

        if (temp.getnum() == 32) return true;

        boolean left = find32(temp.myleft);
        if (left) return true;

        boolean right = find32(temp.myright);
        return right;
    }



}
