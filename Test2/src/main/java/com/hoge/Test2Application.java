package com.hoge;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test2Application {

	public static void main(String[] args) throws IOException {
		//FilePathを取得
		Path path = Paths.get("../Test2/src/main/resources/GetFile");
		//パスからテキストデータを取得
		File txtFile = path.toFile();
		
		//System.out.println(txtFile.exists());
		
		//ファイルの存在有無を確認
		if(!txtFile.exists()) {
			//ここで例外を投げてもよい
			return;
		}
		
		List<String> txtLines = new ArrayList<>();
		
		//try-with-resource文でテキストを一行ずつ取得する
		try(Scanner scan = new Scanner(txtFile)){
			while(scan.hasNextLine()) {
				txtLines.add(scan.nextLine());
			}
		}
		
		//出力処理
		txtLines.forEach(System.out::println);
	}
}
