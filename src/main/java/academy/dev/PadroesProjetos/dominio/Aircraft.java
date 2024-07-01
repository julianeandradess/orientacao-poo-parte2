package academy.dev.PadroesProjetos.dominio;

import java.util.HashSet;
import java.util.Set;

public final class Aircraft {
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;
    { //iniciação
        availableSeats.add("1A");
        availableSeats.add("1B"); //assentos da aeronave
    }

    public Aircraft(String name) {
        this.name = name;
    }

    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }

    public String getName() {
        return name;
    }
}
