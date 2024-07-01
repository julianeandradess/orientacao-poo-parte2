package academy.dev.Test.Wnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        //BasicFileAttributes é uma interface, e a partir dela surgiram:
        //DosFileAttributes - que é uma implementação da basic, mais voltado para o windows, para leitura
        //PosixFileAttributes, voltado para linux

        //usando File
        LocalDateTime date = LocalDateTime.now().minusDays(10);
        File file = new File("pasta2/novo.txt");
        boolean isCreated = file.createNewFile(); //create geralmente pede assinatura de metodo ou try/catch
        boolean isModified = file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli());//quando foi modificado pela ultima vez
        //lembrando, isso modifica a data.

        //usando Path
        Path path = Paths.get("pasta2/subpasta/subsubpasta/novo_path.txt");
        Files.createFile(path);
        FileTime fileTime = FileTime.from(date.toInstant(ZoneOffset.UTC));
        Files.setLastModifiedTime(path, fileTime); //temos que passar 2 argumentos, 1 é o path
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isExecutable(path  ));
    }
}
