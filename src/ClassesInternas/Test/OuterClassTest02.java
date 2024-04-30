package ClassesInternas.Test;

/*
classes locais é quando você tem uma classe dentro de um método ou quando não está diretamente dentro da classe
não temos acesso a classe local uma vez que esse metodo termina
sempre que criar uma classe local você precisa inicializar essa classe diretamente no metodo senão não terá mais acesso
essa é a unica forma que você tem de utilizar essas classes locais
regras:
quanto aos modificadores de acesso: temos 2 opções, abstract ou final class
relacionado a atributos: digamos que você tem um atributo dentro do metodo(void print - String lastName = "Izuku";)
você poderá usa-la dentro da classe local, ex printLocal. Mas obrigatoriamente você terá que usar assim:
final String lastName ou só String lastName, porque o java entende que ela terá o final e não poderá ser mudada apos isso
a mesma regra vale para o parametro,
*/

public class OuterClassTest02 {
    private String nome = "Midoriya";
    void print(final String param){
        final String lastName = "Izuku";
        class LocalClass {
            public void printLocal(){
                System.out.println(param);
                System.out.println(nome + " " + lastName);
            }
        }
        LocalClass localClass = new LocalClass();
        localClass.printLocal();
        //se quiser deixar em uma unica linha: new LocalClass().printLocal();
    }

    public static void main(String[] args) {
        OuterClassTest02 outer2 = new OuterClassTest02();
        outer2.print(outer2.nome);
    }
}
