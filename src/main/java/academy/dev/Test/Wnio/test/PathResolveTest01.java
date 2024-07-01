package academy.dev.Test.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathResolveTest01 {
    public static void main(String[] args) {
        //se quiser o caminho absoluto precisa usar a /, sem a barra no inicio é o caminho relativo
        //Path dir = Paths.get("/Home/dev1"); tá usando o caminho absoluto, raiz do projeto (/)Home
        //cuidado com o Resolve pois ele não é mt inteligente, só junta.

        Path dir = Paths.get("ProjetoDojo/Home");// relativo, você o encontra facil visualmente até
        Path arquivo = Paths.get("dev1/arquivo3.txt"); //relativo, porèm não está na raiz dos projetos como o Home, precisa ser resolvido.
        Path resolve = dir.resolve(arquivo); //resolve a questão de estar incompleto os caminhos
        System.out.println(resolve);

        //caso misture os caminhos, relativo e absoluto, precisa de uma solução melhor que o Resolve.
        Path absoluto = Paths.get("/ProjetoDojo/Home");
        Path relativo = Paths.get("dev1");
        Path file55 = Paths.get("file5.txt");

        System.out.println("1 "+ absoluto.resolve(relativo));
        System.out.println("2 "+ absoluto.resolve(file55));
        System.out.println("3 "+ relativo.resolve(absoluto));//não tem nada pra resolver, vai dar o caminho absoluto
        System.out.println("4 "+ relativo.resolve(file55));//só adicionou o file55 ao caminho relativo, não que ele exista


    }
}
