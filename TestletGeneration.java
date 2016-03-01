/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testletgeneration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hea113
 */
public class TestletGeneration implements Testlet{
    static ArrayList<ArrayList<Double>> allSets = new ArrayList<ArrayList<Double>>(); // This is the set that contains all sets
    static ArrayList<ArrayList<Double>> globallist = new ArrayList<ArrayList<Double>>(); // This is our global list
    static ArrayList<Double> emptyset = new ArrayList<Double>(); // This will be the "final result" we push to global list. 
    static int numOfTestCases=0; // tracks the number of test cases
    static int sum=0; // keeps track of the sum for each case 
    
    /**
     * Reads a text file for X amount of variables and generates the total number
     * of possibilities based on robust worse case testing
     */
    @Override
    public void test() {
        int numOfRows=0;
        // The name of the file to open.
        String fileName = "Min_Max.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            System.out.println("Inputs received from the given text file are: ");
            
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] nums = line.split(" ");
                Double min = Double.parseDouble(nums[0]);
                Double max = Double.parseDouble(nums[1]);
                ArrayList row = new ArrayList();
                row.add(min-1); // min -
                row.add(min); // min
                row.add(++min); //min+
                row.add((max+(--min))/2.0); //nom
                row.add(--max); // max-
                row.add(++max); // max
                row.add(max+1); // max+
                allSets.add(row);
                numOfRows++;
            }   
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }      
        System.out.println("\nAll inputs given form the following set: ");
        System.out.println(allSets);
        System.out.printf("\nNumber of variables given are: %d\n", numOfRows);
        generate_possibilities(allSets, emptyset, -1, -1);
    	print_combos(globallist);
        System.out.printf("Total Number of Test Cases are: %d\n", numOfTestCases);
    }
    
    /**
     * This function is going to run until we reach the end of allsets.
     * At that point (See base case) we are going to push the running total
     * to the global list. The recursive branch will then "terminate"
     * @param allSets
     * @param running_total
     * @param arrayId
     * @param innerArrayId 
     */   
    public static void generate_possibilities(ArrayList<ArrayList<Double>> allSets, ArrayList<Double> running_total, int arrayId, int innerArrayId) {

    	if (arrayId != -1) {
    		// Add this possibility to the list. 
    		running_total.add(allSets.get(arrayId).get(innerArrayId)); // We want to push from first set 
    	}
    
    	// base case: we have looped through all arrayLists
    	if (arrayId + 1 == allSets.size()) {
            globallist.add(running_total);
    	} 
        // Recursive case: Iterate and push all possibilities in the current vector id. 
        else { 
            for (int i = 0; i < allSets.get(arrayId + 1).size(); i++) {
                generate_possibilities(allSets, new ArrayList(running_total), arrayId + 1, i);
            }
    	}
    }
    
    /**
     * Prints all the possibilities
     * @param all_combos 
     */
    public static void print_combos(ArrayList<ArrayList<Double>> all_combos) {
    	System.out.println("\nHere are all possible combinations for robust worse case testing!:");
    	for (int i = 0; i < all_combos.size(); i++) {
            sum=0;
    		System.out.print("<");
    		for (int j = 0; j < all_combos.get(i).size(); j++) {
    			System.out.print(all_combos.get(i).get(j));
                        sum+=all_combos.get(i).get(j);
    			if (j + 1 == all_combos.get(i).size()) {
                            System.out.printf(" , SUM: %d", sum);
                            System.out.print(">");
                            numOfTestCases++;
    			}
    			else {
                            System.out.print(", ");
    			}
    		}
		System.out.println("");
    	}
    }
    
}
