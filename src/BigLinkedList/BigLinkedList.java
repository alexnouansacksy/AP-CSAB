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
        // Get the number at a certain position
        out.print("\nEnter index of number: ");
        loc = keyboard.nextInt();
        certainNum = wow.getNum(loc);
        out.println("Get the number at a certain position: " + certainNum);
        // Create a reverse copy of the list
        out.print("Create a reverse copy of the list: ");
        comlist test = wow.getReverse();
        test.printList();
        // Create an iterator over the numbers
        Iterator<Integer> iteration = wow.makeInterator();
        out.print("Create an iterator over the numbers: ");
        while (iteration.hasNext()) out.print(iteration.next() + " ");
        // Average the set of numbers
        double avg = wow.avg();
        out.println("\nAverage the set of numbers: " + avg);
        // Find the min of the numbers
        int min = wow.min();
        out.println("The min is: " + min);
        // Find the max of the numbers
        int max = wow.max();
        out.println("The max is: " + max);
        // Find the slot number of the largest num
        int firstOccurrence = wow.findSlotMaxFirst();
        out.println("The first occurrence of the largest num is: " + firstOccurrence);
        // Find the slot number of the largest num
        int lastOccurrence = wow.getCount() - 1 - wow.findSlotMaxLast();
        out.println("The last occurrence of the largest num is: " + lastOccurrence);
        // Sort all the numbers;
        out.println("Sort all the numbers: ");
        wow.sort();
        wow.printList();
        // Get rid of all the 58's, return how many
        int removed = wow.lose58();
        out.println("Removed " + removed + " 58's from the list.");
        wow.printList();
        // Find the number of even numbers
        int evens = wow.getEvenCount();
        out.println("There are " + evens + " even numbers in the list.");
        // Delete the odd numbers
        wow.killOdds();
        out.print("Deleted all the odd nums: ");
        wow.printList();
    }
}

/*
// Print in reverse order
    public void printReverseSetup() {
        node temp = myroot;
        printReverse(temp);
    }
    public void printReverse(node temp) {
        if (temp == null) return;
        printReverse(temp.next);
        out.print(temp.getval() + " ");
    }
 */

