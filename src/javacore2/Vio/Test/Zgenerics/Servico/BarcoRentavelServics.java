package javacore2.Vio.Test.Zgenerics.Servico;

import javacore2.Vio.Test.Zgenerics.Dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentavelServics {
    private List<Barco> barcosDiponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));

    public Barco buscarBarcoDisponivel(){
        System.out.println("Buscando barco disponível...");
        Barco barco = barcosDiponiveis.remove(0);
        System.out.println("Alugando barco "+ barco);
        System.out.println("Barcos disponiveis para alugar:");
        System.out.println(barcosDiponiveis);
        return barco;
    }

    public void retornarBarcoAlugado(Barco barco){
        System.out.println("Devolvendo barco "+ barco);
        barcosDiponiveis.add(barco);
        System.out.println("Barcos disponiveis para alugar: ");
        System.out.println(barcosDiponiveis);
    }
}
