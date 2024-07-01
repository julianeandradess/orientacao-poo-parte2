package academy.dev.Test.Colecoes.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        //list nada mais é que uma interface que extends de Collections, ctrl B verá todos os atributos e objetivos
        // assim era feito na versão 1.4 do java:
        /*List nomes = new ArrayList();
        nomes.add("willian");
        nomes.add("dev");
        nomes.add(123);

        //navegar pela lista
        for (Object nome: nomes){ Esse Object irá listar todos os tipos de objeto, sem especificação, o que é problematico na hora de pesquisar um obj
            System.out.println(nome);
        }*/

        // <> = dentro dele colocamos o tipo, ex: String, forçando o java a entender, 1.5 java
        // Outra coisa: no momento da criação de uma coleção <>, o valor tem ali no meio tem que ser
        // obrigatoriamente um objeto, não se pode usar tipo primitivo. Ex: int, string, double

        List<String> nomes1 = new ArrayList<>(16); //capacidade inicial 16
        List<String> nomes2 = new ArrayList<>(16);
        nomes1.add("juliane");
        nomes1.add("dev dojo");
        nomes2.add("lili");
        nomes2.add("luli");

        nomes1.addAll(nomes2);//se quisermos add a lista 1 na lista 2. Podemos usar um FOR ou o metodo addAll
        // nomes1.remove(1); // remove o indice.
        //System.out.println(nomes1.remove("dev dojo")); // remove o objeto, retorna true ou false

        for (String nome1: nomes1){  //for it
            System.out.println(nome1);
        }
        System.out.println("------------------");

        nomes1.add("Juju"); //caso queira add algo a lista, podemos.

        //for indexado
        //size vai retornar o tamanho dessa lista
        for (int i = 0; i < nomes1.size(); i++) {
            System.out.println(nomes1.get(i));
        }

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);

        //dica: não da para botar um .add dentro do for senão causará uma excessão, seja no inicio, como no final
        /* for (String nome1: nomes1){  //for it
             System.out.println(nome1);
             nomes1.add("Will");
            }
            outro erro, causa repetição infinita. FOR INDEXADO
          for (int i = 0; i < nomes1.size(); i++) {
            System.out.println(nomes1.get(i));
            nomes1.add("will");
           }
          */
    }
}
