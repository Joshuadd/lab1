
/**
 * CS 2003 - Lab 1. Code to compute the average of doubles from an input
 * file.  NOTE: add data members and methods at your convenience. Use
 * the most accurate data types. You can reuse bits of code from
 * the class Lab1a.
 *
 * @author
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Lab1b {
    
    // data members
	Double[] dblList;

    /** Constructor: calls method readFile that reads the doubles
     * contained in the file "<code>filename</code>" and computes the
     * average of the elements.
     @param filename name of the file containing doubles.
    */
    public Lab1b(String filename) {
    	readFile(filename);
    }

    /** Reads double from a file named <code>filename</code> and
     * computes the average of the elements contained in the file 
     * @param filename name of the file containing the doubles 
     */
    public void readFile(String filename) {
    	try {
    	    File inputFile = new File("src/Lab1b.dat");
    	    Scanner input = new Scanner(inputFile);
    	    int count=0;
    	    int length=0;
    	    double total=0; //to be used to calculate the avg
    	    while(input.hasNext()) { //find the length of the input
    	    	input.next();
    	    	length++;
    	    }
    	    dblList = new Double[length];
			double elt;
    	    // store all elements in a list
			Scanner input2 = new Scanner(inputFile);
    	    for (int i = 0; input2.hasNext(); i++) { //Makes sure that there is still a value left to get from the file
    	    	elt = input2.nextDouble();
    			dblList[i] = elt;
    			count++;
    			total += dblList[i];
    	    }
    	    input2.close();
    	    // print on the terminal each elements of dblVector
    	    System.out.printf("There are %d doubles in the input file:\n",
    			       count);
    	    for (int i = 0; i < dblList.length; i++)
    	    	System.out.print(" " + dblList[i]);
    	    System.out.println();
    	    
    	    // Find the avg
    	    double avg = total / length;

    	    //output results
    	    System.out.println("The average of the doubles is " + avg);
    	    input.close();
    	} 
    	catch (IOException e) {
    	    System.err.println("IOException in reading input file!!!");
    	}	
    } //end readFile()
    
    

    /** main : creates a Lab1b Object with the filename passed in
     * argument*/
    public static void main(String args[]) {
    	new Lab1b("Lab1b.dat");
    } //end main
    
} //end class Lab1b
