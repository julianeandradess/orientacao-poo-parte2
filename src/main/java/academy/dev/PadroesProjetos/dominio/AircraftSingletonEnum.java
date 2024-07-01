package academy.dev.PadroesProjetos.dominio;

import java.util.HashSet;
import java.util.Set;

public enum AircraftSingletonEnum {
    //resolvendo o caso da duplicação

    INTANCE;
    private final Set<String> availableSeats;

    AircraftSingletonEnum() {
        this.availableSeats = new HashSet<>();
        this.availableSeats.add("1A");
        this.availableSeats.add("1B");
    }

    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }
}
