package academy.dev.PadroesProjetos.dominio;

import java.util.HashSet;
import java.util.Set;

public final class AircraftSingletonEager {
    //Estamos criando um objt do mesmo tipo da classe
    //chamamos de iniciação Eager: como o atributo é static, esse objt será criado

    private static final AircraftSingletonEager INTANCE = new AircraftSingletonEager("789-900");
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    //tem que ser privado obrigatoriamente
    private AircraftSingletonEager(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1b");
    }

    public static AircraftSingletonEager getInstance(){
        return INTANCE;
    }

    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }
}
