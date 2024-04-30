package javacore2.Vio.Test.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListJavaFiles extends SimpleFileVisitor<Path>{
    //esse Path entrará no lugar do T que fica entre <>, então tudo que tinha esse T, nesse caso, virará um Path
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if(file.getFileName().toString().endsWith(".java")) {//vai rodar tudo e mostrar somente os arquivos .java
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE; //a documentação dessa VisitResult te dará opções, como esta Continue.
    }
}


public class SimpleFileVisitorTest01 {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get(".");
        Files.walkFileTree(root, new ListJavaFiles()); //precisa de um Path
    }
}
