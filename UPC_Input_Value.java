//Programmer: Marissa Gonçalves
//Date: September 15, 2017
//Purpose: This program checks to see if the input is valid from the keyboard as a UPC.

//import java in order to create an input
import java.util.Scanner;

//compile the program with class
public class UPC_Input_Value

{
	//method to make the program run
	public static void main (String[]args)

  {
	//define a scanner
	Scanner keyboard = new Scanner (System.in);


    //enter a code of the UPC
    System.out.print ("Enter a UPC: ");


    //non-numeric are not permitted in this program
    if (!keyboard.hasNextLong())
           {
		     System.out.println();
		     System.out.println ("Error: input contains non-numeric numbers.");
		     System.out.println();
	         System.exit (1);
           }

	long upc = keyboard.nextLong();



    //negative values shouldn't be allowed
    if (upc < 0)
	       {
	   		 System.out.println();
	   	     System.out.println ("Error: input is negative.");
	   	     System.out.println();
	   	     System.exit (1);
           }



     //the code cannot have more than 12 digits
     else if (upc > 999999999999L)
	       {
	   		 System.out.println();
	   	     System.out.println ("Error: input has more than 12 digits.");
	   	     System.out.println();
	   	     System.exit (1);
           }



       //besides the errors that occur, this is how the program runs
       else
          {
			//print out a design
	        System.out.println ("================================");

	        //analyze and print the input
		    System.out.println ("Anatomy of the UPC: " + upc);

            //print out a design
		    System.out.println ("--------------------------------");

              //calculate the following values for each part of the bar code
		      int NSC = (int)(upc / Math.pow (10,11));
		      long manufacturer_number = (int)(upc % (Math.pow (10,11)) / (Math.pow (10,6)));
		      long product_code = (int)(upc % 1000000 / 10);
		      int family_code = (int)(upc % 1000000 / 1000);
		      int value_code = (int)(upc % 1000 / 10);
		      int scanned_check_digit = (int)(upc % 10);

              //each digit should be recognized from the code
		      int d0 = (int)(upc % 1000000000000L / 100000000000L);

		      int d1 = (int)(upc % 100000000000L / 10000000000L);

		      int d2 = (int)(upc % 10000000000L / 1000000000L );

		      int d3 = (int)(upc % 1000000000L / 100000000L);

		      int d4 = (int)(upc % 100000000L / 10000000L);

		      int d5 = (int)(upc % 10000000L / 1000000L);

		      int d6 = (int)(upc % 1000000L / 100000L);

		      int d7 = (int)(upc % 100000L / 10000L);

		      int d8 = (int)(upc % 10000 /1000);

		      int d9 = (int)(upc % 1000 / 100);

		      int d10 = (int)(upc % 100 / 10 );

		      int d11 = (int)(upc % 10);

              //determine if the scanned and computed check digit has the same value with these calculations
		      int x = (3 * (d0 + d2 + d4 + d6 + d8 + d10)) + (d1 + d3 + d5 + d7 + d9);
		      int y = (x % 10);

              int computed_check_digit;
		      if (y == 0)
		      {
		  	    computed_check_digit = (0);
		      }
		      else
		      {
		  		computed_check_digit = (10 - y);
		      }

              //print out the following information retreived for each part of the code
		      System.out.println ("NSC: " + NSC);
		      System.out.println ("Manufacturer Number: " + manufacturer_number);
		      System.out.println ("Product Code: " + product_code);
		      System.out.println ("Family Code: " + family_code);
		      System.out.println ("Value Code: " + value_code);
		      System.out.println ("Scanned Check Digit: " + scanned_check_digit);
		      System.out.println ("Computed Check Digit: " + computed_check_digit);

              //check if the computed check digit has the same value as the last digit of the UPC
		      int validity_status = computed_check_digit;
		      if (computed_check_digit == d11)
		      {
		  		System.out.println ("Validity Status: Valid");
		      }
		      else
		      {
		  		System.out.println ("Validity Status: Invalid");
		      }

              //print out a design
		      System.out.println ("================================");

              //proceed with a space
		      System.out.println();
	        }

    }
}
