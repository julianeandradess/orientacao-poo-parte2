package academy.dev.Test.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeTest01 {
    public static void main(String[] args) {
        //Relativar um path = é dar um jeito de conectar duas paths, onde supostamente teria que estar tal arquivo
        //ex: OlaMundo.java supostamente está dentro de devfoda (por mais que não exista devfoda)
        //Path dir = Paths.get("/ProjetoDojo/Home/dev1");
        //Path clazz = Paths.get("/ProjetoDojo/Home/dev1/devfoda/OlaMundo.java");
        //Path pathToClazz = dir.relativize(clazz);
        //System.out.println(pathToClazz);

        //exemplos de casos que não são tão claro assim:
        Path absoluto1 = Paths.get("/ProjetoDojo/Home/dev1");
        Path absoluto2 = Paths.get("/usr/local");
        Path absoluto3 = Paths.get("/ProjetoDojo/Home/dev1/devfoda/OlaMundo.java");
        Path relativo1 = Paths.get("temp");
        Path relativo2 = Paths.get("temp/temp.2024229");

        System.out.println("1 "+ absoluto1.relativize(absoluto3)); //veremos o final complementando
        System.out.println("2 "+ absoluto3.relativize(absoluto1)); // caminho inverso, ou seja, terá que voltar 2 diretorios
        System.out.println("3 "+ absoluto1.relativize(absoluto2)); //significa que se você voltar a raiz, achará esse
        System.out.println("4 "+ relativo1.relativize(relativo2)); //como já está dentro, só pega o final.
        //System.out.println("5 "+ absoluto1.relativize(relativo1)); irá lançar uma excessão pq não tem ideia de como se complementam



    }
}
