package academy.dev.Test.Wnio.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest01 {
    public static void main(String[] args) {
        //Files que mais são usadas:
        // File = trabalha com o arquivo em si
        // FileWriter = escrever o arquivo. É sobrecarregada, pode passar o nome ou o arquivo diretamente
        // FileReader = só para leitura
        // BufferedWriter = escrita de uma forma personalizada, trabalhando com dados e memoria
        // BufferedReader = tem uma performace melhor que a FileReader
        //Serve para ver se voce tem permissão de leitura, se é oculto

        //quando se trabalha com leitura e escrita de arquivo está pegando recurso do sistema operacional
        //e quase sempre precisa fechar, usando o close(), porem se colocar em () no try, ele fechará pra voce.

        File file = new File("file.txt");
        try (FileWriter fw = new FileWriter(file)){
            // FileWriter fw = new FileWriter(file);  FileWriter fw = new FileWriter(file); alt+enter
            fw.write("Faça algo interessante, a vida passa rápido demais.");// para escrever em um arquivo
            fw.flush(); //confere se cospiu tudo que tinha dentro "tunel", pra que o arquivo seja fechado em segurança
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
