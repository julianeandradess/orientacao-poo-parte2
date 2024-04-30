package javacore2.Vio.Test.Wnio.test;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


//pesquisar tudo que tenha a palavra Test
class FindAllTestJavaOrClass extends SimpleFileVisitor<Path> {
    private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*Test*.{java,class}");
    // **/*{Test*}.{java,class} = quero tudo que seja diretorio -(**)(/*)- que comece com qualquer letra
    // e que tenha a palavra {Test*} esse ultimo * indica que pode ter qualquer coisa após a palavra Test
    // que termine com .{java ou class} SEM O ESPAÇO.
    // **/*Test*.{java,class} = assim tambem funciona! sem as chaves na palavra {*Test*}
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(matcher.matches(file)){
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}
public class PathMatcherTest02 {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get(".");
        Files.walkFileTree(root, new FindAllTestJavaOrClass());
    }
}
