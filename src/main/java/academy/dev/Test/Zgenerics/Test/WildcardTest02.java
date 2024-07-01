package academy.dev.Test.Zgenerics.Test;


import java.util.ArrayList;
import java.util.List;

public class WildcardTest02 {
    public static void main(String[] args) {
        //com arrays é só usar o poli pra ajudar mas em list é diferente

        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato());
        printConsulta(cachorros);
        printConsulta(gatos);
        System.out.println("---------------");

        List<Animal> animals = new ArrayList<>();
        printConsultaAnimal(animals);
        printConsultaAnimal(gatos);
        System.out.println("---------------");

        printAddAnimal(animals);
        System.out.println(animals.size());

    }
    //type enrasure, wildcard é o ? dentro do (), qualquer tipo de lista é aceito que seja extends de uma classe
    //quando fazemos isso, assinamos como um contrato, que diz que voce não vai poder adicionar elementos nessa lista
    //não podemos adicionar nada a essa lista por conta do conceito do polimorfismo
    //um gato pode ser um animal mas nem todo animal é um gato.
    //tudo que passaremos caso quisermos uma lista, será para leitura
    //nesse caso não conseguimos implementar algo, ex: Comparable, a unica palavra aceita nesse caso de herança, é extends
    //sendo assim, conseguimos passar o método tranquilamente

    private static void printConsulta(List<? extends Animal> animals){ //se tem void não tem sout, se o metodo não tem static, não da pra chamar no main
        for (Animal animal : animals) {
            animal.consulta();
        }
    }
    //se precisarmos add:
    //List<?> quero receber nessa lista qualquer objeto que seja um animal ou um super de animal
    //ir de Animal - cachorro, gato, é mais facil que ir para baixo que para cima, a variavel no for será sempre objeto,
    //não dá para chamar uma lista de animal, temos que chamar uma lista de objetos
    private static void printConsultaAnimal(List<? super Gato > animals) {
        for (Object object : animals) {
            if (object instanceof Cachorro) { //para pegar um cachorro, gato, animal
                System.out.println("miau miau");
            }else {
                System.out.println("bugou");
            }
        }
    }

    //obrigatoriamente terá que ser um animal ou um super, ex do que não poderia passar: cachorros, gatos
    //a garantia desse método é que nessa lista os objetos sempre serão do tipo animal
    private static void printAddAnimal(List<? super Animal> animals){
        //Animal animal = new Cachorro(); //tipo animal
        //Animal animal2 = new Gato();

        animals.add(new Cachorro());
        animals.add(new Gato());


    }
}
