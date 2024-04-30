package javacore2.Vio.Test.Zgenerics.Test;

import javacore2.Vio.Test.Zgenerics.Dominio.Barco;
import javacore2.Vio.Test.Zgenerics.Dominio.Carro;
import javacore2.Vio.Test.Zgenerics.Servico.BarcoRentavelServics;
import javacore2.Vio.Test.Zgenerics.Servico.RentalService;

import java.util.ArrayList;
import java.util.List;

//aplicando classe generica para melhorar a logica de negocio:
public class ClasseGenericaTest03 {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Mercedes")));

        List<Barco> barcosDiponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));

        RentalService<Carro> rentalServiceCarro = new RentalService<>(carrosDisponiveis);
        Carro carro = rentalServiceCarro.buscarObjetoDisponivel();
        System.out.println("Usando o carro por um mês...");
        rentalServiceCarro.retornarObjetoAlugado(carro);

        System.out.println("-------------------");
        RentalService<Barco> rentalServiceBarco = new RentalService<>(barcosDiponiveis);
        Barco barco = rentalServiceBarco.buscarObjetoDisponivel();
        System.out.println("Usando o barco por um mês...");
        rentalServiceBarco.retornarObjetoAlugado(barco);
    }
}
