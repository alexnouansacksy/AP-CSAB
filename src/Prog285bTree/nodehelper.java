// Alex Nouansacksy
// Prog285b Tree
// 11/30/2023
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
            if (n.getsales() <= temp.getsales()) {
                prev = temp;
                temp = temp.myleft;
            } else {
                prev = temp;
                temp = temp.myright;
            }
        }
        if (n.getsales() <= prev.getsales()) {
            prev.myleft = n;
        } else {
            prev.myright = n;
        }
    }

    public void delete(double s) {
        node prev = myroot;
        node temp = myroot;

        while (s != temp.getsales()) {
            if (s <= temp.getsales()) {
                prev = temp;
                temp = temp.myleft;
            } else {
                prev = temp;
                temp = temp.myright;
            }
        }

        // check to see if it is a leaf
        if (temp.myleft == null && temp.myright == null) {
            if (s <= prev.getsales()) {
                prev.myleft = null;
                return;
            } else {
                prev.myright = null;
                return;
            }
        }

        // check for 1 dead branch
        if(temp.myleft == null || temp.myright == null) {
            if (s<=prev.getsales()) {
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

        // now we know there are 2 lives spots under temp

        node prev1 = temp;
        node temp1 = temp.myright;

        while (temp1.myleft != null) {
            prev1 = temp1;
            temp1 = temp.myleft;
        }

        if (prev1 != temp) {
            temp.setdata(temp1.getid(), temp1.getcode(), temp1.getsales(), temp1.getcom());
            prev1.myleft = temp1.myright;
        } else {
            // we never moved
            temp.setdata(temp1.getid(), temp1.getcode(), temp1.getsales(), temp1.getcom());
            prev1.myright = temp1.myright;
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

/*
12
291 17 750.0 71.25
101 17 2250.0 213.75
203 8 3250.0 243.75
103 5 4000.0 300.0
264 17 4150.0 410.5
218 5 5000.0 375.0
235 5 5250.0 396.25
138 17 6375.0 677.5
125 5 6500.0 502.5
118 8 7350.0 574.75
117 3 7350.0 0.0
192 8 8125.0 640.625

291 17 750.0 71.25
101 17 2250.0 213.75
103 5 4000.0 300.0
264 17 4150.0 410.5
218 5 5000.0 375.0
235 5 5250.0 396.25
138 17 6375.0 677.5
125 5 6500.0 502.5
118 8 7350.0 574.75
117 3 7350.0 0.0
192 8 8125.0 640.625

291 17 750.0 71.25
101 17 2250.0 213.75
103 5 4000.0 300.0
264 17 4150.0 410.5
218 5 5000.0 375.0
235 5 5250.0 396.25
125 5 6500.0 502.5
118 8 7350.0 574.75
117 3 7350.0 0.0
192 8 8125.0 640.625

291 17 750.0 71.25
103 5 4000.0 300.0
264 17 4150.0 410.5
218 5 5000.0 375.0
235 5 5250.0 396.25
125 5 6500.0 502.5
118 8 7350.0 574.75
117 3 7350.0 0.0
192 8 8125.0 640.625

Process finished with exit code 0

 */

