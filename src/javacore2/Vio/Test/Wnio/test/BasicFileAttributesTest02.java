package javacore2.Vio.Test.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesTest02 {
    public static void main(String[] args) throws IOException {
        //class/interfaces que terminam com View:BasicFileAttributesView, DosFileAttributesView e PosixFileAttributesView
        // vão te dar métodos que você pode fazer alteração
        Path path = Paths.get("pasta2/subpasta/subsubpasta/new.txt");
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);//retorna uma interface tipo basic
        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();


        System.out.println("creationTime "+ creationTime);
        System.out.println("lastModifiedTime "+ lastModifiedTime);
        System.out.println("lasAcessTime"+ lastAccessTime);
        System.out.println("---------------------------");

        //usamos o get abaixo no lugar do readAttributes, porque estamos pegando algo do que já está criado acima.
        //basicView nos permite fazer alteração da alteração, digamos assim
        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        FileTime newCreationTime = FileTime.fromMillis(System.currentTimeMillis()); //pega o tempo em milisegundos
        fileAttributeView.setTimes(lastModifiedTime, newCreationTime, creationTime);//o unico que modificaremos é o que seria lastacess

        creationTime = fileAttributeView.readAttributes().creationTime();//estamos retornando o arquivo pois já lemos ele lá em cima e daria alteração ler ele novamente nas mesmas condições
        lastModifiedTime = fileAttributeView.readAttributes().lastModifiedTime();
        lastAccessTime = fileAttributeView.readAttributes().lastAccessTime();
        System.out.println("creationTime "+ creationTime);
        System.out.println("lastModifiedTime "+ lastModifiedTime);
        System.out.println("lasAcessTime"+ lastAccessTime); //pegou o valor atualizado do ultimo acesso
    }
}
