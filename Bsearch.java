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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Bsearch {

    public ArrayList<Integer> unsortedList = new ArrayList<Integer>();
    public ArrayList<Integer> sortedList = new ArrayList<Integer>();
    public Random random = new Random();

    public void newList() {
        
        for ( int count = 0; count < 500; count++) {
            unsortedList.add(random.nextInt(500));
        }

        this.sort();
    }

    public void sort() {

        sortedList.addAll(unsortedList);
        for (int i = 0 ; i < sortedList.size(); i ++) {

            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                
                int tempNumber = 0;

                System.out.println( sortedList.get(i) + " & " + sortedList.get(j+1));
                if (sortedList.get(j) > sortedList.get(j+1) ) {
                    System.out.println("swap");
                    tempNumber = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j+1));
                    sortedList.set(j+1, tempNumber);
                }
            }
        }
        
    }

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Bsearch app = new Bsearch();
        app.newList();
        System.out.println(app.unsortedList.toString() + " \n\n\n\n\n");
        System.out.println(app.sortedList.toString());
    }
}