// Alex Nouansacksy
// Big Linked List
// 9/20/2023
package BigLinkedList;
import java.util.*;
import java.io.*;

import static java.lang.System.out;
public class BigLinkedList {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();
        comlist wow = new comlist();
        node randomNum;

        for (int i = 0; i < 200; i++) {
            randomNum = new node (rand.nextInt(200 + 1));
            wow.addlast(randomNum);
        }

        // Starting List
        out.print("Original List: ");
        wow.printList();
        // Add a node to the front of the list
        out.print("Add a node to the front: ");
        randomNum = new node (rand.nextInt(200 + 1));
        wow.addfront(randomNum);
        // Print the list
        wow.printList();
        // Add a node to the back of the list
        out.print("Add a node to the end: ");
        randomNum = new node (rand.nextInt(200 + 1));
        wow.addlast(randomNum);
        wow.printList();
        // Print the number of nodes
        out.println("Print the number of nodes: " + wow.getCount());
        // Insert a  node into a certain spot if possible
        out.print("Where do you want to insert a random number? ");
        int loc = keyboard.nextInt();
        randomNum = new node (rand.nextInt(200 + 1));
        wow.addNum(randomNum, loc);
        out.print("Added a " + randomNum.getval() + " at spot " + loc + ": ");
        wow.printList();
        // See if the number exists
        out.print("What number do you want to find:");
        int findNum = keyboard.nextInt();
        if(wow.isThere(findNum)) out.println("The number " + findNum + " is in the list!");
        else out.println("The number " + findNum + " is not in the list!");
        // Get first number
        int first = wow.getfirst();
        out.println("The first number is: " + first);
        // Get last number
        int last = wow.getLast();
        out.println("The last number is: " + last);
        // Get the number at a certain spot
        out.print("Enter index of number you want to find: ");
        int spot = keyboard.nextInt();
        int certainNum = wow.getSpot(spot);
        out.print("Get the number at a certain spot: " + certainNum);
        // Get rid of the first node
        wow.removeFirst();
        out.print("\nGet rid of the first node: ");
        wow.printList();
        // Get rid of the last node
        wow.removeLast();;
        out.print("Get rid of the last node: ");
        wow.printList();
        // Count the number of nodes under 10
        out.println("Count the number of nodes under 10: " + wow.countLess10());
        // Get rid of a node at a certain point
        out.print("Enter spot of node to remove: ");
        loc = keyboard.nextInt();
        wow.removeSpot(loc);
        out.print("Get rid of a node at a certain spot: ");
        wow.printList();
        // Clear the entire list
        wow.clear();
        out.print("Clear the entire list: ");
        wow.printList();
        // Make new list
        for (int i = 0; i < 200; i++) {
            randomNum = new node (rand.nextInt(200 + 1));
            wow.addlast(randomNum);
        }
        out.print("New list: ");
        wow.printList();
        // Check to see if list contains number
        out.print("Enter number to find: ");
        spot = keyboard.nextInt();
        wow.checkForNum(spot);
        // Create a reverse copy of the list
        out.print("\nCreate a reverse copy of the list: ");
        comlist test = wow.getReverse();
        test.printList();


    }
}

