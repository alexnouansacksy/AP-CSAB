// Alex Nouansacksy
// Big Tree Assignment
// 11/13/2023
package BigTree;

public class node {
    private int mynum;
    public node myleft;
    public node myright;

    public node(int num) {
        mynum = num;
        myleft = null;
        myright = null;
    }

    public int getnum() {return mynum;}

    public void setnum(int num) {mynum = num;}

}
