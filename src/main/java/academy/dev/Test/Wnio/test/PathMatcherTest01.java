package academy.dev.Test.Wnio.test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest01 {
    public static void main(String[] args) {
        // a classe matcher foi criada para facilitar a busca de path
        //essa linguaguem é do glob(veja a documentação se necessario) :*. Muito especifica
        //uma versão mais simplificada das versões regulares.
        //matches = queremos saber se irá dar match com um arquivo que passamos no Paths, mas não significa que está no arquivo
        //sobre o uso de * e **, com um * ele não considera os diretorios, irá dar false
        Path path1 = Paths.get("pasta/subpasta1/file.bkp");
        Path path2 = Paths.get("pasta/subpasta1/file.txt");
        Path path3 = Paths.get("pasta/subpasta1/file.java");
        matches(path1, "glob:*.bkp");//false
        matches(path1, "glob:**.bkp"); //:**.bkp = quero que seja um arquivo que termine em .bkp
        matches(path1, "glob:**/*.{bkp,txt,java}");//para que obtenha o resultado das 3 opções.É SEM ESPAÇO
        matches(path2, "glob:**/*.{bkp,txt,java}");
        matches(path1, "glob:**/*.???");//Significa que quero que a extensão tenha 3 letras
        matches(path2, "glob:**/*.???");
        matches(path3, "glob:**/*.???"); //java tem 4, dará false
        matches(path3, "glob:**/file.????"); //procurando arquivo(file)especifico, 4 letras
    }

    private static void matches(Path path, String glob){
        //metodo
        //no caso da PathMatcher, pegamos atraves da classe FileSystems
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }
}

