package Prog285bTree;
import static java.lang.System.out;
public class nodehelper {
    private node myroot;

    public nodehelper() {
        myroot = null;
    }

    public void add(node n ) {
        if (myroot == null) {
            myroot = n;
            return;
        }
        node temp = myroot;
        node prev = myroot;
        while (temp != null) {
            if (n.getid() <= temp.getid()) {
                prev = temp;
                temp = temp.myleft;
            } else {
                prev = temp;
                temp = temp.myright;
            }
        }

        if (n.getid() <= prev.getid()) {
            prev.myleft = n;
        } else {
            prev.myright = n;
        }
    }

    public void inprint() {inprint(myroot);}

    public void inprint(node temp) {
        if (temp == null) return;
        inprint(temp.myleft);
        out.println(temp);
        inprint(temp.myright);
    }

    public void calc() {calc(myroot);}

    public void calc(node temp) {
        if (temp == null) return;
        temp.setcom();
        calc(temp.myleft);
        calc(temp.myright);
    }



    public int getcount() {return getcount(myroot);}

    public int getcount (node temp) {
        if (temp == null) return 0;
        return 1+getcount(temp.myleft)+getcount(temp.myright);
    }



}

