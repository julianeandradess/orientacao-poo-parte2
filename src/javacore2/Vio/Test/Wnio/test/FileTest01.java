package javacore2.Vio.Test.Wnio.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest01 {
    public static void main(String[] args) {
        //Entrada e saída de dados
        //quando você cria um new file, precisa passar o argumento que está pedindo, você tem duas opções:
        //1= se quiser criar aonde esse está sendo executado, é só passar on nome. Ex: file.txt
        //2= mas se quiser salvar ele mais especifico precisa o caminho absoluto.
        // precisa copiar o Path do arquivo que quer colocar algo dentro. Ex:
        //"C:\\Users\\sara\\Documents\\javinha\\projetos\\orientacao-poo-parte2\\arquivo\\file.txt"
        //somente com o new file não terá criado nada, é necessario abaixo o file.createNewfile()
        //precisa ou usar o try catch ou method signature
        File file = new File("file.txt");

        /* Para CRIAR:
        try {
            boolean isCreated = file.createNewFile();
            System.out.println(isCreated);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Para DELETAR:
         File file = new File("file.txt");
        try {
            boolean isDeleted = file.delete();
        } catch (Exception exception) {
            throw new RuntimeException(e);
        }

        Para conferir se o arquivo EXISTE:
        try {
            boolean isCreated = file.createNewFile();
            System.out.println("Created" + isCreated);
            boolean exists = file.exists();//alt + enter
            if(exists){
                System.out.println(file.delete());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } */

        //USANDO PATH(caminho): Temos 2 tipos: o path que voce passa dentro do sout, ex 1: "path" + file.getPath();
        //ele vai retornar path file.txt
        //2: "path absoluto" + file.getPathAbsolutePath(); para saber o caminho absoluto
        try {
            boolean isCreated = file.createNewFile();
            System.out.println("Created" + isCreated);
            System.out.println("path " + file.getPath());
            System.out.println("path " + file.getAbsolutePath());
            System.out.println("is directory" + file.isDirectory()); //pra saber se é diretorio
            System.out.println("is file" + file.isFile()); //pra saber se é arquivo e não diretorio
            System.out.println("is hidden" + file.isHidden()); //pra saber se está oculto
            System.out.println("last modified" + new Date(file.lastModified())); //pra saber quando foi modificado
            boolean exists = file.exists();//alt + enter
            if(exists){
                System.out.println(file.delete());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
