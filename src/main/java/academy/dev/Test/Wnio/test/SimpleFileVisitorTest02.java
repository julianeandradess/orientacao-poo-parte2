package academy.dev.Test.Wnio.test;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListAllFiles extends SimpleFileVisitor<Path>{
    //esse Path entrará no lugar do T que fica entre <>, então tudo que tinha esse T, nesse caso, virará um Path
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE; //a documentação dessa VisitResult te dará opções, como esta Continue.
    }//entra na pasta

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("pré visit "+ dir.getFileName());
        return FileVisitResult.CONTINUE;

    }//visualiza antes, dps entra. Geralmente você pode escrever algo antes para sinalizar

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
    }//quando não consegue ler por algum motivo, lança uma exc

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("pós visit "+ dir.getFileName());
        return FileVisitResult.CONTINUE;
    }//sai, fecha tudo
}


public class SimpleFileVisitorTest02 {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get("pasta");
        Files.walkFileTree(root, new ListAllFiles()); //precisa de um Path
    }
}
