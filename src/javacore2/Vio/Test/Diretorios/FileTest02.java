package javacore2.Vio.Test.Diretorios;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {
        //criar diretorio:
        File fileDiretorio = new File("pasta2");
        boolean isDiretorioCriado = fileDiretorio.mkdir(); //fileDiretorio.mkdir;
        System.out.println(isDiretorioCriado);

        //criar um arquivo dentro do diretorio:
        //usando o caminho absoluto + \\o nome do arquivo
        //File fileArquivoDiretorio = new File("C:\\Users\\sara maria\\projeto\\orientacao-poo-parte2\\pasta\\arquivo.txt");
        //boolean isFileCreated = fileArquivoDiretorio.createNewFile(); //ou precisa do try ou da assinatura do metodo
        //System.out.println(isFileCreated);

        //outro jeito de criar arquivos dentro do diretorio:
        File fileArquivoDiretorio = new File(fileDiretorio, "arquivo.txt");
        boolean isFileCreated = fileArquivoDiretorio.createNewFile(); //ou precisa do try ou da assinatura do metodo
        System.out.println(isFileCreated);

        // Renomear arquivos:
        File fileRename = new File(fileDiretorio,"arquivo_renomeado.txt");
        boolean isRename = fileArquivoDiretorio.renameTo(fileRename);
        System.out.println(isRename);

        //Renomear Diretorio:
        File renameDiretorio = new File("pasta");
        boolean isDiretorioRenomeado = fileDiretorio.renameTo(renameDiretorio);
        System.out.println(isDiretorioRenomeado);
    }
}
