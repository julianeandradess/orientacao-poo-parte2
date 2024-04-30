package javacore2.Vio.Test.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTest01 {
    public static void main(String[] args) {
        //funciona praticamente igual ao um dir, puxa todos os diretorios de um programa
        // a classe DirectoryStream pede uma classe que seja passada dentro do <>
        //nesse caso do <Path> significa que vamos transformar tudo que colocamos no get basicamente em Path
        //stream = Files.newDirectoryStream(path) = perguntando qual é o caminho inicial, dir = ao orientacao-poo-parte2
        Path dir = Paths.get(".");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
            for (Path path: stream) {
                System.out.println(path.getFileName());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
