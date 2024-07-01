package academy.dev.PadroesProjetos.teste;

import academy.dev.PadroesProjetos.dominio.Aircraft;

public class AircraftTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    private static void bookSeat(String seat){
        //mostra true 2x pq duplica o objeto, pq foi "iniciado 2x", não sendo puxado diretamente
        //mesmo dando o nome pra aeronave, ex: 787-900
        Aircraft aircraft = new Aircraft("787-900");
        System.out.println(aircraft.bookSeat(seat));
    }
}
