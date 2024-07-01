package academy.dev.Test.Wnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest02 {
    public static void main(String[] args) throws IOException {
        //a partir daqui trabalharemos mais com o path em vez de file.
        //para criar um diretorio dessa forma, voce precisa chamar o comando assim. FILES.
        //caso já exista uma pasta/diretorio com o mesmo nome, irá dar erro. Para contornar, basta usar o if.

        Path pastaPath = Paths.get("pasta2"); //é equivalente a new file("pasta2);
        if(Files.notExists(pastaPath)) {
            Path pastaDirectory = Files.createDirectory(pastaPath); //em casos assim, lembre-se da assinatura do metodo.
        } //funciona quando se tem um diretorio, mas algumas vezes temos muito e queremos criar mais, abaixo:
        
        //pastaDirectory = Files.createDirectory(pastaPath); NÃO FUNCIONA NO EXEMPLO ABAIXO, SOMENTE O DIRECTORIES
        Path subpastaPath = Paths.get("pasta2/subpasta/subsubpasta");
        Path subPastaDirectories = Files.createDirectories(subpastaPath);

        //criar um arquivo dentro dessas pastas que são criadas pelo path:
        Path filePath = Paths.get(subpastaPath.toString(),"file1.txt");
        //Path filePathCreated = Files.createFile(filePath); //caso dê a excessao, use o if
        if(Files.notExists(filePath)) {
            Path filePathCreated = Files.createFile(filePath);
        }

        //nomear um arquivo dentro da subpasta, copiando o conteudo de um arquivo dele para outro na mesma pasta
        //porem se tentar escrever algo nele que nao tenha no outro, irá lançar excessao mas tem solução dentro do copy
        Path source = filePath; //origem de onde está o arquivo
        Path target = Paths.get(filePath.getParent().toString(), "file_renomed.txt");
        //destino para onde quero que seja copiado
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

    }
}
