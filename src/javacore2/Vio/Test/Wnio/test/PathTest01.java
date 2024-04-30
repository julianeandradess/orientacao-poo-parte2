package javacore2.Vio.Test.Wnio.test;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) {
        //pegar um path = caminho, quando usada assim como classe é uma interface.
        //podemos pegar atraves do nome do arquivo inteiro

        Path p1 = Paths.get("C:\\Users\\sara maria\\projeto\\orientacao-poo-parte2\\file.txt");
        Path p2 = Paths.get("C:\\Users\\sara maria\\projeto\\orientacao-poo-parte2\\","file.txt");//outra forma
        Path p3 = Paths.get("C:","\\Users\\sara maria\\projeto\\orientacao-poo-parte2\\","file.txt");//outra forma
        Path p4 = Paths.get("C:"," Users","sara maria","projeto","orientacao-poo-parte2","file.txt");//outra forma
        System.out.println(p1.getFileName());
        System.out.println(p2.getFileName());
        System.out.println(p3.getFileName());
        System.out.println(p4.getFileName());
    }
}
