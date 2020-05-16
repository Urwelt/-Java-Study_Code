import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordMaker {
	
	private static final String[] VALUE_ES = {"s","sh","ch", "o", "x"};
	private static final String[]  VALUE_VES = {"f","fe"};
	private static final String[]  VALUE_IES = {"a", "i", "u", "e", "o"};

    public static void main(String[] args) {
    	   	
    	try(Scanner sc = new Scanner(System.in);){    		
    		List<String> spell = new ArrayList<>();
    		int num = sc.nextInt();
    		sc.nextLine();
    		for(int i = 0; i < num; i++) {
    			if(!sc.hasNext()) {
    				break;
    			}
    			spell.add(sc.nextLine());
    		}
    		
    		List<String> s = spellCheck(spell);
    		for(String str : s) {
    			System.out.println(str);
    		}
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}    	              
    }
    
    public static  List<String> spellCheck(List<String> list){                    	
    	
    	List<String> result = new ArrayList<>();    	
    	        
        loop:for(String value : list){
        	// VALUE_ES チェック
        	for(String key : VALUE_ES) {
        		if(value.endsWith(key)){        			
        			result.add((new StringBuffer(value).append("es")).toString());
        			continue loop;
        		}        		
        	}
        	// VALUE_VES チェック
        	for(String key : VALUE_VES) {
        		if(value.endsWith(key)){        			
        			if(key.equals("f")){
        				String tmp = value.substring(0,value.length()-1);
        				result.add((new StringBuffer(tmp).append("ves")).toString());
        				continue loop;
        			}
        			
        			if(key.equals("fe")){
                        String tmp = value.substring(0,value.length()-2);
                        result.add((new StringBuffer(tmp).append("ves")).toString());
                        continue loop;
                    }          			
        		}
        	}
        	// VALUE_IES チェック
            if(value.endsWith("y")){
            	String tmp = value.substring(value.length()-2,value.length()-1);
            	for(String key : VALUE_IES) {
            		if(tmp.equals(key)){            			
            			result.add((new StringBuffer(value).append("s")).toString());
                    	continue loop;
            		}else {
            			tmp = value.substring(0,value.length()-1);
                		result.add((new StringBuffer(tmp).append("ies")).toString());
                		continue loop;
            		}
            	}            	
            }                            
            result.add((new StringBuffer(value).append("s")).toString());
        }    	
           return result;
    }
}