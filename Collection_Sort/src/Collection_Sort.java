import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Collection_Sort {
    public static void main(String[] args) {

    	int[] numbers = {-1, 2, 0, -3, 8};

    	List<Integer> numbersList = new ArrayList<>();

    	for(int n : numbers) {
    	  numbersList.add(n);
    	}
    	
		//[-3, -1, 0, 2, 8]ラムダ式を用いない昇順
    	Collections.sort(numbersList);
    	
    	//[-3, -1, 0, 2, 8]昇順
    	Collections.sort(numbersList , (a,b) -> a-b);
    	
    	//[8, 2, 0, -1, -3]降順
    	Collections.sort(numbersList , (a,b) -> b-a);
    	
    	//[0, -1, 2, -3, 8] 絶対値順
    	Collections.sort(numbersList , (a,b) -> a*a - b*b);
    	System.out.println(numbersList.toString());
   	}
}