package academy.dev.ClassesInternas;

public class ClasseDeForaTest01 {
    private  String nome = "Monkey D. Luffy";

    class Inner{  //classe interna
        public void printOuterClassAtributte(){
            System.out.println(nome);
            System.out.println(this);
            System.out.println(ClasseDeForaTest01.this);
        }
    }

    public static void main(String[] args) {
        //classes internas são basicamente uma classe dentro da outra
        //meu main faz parte da classe de fora, Outer
        //para criar um objeto na parte interna, você precisa de um objeto da classe externa, ele está fortemente ligado com a classe externa
        //precisamos de um objeto da classe de fora, não da para criar a new Inner por exemplo de cara, pq o interno não é um metodo static
        //poderia ser assim tbm: ClasseDeForaTest01.Inner inner = outerClass.new Inner();
        //o this sempre se referencia ao contexto da classe que ele se encontra
        //para usar o this referenciando a classe de fora basta usar: System.out.println(ClasseDeForaTest01.this);

        ClasseDeForaTest01 outerClass = new ClasseDeForaTest01();
        Inner inner = outerClass.new Inner();//criando um objeto da classe interna
        Inner inner2 = new ClasseDeForaTest01().new Inner();//outro jeito de criar
        inner.printOuterClassAtributte();
        inner2.printOuterClassAtributte();
    }
}
