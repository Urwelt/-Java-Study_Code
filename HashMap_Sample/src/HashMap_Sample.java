import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Input "PAIZA"
 * Output "P4124"
 * 
 * Leet String
 * 
 * */

public class HashMap_Sample {
    public static void main(String[] args) {

    	Map<String,String> m = new HashMap<>();
    	m.put("A", "4");
    	m.put("E", "3");
    	m.put("G", "6");
    	m.put("I", "1");
    	m.put("O", "0");
    	m.put("S", "5");
    	m.put("Z", "2");
    	
        try(Scanner in = new Scanner(System.in);){
        	String st = in.nextLine();
        	for(Map.Entry<String, String> entry : m.entrySet()) {
        		st = st.replaceAll(entry.getKey(), entry.getValue());
        	}        	
            System.out.println(st);
        }catch(Exception e){
        	e.printStackTrace();
        }                             
    }
}