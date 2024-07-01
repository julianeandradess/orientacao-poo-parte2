package academy.dev.Test.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


//transformar o arquivo em zip.

public class ZipOutPutStreamTest01 {
    public static void main(String[] args) {
        Path arquivoZip = Paths.get("pasta/arquivo.zip"); //arquivo que será criado
        Path arquivosParaZipar = Paths.get("pasta/subpasta1/subsubpasta1");
        zip(arquivoZip, arquivosParaZipar);//para visualizar os arquivos que serão zipados
    }

    private static void zip(Path arquivoZip, Path arquivosParaZipar){
        //pega um path e transforma em OutputStream
        //precisaremos navegar dentro de todas as pastas listadas acima, podemos usar a DirectoryStream ou SimpleVisitor
        //newDirectoryStream é onde os arquivos que vamos zipar = arquivosParaZipar
        //agora vamos pegar os arquivos da subpasta e jogar dentro do zip(for)
        //zipEntry- primeiro passo = basicamente informa qual arquivo vai enviar, prepara uma entrada
        //se não colocar o copy, o arquivo irá ser zipado vazio, cuidado.
        try(ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(arquivosParaZipar)) {
            for (Path file: directoryStream){
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                zipStream.putNextEntry(zipEntry); //significa = poe essa proxima entrada
                Files.copy(file, zipStream); //copiando o arquivo original(file) para o zipStream
                zipStream.closeEntry(); //fecha a entrada
            }
            System.out.println("Arquivo criado com sucesso.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
