import java.util.Scanner;

public class ResourceTry_Sample {
    public static void main(String[] args) {
    	
        try(Scanner in = new Scanner(System.in);){
        	
            int num = in.nextInt();
        	for(int i=0; i < num; i++){
        		
            	System.out.print("*");
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
}