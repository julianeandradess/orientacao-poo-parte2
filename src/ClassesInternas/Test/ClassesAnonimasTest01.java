package ClassesInternas.Test;


//classes anonimas são classes que vão existir brevemente por um determinado periodo, que não poderá ser reutilizada
//por nenhum outro lugar.


class Animal{
    public void walk(){
        System.out.println("Animal Walking");
    }
}
/*forma mais facil de mudar um comportamento seria usando nada mais que polimorfismo, por exemplo:
class Cachorro extends Animal{
    @Override
    public void walk() {   //ctrl+ o
        System.out.println("Cachorro walking");
    }
}*/
public class ClassesAnonimasTest01 {
    public static void main(String[] args) {
        //criando uma classe anonima, em vez de ; colocamos { }; é como se fosse uma subclasse de animal
        // usamos ctrl+O apos e modificamos. Porem, não vemos mais o sout lá de cima, vemos o que está dentro da subclass
        //tem as mesmas regras de uma interna, metodos criados dentro da anonima, não podem ser chamados fora
        Animal animal = new Animal(){
            @Override
            public void walk() {
                System.out.println("Walking in the shadowns");
                jump();
            }
            public void jump(){
                System.out.println("pula pula");
            }
        };
        animal.walk();
    }

}
