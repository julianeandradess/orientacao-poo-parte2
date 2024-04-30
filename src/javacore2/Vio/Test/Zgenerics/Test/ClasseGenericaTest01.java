package javacore2.Vio.Test.Zgenerics.Test;

import javacore2.Vio.Test.Zgenerics.Dominio.Carro;
import javacore2.Vio.Test.Zgenerics.Servico.CarroRentavelService;

public class ClasseGenericaTest01 {
    public static void main(String[] args) {
        CarroRentavelService carroRentavelService = new CarroRentavelService();
        Carro carro = carroRentavelService.buscarCarroDisponivel();
        System.out.println("Usando o carro por um mês...");
        carroRentavelService.retornarCarroAlugado(carro);
    }
}
