package academy.dev.PadroesProjetos.teste;

import academy.dev.PadroesProjetos.dominio.AircraftSingletonEnum;

public class AircraftSingletonEnumTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    private static void bookSeat(String seat){
        System.out.println(AircraftSingletonEnum.INTANCE.hashCode());
        AircraftSingletonEnum intance = AircraftSingletonEnum.INTANCE;
        System.out.println(intance.bookSeat(seat));
    }
}
