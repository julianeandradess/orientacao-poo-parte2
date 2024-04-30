package javacore2.Vio.Test.Wnio.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {
    public static void main(String[] args) {

        //vai aparecer um Integer que representa o primeiro caracter da frase(hexagonal)
        File file = new File("file.txt");
        try(FileReader fr = new FileReader(file)){
            System.out.println(fr.read());
        }catch (IOException e){
            e.printStackTrace();
        }

        // mostra qual a primeira letra

        try(FileReader fr = new FileReader(file)){
            char[] in = new char[1];
            fr.read(in);
            for (char c : in) {
                System.out.println(c);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        //inteirar sobre o arquivo/mostrar o conteudo sem abrir o arquivo:
        try(FileReader fr = new FileReader(file)){
            int i;
            while ((i=fr.read()) != -1){
                System.out.print((char)i);
            }
        }catch (IOException e){
            e.printStackTrace();
        }



    }
}
