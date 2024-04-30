package javacore2.Vio.Test.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta/teste.txt");
        if (Files.notExists(path)) Files.createFile(path); //(Se, arquivo não existir, crie) Criar o arquivo, lembre-se da assinatura do metodo.
        Files.setAttribute(path,"dos:hidden", true); //hidden é oculto, de valor verdadeiro.
        Files.setAttribute(path, "dos:readonly", true); //totalmente caixa baixa
        Files.setAttribute(path,"dos:hidden", false); //se quiser desfazer e deixar ele amostra de novo
        Files.setAttribute(path, "dos:readonly", false); //caixa alta

        //outra forma de ver esses atributos
        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);//querendo só fazer a leitura do dado
        System.out.println(dosFileAttributes.isHidden());
        System.out.println(dosFileAttributes.isReadOnly());
        System.out.println("--------------");

        //para alterar a forma acima, se tiver oculto, torna-lo visivel e por ai vai
        //dica: Usamos o view quando alteramos algo na forma que está acima, Files.read...
        DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        fileAttributeView.setHidden(false); //porque como mudamos lá no começo para false, queremos torna-lo novamente em oculto
        fileAttributeView.setReadOnly(true);
        System.out.println(fileAttributeView.readAttributes().isHidden());
        System.out.println(fileAttributeView.readAttributes().isReadOnly());
        //codigo de Posix não são carregados pelo windows, precisa ser feito em linux
        //não adianta lançar uma assinatura na raiz pois ainda sim dará uma excesão

    }
}
