public class comlist {
    private node myroot;

    public comlist() {
        myroot = null;
    }

    public void addfirst(node stuff) {
        if (myroot == null) myroot = stuff;

        stuff.next = myroot;
        myroot = stuff;
    }

    public void addlast(node stuff) {
        if (myroot == null) {
            myroot = stuff;
            return;
        }

        node temp = myroot;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = stuff;

    }
    public void delete () {
        while ((myroot != null) && myroot.getCom() == 0) myroot = myroot.next;
        if (myroot == null) return;
    }

    public void something() {
        node prev = myroot;
        node temp = myroot.next;
        while (temp != null) {
            if (temp.getCom() == 0) {
                prev.next = temp.next;
                temp = temp.next;
            }
            else {
                prev = temp;
                temp = temp.next;
            }

        }
    }




}
