package academy.dev.Test.Zgenerics.Test;

import academy.dev.Test.Zgenerics.Dominio.Barco;
import academy.dev.Test.Zgenerics.Servico.BarcoRentavelServics;


public class ClasseGenericaTest02 {
    public static void main(String[] args) {
        BarcoRentavelServics barcoRentavelService = new BarcoRentavelServics();
        Barco barco = barcoRentavelService.buscarBarcoDisponivel();
        System.out.println("Usando o barco por um mês...");
        barcoRentavelService.retornarBarcoAlugado(barco);
    }
}
