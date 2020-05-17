/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjava;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Kazuki
 */
public class TestJava {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {    
        //指定したファイルパスを変換し、Readerクラスで読み込む
        Path path1 = Paths.get("絶対パス", "ファイル名");
        Charset c = Charset.forName("文字コード");
        //List<String> read = Files.readAllLines(path1,c);
        //System.out.print(read);
    }
}
