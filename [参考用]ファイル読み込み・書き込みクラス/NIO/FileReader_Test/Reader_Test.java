import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reader_Test {

	public static void main(String[] args) {
		//NIOを用いた処理
		
		// 相対パスをPath型に格納
		Path path = Paths.get("text.txt");
		
		//バッファリーダーにファイルを取り込む
		try(BufferedReader in = Files.newBufferedReader(path);){
			System.out.println(in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
