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

import java.io.*;
import java.util.*;


public class Bsearch {

    public ArrayList<Integer> unsortedList = new ArrayList<Integer>();
    public ArrayList<Integer> sortedList = new ArrayList<Integer>();
    public Random random = new Random();

    public void newList() {
        
        for ( int count = 0; count < 250; count++) {
            unsortedList.add(random.nextInt(501));
        }

        this.sort();
    }

    public void sort() {

        sortedList.clear();
        sortedList.addAll(unsortedList);
        for (int i = 0 ; i < sortedList.size(); i ++) {

            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                
                int tempNumber = 0;

                //System.out.println( sortedList.get(i) + " & " + sortedList.get(j+1));
                if (sortedList.get(j) > sortedList.get(j+1) ) {

                    //System.out.println("swap");
                    tempNumber = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j+1));
                    sortedList.set(j+1, tempNumber);
                }
            }
        }
    }

    public void add(int number){
        
        this.unsortedList.add(number);
        sort();
    }

    public int BinarySearch(int target) {

        int left = 0;
        int right = 250;
        int middle = 124;

        while (left < right) {

            middle = ( left + right ) / 2;

            if ( sortedList.get(middle) < target) {

                left = middle + 1;
                middle = ( left + right ) / 2;
                System.out.println("left is now: " + left);
            } else if (sortedList.get(middle) > target) {

                right = middle - 1;
                middle = ( left + right ) / 2;
                System.out.println("right is now: " + right);
            } else {

                break;
            }
        }
        
        if (target == sortedList.get(middle)) {

            target = middle;
            System.out.println("middle is now " + middle);

            return target;
        } else {

            System.out.println("           ========== Sorry! The target number does not exist in the list! ==========\n");

            return -1;
        }

    }

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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Bsearch app = new Bsearch();
        app.newList();
        System.out.println(app.unsortedList.toString() + " \n\n\n\n\n");
        System.out.println(app.sortedList.toString());

        System.out.println("STEP1 ==> ========== Please enter the number you want to add to the list: ==========\n");
        int input1 = scanner.nextInt();
        app.add(input1);
        System.out.println(app.sortedList.toString());
        
        System.out.println("STEP2 ==> ========== Please enter the target number you want to find here: =========\n");
        int input2 = scanner.nextInt();
        int answer = app.BinarySearch(input2);
        if ( answer != -1 ) {System.out.println("The index is: " + answer);}

        app.printList(app.sortedList);
    }
}