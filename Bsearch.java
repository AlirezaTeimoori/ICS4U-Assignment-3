//---------------------------------------
//-- Created by:     Alireza Teimoori  --
//-- Created on:     Feb 12 2019       --
//-- Created for:    Assignment 3      --
//-- Course Code:    ICS4U             --
//-- Teacher Name:   Chris Atkinson    --
//---------------------------------------
//-- This program generates  random    --
//-- sortedList of numbers and sorts them and--
//-- adds a number that user enters and--
//-- accepts a target number and finds --
//-- its location in the sortedList          --
//---------------------------------------


// Import needed libraries
import java.io.*;
import java.util.*;


public class Bsearch {

    // Create variables
    public ArrayList<Integer> unsortedList = new ArrayList<Integer>();
    public ArrayList<Integer> sortedList = new ArrayList<Integer>();
    public Random random = new Random();

    // newList() function creates a new list of 250 numbers generated randomly between 0 to 500
    public void newList() {
        
        // For 250 times:
        for ( int count = 0; count < 250; count++) {

            // Generate a random number between 0 and 500
            unsortedList.add(random.nextInt(501));
        }

        // Run the sort() function to sort the new list
        this.sort();
    }

    // sort() function sorts the array 
    public void sort() {

        // Empty the sorted list first
        sortedList.clear();

        // Add all the elements of the unsorted list
        sortedList.addAll(unsortedList);

        // For i in the length of the list:
        for (int i = 0 ; i < sortedList.size(); i ++) {

            // For j in the length of the list:
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                
                // Generate a temporary integer
                int tempNumber = 0;

                // Compare each element to the one next to it and if it was larger:
                if (sortedList.get(j) > sortedList.get(j+1) ) {

                    // Change their location
                    tempNumber = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j+1));
                    sortedList.set(j+1, tempNumber);
                }
            }
        }
    }

    // add() function adds the number user enters to the list and sorts again
    public void add(int number){
        
        // Add user number to the list
        this.unsortedList.add(number);

        // Sort again
        sort();
    }

    // BinarySearch() searchs for the target in the list
    public int BinarySearch(int target) {

        // Create needed variables to manage scope
        int left = 0;
        int right = 250;
        int middle = 124;

        // While the left hand extreme is smaller than the right hand extreme
        while (left < right) {

            // Assign middle to the average
            middle = ( left + right ) / 2;

            // If the element in the middle is smaller than the target
            if ( sortedList.get(middle) < target) {

                // Assign the left extreme to the right side of the middle
                left = middle + 1;

                // Update the middle
                middle = ( left + right ) / 2;
                //System.out.println("left is now: " + left);

            // If the element in the middle is larger than the target
            } else if (sortedList.get(middle) > target) {

                // Assign the right extreme to the left side of the middle
                right = middle - 1;

                // Update the middle
                middle = ( left + right ) / 2;
                //System.out.println("right is now: " + right);

            // If the target is not larger nor smaller
            } else {

                // Jump out of the loop
                break;
            }
        }
        
        // If the target is equal to the value of the middle:
        if (target == sortedList.get(middle)) {

            // Assign target to middle
            target = middle;
            //System.out.println("middle is now " + middle);

            // Give out the target
            return target;

        // If the target is not equal to the value of the middle:
        } else {

            // Let the user know that the number does not exist in the list
            System.out.println("          ========== Sorry! The target number does not exist in the list!  ==========\n");

            // Return error value
            return -1;
        }

    }

/*
    THIS FUNCTION WAS AN ATTEMPT TO PRINT THE ARRAY IN A MORE ORGANIZED WAY

    public void printList(ArrayList<Integer> theList) {
        System.out.print( "[ " );
        for ( int number = 0 ; number < theList.size() ; number ++ ) {
            
            if ( number == theList.size() - 1) {
                System.out.print( sortedList.get(number) );
            } else {
                System.out.print( sortedList.get(number) + ", " );
            }
            if ( number % 25 == 0 && number != 0) {
                System.out.println("");
            }
            
        }
        System.out.print( " ]" );
    }
*/
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Create an instance of Scanner
        Bsearch app = new Bsearch(); // Create an instance of Bsearch

        app.newList(); // Create a new list by running the newList() function

        // OUTPUT :: print the lists:
        System.out.println("          ==========        The UNSORTED list is being printed now:        ==========\n");
        System.out.println(app.unsortedList.toString() + " \n");
        System.out.println("          ==========         The SORTED list is being printed now:         ==========\n");
        System.out.println(app.sortedList.toString() + " \n");

        // Ask for and store data
        System.out.println("STEP1 ==> ========== Please enter the number you want to add to the list:  ==========\n");
        int numberToAdd = scanner.nextInt();

        // Add the number user enters to the array using the add() function 
        app.add(numberToAdd);

        // OUTPUT :: print the new list:
        System.out.println("          ==========   The number is added and the list is being printed:  ==========\n");
        System.out.println(app.sortedList.toString() + " \n");
        
        // Ask for and store data:
        System.out.println("STEP2 ==> ========== Please enter the target number you want to find here: ==========\n");
        int target = scanner.nextInt();

        // Run BinarySearch() for the target
        int answer = app.BinarySearch(target);

        // OUTPUT :: print the index
        if ( answer != -1 ) {System.out.printf("          ==========                     The Index is %d                    ==========\n", answer);}

        // Close scanner
        scanner.close();
    }
}