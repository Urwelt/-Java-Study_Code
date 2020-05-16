import java.util.Scanner;
import java.util.stream.Stream;

public class StringTointByStream {
    public static void main(String[] args) { 
    	
    	try(Scanner sc = new Scanner(System.in);){
    		String[] str = sc.nextLine().split(" ");
    		int[] num = Stream.of(str).mapToInt(Integer::parseInt).toArray();
    		int sum = (num[0] + num[1] -1)/num[1] * num[2];
    		System.out.println(sum);
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
}
