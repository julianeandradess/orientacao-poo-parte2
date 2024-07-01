package academy.dev.Test.Zgenerics.Servico;

import java.util.List;

//trabalhando com classes genericas, usamos o <T> tipo
public class RentalService<T> {
    //regra de negocio, que irá servir tanto para carro como para barco:
    private List<T> objetosDisponiveis;

    public RentalService(List<T> objetosDisponiveis) { //construtor
        this.objetosDisponiveis = objetosDisponiveis;
    }

    public T buscarObjetoDisponivel(){
        System.out.println("Buscando objeto disponível...");
        T t = objetosDisponiveis.remove(0);
        System.out.println("Alugando objeto "+ t);
        System.out.println("Objetos disponiveis para alugar:");
        System.out.println(objetosDisponiveis);
        return t;
    }

    public void retornarObjetoAlugado(T t){
        System.out.println("Devolvendo objeto "+ t);
        objetosDisponiveis.add(t);
        System.out.println("Objetos disponiveis para alugar: ");
        System.out.println(objetosDisponiveis);
    }
}
