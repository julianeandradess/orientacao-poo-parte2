package javacore2.Vio.Test.Wnio.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest01 {
    public static void main(String[] args) {
        //Lê a linha inteira e não somente a primeira letra
        File file = new File("file.txt");
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)){
            String linha;
            while ((linha = br.readLine()) != null){
                System.out.println(linha);
            }
            //br.readLine(); le a frase inteira, retorna null, por isso o while
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
