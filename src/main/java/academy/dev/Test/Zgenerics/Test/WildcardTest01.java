package academy.dev.Test.Zgenerics.Test;


abstract class Animal{
    public abstract void consulta();

}

class Cachorro extends Animal{

    @Override
    public void consulta() {
        System.out.println("consultando doguinho");
    }
}
class Gato extends Animal{

    @Override
    public void consulta() {
        System.out.println("consultando gatinhos");
    }
}
public class WildcardTest01 {
    public static void main(String[] args) {
        //com arrays é só usar o poli pra ajudar mas em list é diferente

        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};
        printConsulta(cachorros);
        printConsulta(gatos);

        Animal[] animals = {new Cachorro(), new Gato()}; //polimorfismo
        printConsulta(animals);
    }

    private static void printConsulta(Animal[] animals){ //se tem void não tem sout, se o metodo não tem static, não da pra chamar no main
        for (Animal animal : animals) {
            animal.consulta();
        }

    }
}
