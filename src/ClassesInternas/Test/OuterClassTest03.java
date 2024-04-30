package ClassesInternas.Test;


/*quando utilizamos o static dentro de outra classe, para formar uma interna, é como se você tivesse
uma outra classe de alto nivel, tem o mesmo valor se tivesse fora, nesse caso está dentro mais por questão de
empacotamento. Voce atraves da static class não conseguirá acessar algum atributo que não seja static da classe mais externa
para conseguir acesso, basta;
*/
public class OuterClassTest03 {
    private String nome = "Lolo";
    static class Nested{
        private String lastName = "Pontes";

        void print(){
            System.out.println(new OuterClassTest03().nome+ " "+ lastName);
        }

    }

    public static void main(String[] args) {
        //diferentes dos outros objetos, podemos chamar o static diretamente:
        Nested nested = new Nested();
        nested.print();
    }
}
