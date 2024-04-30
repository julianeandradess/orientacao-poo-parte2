package javacore2.Vio.Test.Wnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeTest01 {
    public static void main(String[] args) throws IOException {
        String diretorioProjeto = "ProjetoDojo/Home/dev1";
        String arquivoTxt = "../../arquivo3.txt"; //pelo cmd o comando é type nomedoarquivo, você irá abrir e podera ver
        Path path1 = Paths.get(diretorioProjeto, arquivoTxt);
        System.out.println(path1);//até aqui não está na ordem "correta" de onde realmente está o arquivo, você vai precisar normalizar ele
        System.out.println(path1.normalize());
        Path path2 = Paths.get("C:\\Users\\sara maria\\projeto\\orientacao-poo-parte2\\ProjetoDojo\\arquivo3.txt");
        //System.out.println(Files.exists(path2));  SIMPLES
        /*   VERIFICANDO SE EXISTE
        boolean exists;
        if (Files.exists(path2)) {
            exists = true;
            System.out.println(exists);
        } else {
            exists = false;
            System.out.println(exists);
        }       SEM TRY, FUNCIONA POREM PODE TER EXCESSOES, SE PREPARE ANTES.
        */
        try {
            boolean exists1;
            if (Files.exists(path2)) {
                exists1 = true;
                System.out.println(exists1);
            } else {
                exists1 = false;
                System.out.println(exists1);
            }
        } catch (RuntimeException E) {
            throw new RuntimeException(E);
        }
    }
}
