import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * Input is Binary number
 * 		 "3 44
		  4
		  2
	  	  6"
	  	  	  	  
 * Output is Decimal number
 *        "1
 * 		   0
 * 		   1"
 * 
 *  Survey of numbers
 * 
 * */


public class Radix_Conversion {
    public static void main(String[] args) {    	
    	
    	try(Scanner in = new Scanner(System.in)){
    		String[] input = in.nextLine().split(" ");
    		List<String> bitList = Arrays.asList(Integer.toBinaryString(
    				Integer.parseInt(input[1])).split(""));    		
    		Collections.reverse(bitList);
    		while(in.hasNext()) {
    			System.out.println(bitList.get(in.nextInt() - 1));
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}    	    
   	}    
}