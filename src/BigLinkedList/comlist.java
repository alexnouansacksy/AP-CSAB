// Alex Nouansacksy
// Big Linked List
// 9/20/2023

package BigLinkedList;

import static java.lang.System.out;
import java.util.*;
import java.util.Iterator;


public class comlist {
    private node myroot;

    public comlist() {myroot = null;}

    // Add a node to the front of the list
    public void addfront (node stuff) {
        if (myroot == null) {
            myroot = stuff;
            return;
        }

        stuff.next = myroot;
        myroot = stuff;
    }
    // Print the list
    public void printList() {
        if(myroot == null) {
            out.println("The list is empty");
            return;
        }
        node temp = myroot;
        while(temp != null) {
            out.print(temp + " ");
            temp = temp.next;
        }
        out.println();

    }
    // Add a node to the back of the list
    public void addlast(node stuff) {
        if (myroot == null) {
            myroot = stuff;
            return;
        }

        node temp = myroot;
        while (temp.next != null) temp = temp.next;
        temp.next = stuff;
    }
    // Print the number of nodes
    public int getCount() {
        int cnt = 0;
        if (myroot == null) return cnt;
        node temp = myroot;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
    //Insert a  node into a certain spot if possible
    public void addNum(node num, int spot) {
        if (myroot == null) {
            out.println("Linked List is empty, try adding a number at spot 0 instead.");
            return;
        }
        if (spot > getCount() + 1) {
            out.println("Linked List is only " + getCount() + " nodes long, try a smaller number.");
            return;
        }
        if (spot == 1) addfront(num);
        node temp = myroot;
        for (int i = 0; i < spot - 1; i ++) {
            temp = temp.next;
        }
        node newNode = num;
        newNode.next = temp.next;
        temp.next = newNode;

    }
    // Check to see if list is empty
    public boolean isEmpty() {
        return myroot == null;
    }
    // Check to see if a number exists
    public boolean isThere(int n) {
        if (myroot == null) return false;
        node temp = myroot;
        while (temp != null){
            if (temp.getval() == n) return true;
            temp = temp.next;
        }
        return false;
    }
    // Get first number
    public int getfirst() {
        if (myroot == null) {
            out.println("List is empty.");
            return 0;
        }
        else return myroot.getval();
    }
    // Get last public
    public int getLast() {
        if (myroot == null) {
            out.println("The list is empty.");
        }
        node temp = myroot;
        while (temp.next != null) temp = temp.next;
        return temp.getval();
    }
    // Get a number at a certain spot;
    public int getSpot (int spot) {
        node temp = myroot;
        if (myroot == null) {
            out.println("The list is empty.");
            return -1;
        } else if ( spot > getCount() - 1) {
            out.println("Invalid index for size " + getCount());
        } else {
            for (int i = 0; i < spot; i ++) {
                temp = temp.next;
            }
            return temp.getval();
        }
        return -1;
    }
    // Get rid of first node;
    public void removeFirst() {
        if (myroot == null) {
            out.println("The list is empty.");
            return;
        }
        node temp = myroot;
        while (temp.next != null) {
            temp.setVal(temp.next.getval());
            temp = temp.next;
        }
        temp = myroot;
        while (temp.next.next != null) {temp = temp.next;}
        temp .next= null;
    }
    // Get rid of last node
    public void removeLast() {
        if (myroot == null) {
            out.println("The list is empty.");
            return;
        }
        node temp = myroot;
        while (temp.next.next != null) {temp = temp.next;}
        temp .next= null;
    }
    // Count the number of nodes under 10
    public int countLess10() {
        if (myroot == null) {
            out.println("The list is empty.");
            return -1;
        }
        int less10 = 0;
        node temp = myroot;
        while (temp.next != null) {
            if (temp.getval() < 10) less10++;
            temp = temp.next;
        }
        return less10;
    }
    // Get rid of a node at a certain point
    public void removeSpot (int num){
        if (myroot == null) {
            out.println("The list is empty.");
            return;
        }
        node temp = myroot;
        for (int i = 0; i < getCount() - 1; i++) {
            if (i == num - 1) {temp.next = temp.next.next;}
            else temp = temp.next;
        }
    }
    // Clear the entire list
    public void clear() {
        myroot = null;
    }
    // check for num
    public boolean checkForNum(int n) {
        node temp = myroot;
        if (temp == null) {
            out.println("The list is empty.");
            return false;
        }
        while (temp.next != null) {
            if (temp.getval() == n) {
                out.print("The number " + n + " is in the list.");
                return true;
            }
            temp = temp.next;
        }
        out.print("The number " + n + " is not in the list.");
        return false;
    }
    // Get the number at a certain position
    public int getNum(int pos) {
        node temp = myroot;
        if (temp == null) return -1;
        if (pos > getCount()) return -1;
        for (int i = 0; i < pos; i++) temp = temp.next;
        return myroot.getval();
    }
    // Create a reverse copy of the list
    public comlist getReverse() {
        node temp = myroot;
        comlist reverse = new comlist();
        while (temp != null) {
            node add = new node(temp.getval());
            reverse.addfront(add);
            temp = temp.next;
        }
        return reverse;
    }
    // Create an iterator over the numbers
    public Iterator<Integer> makeInterator() {
        if (myroot == null) return null;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        node temp = myroot;
        while (temp.next != null) {
            nums.add(temp.getval());
            temp = temp.next;
        }
        nums.add(temp.getval());
        return nums.iterator();
    }
    // Average the set of numbers
    public double avg() {
        if (myroot == null) return 0;
        node temp = myroot;
        double avg = 0;
        while (temp.next != null) {
            avg += temp.getval();
            temp = temp.next;
        }
        avg /= getCount();
        return avg;
    }
    // Find the min of the numbers;
    public int min() {
        if (myroot == null) return 0;
        node temp = myroot;
        int min = myroot.getval();
        while (temp.next != null) {
            if (temp.getval() < min) min = temp.getval();
            temp = temp.next;
        }
        return min;
    }
    // Find the max of the numbers;
    public int max() {
        if (myroot == null) return 0;
        node temp = myroot;
        int max = temp.getval();
        while (temp.next != null) {
            if (temp.getval()  > max) max = temp.getval();
            temp = temp.next;
        }
        return max;
    }
    // Find the slot number of the biggest first occurrence
    public int findSlotMaxFirst() {
        if (myroot == null) return -1;
        node temp = myroot;
        int cnt = 0;
        while (temp.next != null) {
            if (temp.getval() == max()) return cnt;
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
    // Find the slot number of the biggest last occurrence
    public int findSlotMaxLast() {
        comlist reverse = getReverse();
        return reverse.findSlotMaxFirst();
    }

    // Sort all the numbers
    public void sort() {
        node temp = myroot;
        node start = temp;
        while (start.next != null) {
            node pointer = start;
            int max = -1;
            while (pointer != null) {
                if (pointer.getval()  > max) {
                    max = pointer.getval();
                }
                pointer = pointer.next;
            }
            if (temp.getval() == max) {
                node idk = myroot;
                while (idk.next != temp) idk = idk.next;
                idk.next = idk.next.next;
                start = start.next;
                addfront(temp);
            } else {
                while (temp.next != null && temp.next.getval() != max) temp = temp.next;
                if (start == temp.next) start = start.next;

                temp.next = temp.next.next;
                addfront(new node(max));
            }
            temp = start;

        }
        addfront(new node(getLast()));
        removeLast();
    }


    // Get rid of all the 58s
    public int lose58() {
        node temp = myroot;
        int cnt = 0;
        while (temp.next != null) {
            if (myroot.getval() == 58) removeFirst();

            if (temp.next.getval() == 58) {
                temp.next = temp.next.next;
                cnt ++;
            }
            temp = temp.next;
        }
        return cnt;
    }

    // Find the number of even numbers
    public int getEvenCount() {
        node temp = myroot;
        int cnt = 0;
        if (temp == null) return 0;
        while (temp.next != null) {
            if (temp.getval() % 2 == 0) cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    // Delete all the odd numbers
    public void killOdds() {
        node temp = myroot;
        while (temp.next.next != null) {
            if (temp.next.getval() % 2 != 0) {
                temp.next = temp.next.next;
            } else {
                if (temp.next.next != null) temp = temp.next;
            }
        }
        if (temp.next.getval() %2 == 1) removeLast();
        if (myroot.getval() % 2 == 1) removeFirst();
    }

}

/*
C:\Users\alexn\.jdks\openjdk-18.0.2.1\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2023.2.1\lib\idea_rt.jar=51458:C:\Program Files\JetBrains\IntelliJ IDEA 2023.2.1\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\alexn\IdeaProjects\AP-CSAB\out\production\AP-CSAB;C:\Users\alexn\.m2\repository\org\jetbrains\kotlin\kotlin-stdlib-jdk8\1.7.10\kotlin-stdlib-jdk8-1.7.10.jar;C:\Users\alexn\.m2\repository\org\jetbrains\kotlin\kotlin-stdlib\1.7.10\kotlin-stdlib-1.7.10.jar;C:\Users\alexn\.m2\repository\org\jetbrains\kotlin\kotlin-stdlib-common\1.7.10\kotlin-stdlib-common-1.7.10.jar;C:\Users\alexn\.m2\repository\org\jetbrains\annotations\13.0\annotations-13.0.jar;C:\Users\alexn\.m2\repository\org\jetbrains\kotlin\kotlin-stdlib-jdk7\1.7.10\kotlin-stdlib-jdk7-1.7.10.jar BigLinkedList.BigLinkedList
Original List: 73 64 106 19 141 142 97 149 43 86 174 31 175 35 130 134 51 39 57 7 1 18 122 100 100 70 102 158 193 115 119 95 144 79 129 134 155 97 198 175 129 116 103 61 72 1 27 12 44 28 0 93 130 83 148 23 156 55 152 192 66 200 14 1 32 137 158 72 10 70 17 1 170 14 151 98 192 196 182 92 39 47 32 26 185 150 126 180 194 36 148 14 180 40 200 47 46 135 28 13 184 78 21 106 53 11 172 118 67 28 121 53 173 193 167 175 17 174 131 108 156 155 65 196 75 7 182 23 32 117 41 62 188 88 141 64 65 153 125 170 22 89 91 193 184 7 194 149 106 128 174 47 52 39 88 159 105 199 29 74 77 20 9 23 84 123 80 83 194 108 171 168 14 67 165 23 106 107 51 20 89 99 30 83 6 187 59 194 0 190 151 71 90 108 66 0 5 33 41 39
Add a node to the front: 128 73 64 106 19 141 142 97 149 43 86 174 31 175 35 130 134 51 39 57 7 1 18 122 100 100 70 102 158 193 115 119 95 144 79 129 134 155 97 198 175 129 116 103 61 72 1 27 12 44 28 0 93 130 83 148 23 156 55 152 192 66 200 14 1 32 137 158 72 10 70 17 1 170 14 151 98 192 196 182 92 39 47 32 26 185 150 126 180 194 36 148 14 180 40 200 47 46 135 28 13 184 78 21 106 53 11 172 118 67 28 121 53 173 193 167 175 17 174 131 108 156 155 65 196 75 7 182 23 32 117 41 62 188 88 141 64 65 153 125 170 22 89 91 193 184 7 194 149 106 128 174 47 52 39 88 159 105 199 29 74 77 20 9 23 84 123 80 83 194 108 171 168 14 67 165 23 106 107 51 20 89 99 30 83 6 187 59 194 0 190 151 71 90 108 66 0 5 33 41 39
Add a node to the end: 128 73 64 106 19 141 142 97 149 43 86 174 31 175 35 130 134 51 39 57 7 1 18 122 100 100 70 102 158 193 115 119 95 144 79 129 134 155 97 198 175 129 116 103 61 72 1 27 12 44 28 0 93 130 83 148 23 156 55 152 192 66 200 14 1 32 137 158 72 10 70 17 1 170 14 151 98 192 196 182 92 39 47 32 26 185 150 126 180 194 36 148 14 180 40 200 47 46 135 28 13 184 78 21 106 53 11 172 118 67 28 121 53 173 193 167 175 17 174 131 108 156 155 65 196 75 7 182 23 32 117 41 62 188 88 141 64 65 153 125 170 22 89 91 193 184 7 194 149 106 128 174 47 52 39 88 159 105 199 29 74 77 20 9 23 84 123 80 83 194 108 171 168 14 67 165 23 106 107 51 20 89 99 30 83 6 187 59 194 0 190 151 71 90 108 66 0 5 33 41 39 8
Print the number of nodes: 202
Where do you want to insert a random number? 3
Added a 32 at spot 3: 128 73 64 32 106 19 141 142 97 149 43 86 174 31 175 35 130 134 51 39 57 7 1 18 122 100 100 70 102 158 193 115 119 95 144 79 129 134 155 97 198 175 129 116 103 61 72 1 27 12 44 28 0 93 130 83 148 23 156 55 152 192 66 200 14 1 32 137 158 72 10 70 17 1 170 14 151 98 192 196 182 92 39 47 32 26 185 150 126 180 194 36 148 14 180 40 200 47 46 135 28 13 184 78 21 106 53 11 172 118 67 28 121 53 173 193 167 175 17 174 131 108 156 155 65 196 75 7 182 23 32 117 41 62 188 88 141 64 65 153 125 170 22 89 91 193 184 7 194 149 106 128 174 47 52 39 88 159 105 199 29 74 77 20 9 23 84 123 80 83 194 108 171 168 14 67 165 23 106 107 51 20 89 99 30 83 6 187 59 194 0 190 151 71 90 108 66 0 5 33 41 39 8
What number do you want to find:3
The number 3 is not in the list!
The first number is: 128
The last number is: 8
Enter index of number you want to find: 3
Get the number at a certain spot: 32
Get rid of the first node: 73 64 32 106 19 141 142 97 149 43 86 174 31 175 35 130 134 51 39 57 7 1 18 122 100 100 70 102 158 193 115 119 95 144 79 129 134 155 97 198 175 129 116 103 61 72 1 27 12 44 28 0 93 130 83 148 23 156 55 152 192 66 200 14 1 32 137 158 72 10 70 17 1 170 14 151 98 192 196 182 92 39 47 32 26 185 150 126 180 194 36 148 14 180 40 200 47 46 135 28 13 184 78 21 106 53 11 172 118 67 28 121 53 173 193 167 175 17 174 131 108 156 155 65 196 75 7 182 23 32 117 41 62 188 88 141 64 65 153 125 170 22 89 91 193 184 7 194 149 106 128 174 47 52 39 88 159 105 199 29 74 77 20 9 23 84 123 80 83 194 108 171 168 14 67 165 23 106 107 51 20 89 99 30 83 6 187 59 194 0 190 151 71 90 108 66 0 5 33 41 39 8
Get rid of the last node: 73 64 32 106 19 141 142 97 149 43 86 174 31 175 35 130 134 51 39 57 7 1 18 122 100 100 70 102 158 193 115 119 95 144 79 129 134 155 97 198 175 129 116 103 61 72 1 27 12 44 28 0 93 130 83 148 23 156 55 152 192 66 200 14 1 32 137 158 72 10 70 17 1 170 14 151 98 192 196 182 92 39 47 32 26 185 150 126 180 194 36 148 14 180 40 200 47 46 135 28 13 184 78 21 106 53 11 172 118 67 28 121 53 173 193 167 175 17 174 131 108 156 155 65 196 75 7 182 23 32 117 41 62 188 88 141 64 65 153 125 170 22 89 91 193 184 7 194 149 106 128 174 47 52 39 88 159 105 199 29 74 77 20 9 23 84 123 80 83 194 108 171 168 14 67 165 23 106 107 51 20 89 99 30 83 6 187 59 194 0 190 151 71 90 108 66 0 5 33 41 39
Count the number of nodes under 10: 13
Enter spot of node to remove: 3
Get rid of a node at a certain spot: 73 64 32 19 141 142 97 149 43 86 174 31 175 35 130 134 51 39 57 7 1 18 122 100 100 70 102 158 193 115 119 95 144 79 129 134 155 97 198 175 129 116 103 61 72 1 27 12 44 28 0 93 130 83 148 23 156 55 152 192 66 200 14 1 32 137 158 72 10 70 17 1 170 14 151 98 192 196 182 92 39 47 32 26 185 150 126 180 194 36 148 14 180 40 200 47 46 135 28 13 184 78 21 106 53 11 172 118 67 28 121 53 173 193 167 175 17 174 131 108 156 155 65 196 75 7 182 23 32 117 41 62 188 88 141 64 65 153 125 170 22 89 91 193 184 7 194 149 106 128 174 47 52 39 88 159 105 199 29 74 77 20 9 23 84 123 80 83 194 108 171 168 14 67 165 23 106 107 51 20 89 99 30 83 6 187 59 194 0 190 151 71 90 108 66 0 5 33 41 39
Clear the entire list: The list is empty
New list: 93 106 163 33 16 56 55 36 184 80 64 65 175 55 185 61 27 190 148 53 103 98 28 177 145 10 63 192 171 67 36 9 19 167 73 99 165 34 190 13 174 76 120 56 28 129 107 122 90 156 66 19 200 121 75 151 125 155 18 52 172 23 100 112 103 152 120 186 43 180 193 147 73 92 180 199 157 180 87 183 2 130 112 17 108 3 166 160 1 145 180 32 37 132 0 40 47 122 145 108 95 89 61 98 132 43 132 171 178 186 74 196 104 145 158 177 164 181 19 12 174 106 131 124 166 109 143 92 125 172 105 112 105 188 80 191 68 99 167 128 59 159 170 142 99 7 118 153 108 155 62 17 73 180 123 55 102 116 89 159 80 116 32 11 154 13 126 133 194 41 158 55 147 182 131 118 149 84 66 148 48 154 19 23 136 42 149 97 53 170 98 100 89 179 146 62 157 1 94 69
Enter number to find: 3
The number 3 is in the list.
Enter index of number: 3
Get the number at a certain position: 93
Create a reverse copy of the list: 69 94 1 157 62 146 179 89 100 98 170 53 97 149 42 136 23 19 154 48 148 66 84 149 118 131 182 147 55 158 41 194 133 126 13 154 11 32 116 80 159 89 116 102 55 123 180 73 17 62 155 108 153 118 7 99 142 170 159 59 128 167 99 68 191 80 188 105 112 105 172 125 92 143 109 166 124 131 106 174 12 19 181 164 177 158 145 104 196 74 186 178 171 132 43 132 98 61 89 95 108 145 122 47 40 0 132 37 32 180 145 1 160 166 3 108 17 112 130 2 183 87 180 157 199 180 92 73 147 193 180 43 186 120 152 103 112 100 23 172 52 18 155 125 151 75 121 200 19 66 156 90 122 107 129 28 56 120 76 174 13 190 34 165 99 73 167 19 9 36 67 171 192 63 10 145 177 28 98 103 53 148 190 27 61 185 55 175 65 64 80 184 36 55 56 16 33 163 106 93
Create an iterator over the numbers: 93 106 163 33 16 56 55 36 184 80 64 65 175 55 185 61 27 190 148 53 103 98 28 177 145 10 63 192 171 67 36 9 19 167 73 99 165 34 190 13 174 76 120 56 28 129 107 122 90 156 66 19 200 121 75 151 125 155 18 52 172 23 100 112 103 152 120 186 43 180 193 147 73 92 180 199 157 180 87 183 2 130 112 17 108 3 166 160 1 145 180 32 37 132 0 40 47 122 145 108 95 89 61 98 132 43 132 171 178 186 74 196 104 145 158 177 164 181 19 12 174 106 131 124 166 109 143 92 125 172 105 112 105 188 80 191 68 99 167 128 59 159 170 142 99 7 118 153 108 155 62 17 73 180 123 55 102 116 89 159 80 116 32 11 154 13 126 133 194 41 158 55 147 182 131 118 149 84 66 148 48 154 19 23 136 42 149 97 53 170 98 100 89 179 146 62 157 1 94 69
Average the set of numbers: 106.07
The min is: 0
The max is: 200
The first occurrence of the largest num is: 52
The last occurrence of the largest num is: 52
Sort all the numbers:
0 1 1 2 3 7 9 10 11 12 13 13 16 17 17 18 19 19 19 19 23 23 27 28 28 32 32 33 34 36 36 37 40 41 42 43 43 47 48 52 53 53 55 55 55 55 56 56 59 61 61 62 62 63 64 65 66 66 67 68 69 73 73 73 74 75 76 80 80 80 84 87 89 89 89 90 92 92 93 94 95 97 98 98 98 99 99 99 100 100 102 103 103 104 105 105 106 106 107 108 108 108 109 112 112 112 116 116 118 118 120 120 121 122 122 123 124 125 125 126 128 129 130 131 131 132 132 132 133 136 142 143 145 145 145 145 146 147 147 148 148 149 149 151 152 153 154 154 155 155 156 157 157 158 158 159 159 160 163 164 165 166 166 167 167 170 170 171 171 172 172 174 174 175 177 177 178 179 180 180 180 180 180 181 182 183 184 185 186 186 188 190 190 191 192 193 194 196 199 200
Removed 0 58's from the list.
0 1 1 2 3 7 9 10 11 12 13 13 16 17 17 18 19 19 19 19 23 23 27 28 28 32 32 33 34 36 36 37 40 41 42 43 43 47 48 52 53 53 55 55 55 55 56 56 59 61 61 62 62 63 64 65 66 66 67 68 69 73 73 73 74 75 76 80 80 80 84 87 89 89 89 90 92 92 93 94 95 97 98 98 98 99 99 99 100 100 102 103 103 104 105 105 106 106 107 108 108 108 109 112 112 112 116 116 118 118 120 120 121 122 122 123 124 125 125 126 128 129 130 131 131 132 132 132 133 136 142 143 145 145 145 145 146 147 147 148 148 149 149 151 152 153 154 154 155 155 156 157 157 158 158 159 159 160 163 164 165 166 166 167 167 170 170 171 171 172 172 174 174 175 177 177 178 179 180 180 180 180 180 181 182 183 184 185 186 186 188 190 190 191 192 193 194 196 199 200
There are 102 even numbers in the list.
Deleted all the odd nums: 0 2 10 12 16 18 28 28 32 32 34 36 36 40 42 48 52 56 56 62 62 64 66 66 68 74 76 80 80 80 84 90 92 92 94 98 98 98 100 100 102 104 106 106 108 108 108 112 112 112 116 116 118 118 120 120 122 122 124 126 128 130 132 132 132 136 142 146 148 148 152 154 154 156 158 158 160 164 166 166 170 170 172 172 174 174 178 180 180 180 180 180 182 184 186 186 188 190 190 192 194 196 200


Process finished with exit code 0
 */

