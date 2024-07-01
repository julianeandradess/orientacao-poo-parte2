package academy.dev.Test.Wnio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try (FileWriter fw = new FileWriter(file, true); //encadeamente
             BufferedWriter bw = new BufferedWriter(fw)){
            bw.write("Faça algo interessante, a vida passa rápido demais.\nContinue na proxima linha.\n");
            bw.newLine(); //essa buffer entende o \n como um quebra de linha, alguns sistemas não entendem.
            bw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
