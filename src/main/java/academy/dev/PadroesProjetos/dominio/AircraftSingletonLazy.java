package academy.dev.PadroesProjetos.dominio;

import java.util.HashSet;
import java.util.Set;

public final class AircraftSingletonLazy {

    private static AircraftSingletonLazy INTANCE;
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    private AircraftSingletonLazy(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1b");
    }

    //adicionamos um if e um synchronized, porem o uso do sync afetará a perfomance
    //podemos usar então um duplo lock, 1 if dentro de outro
    public static AircraftSingletonLazy getInstance() {
        if(INTANCE == null){
            synchronized (AircraftSingletonLazy.class){
                if (INTANCE == null){
                    INTANCE = new AircraftSingletonLazy("799-800");
                }
            }
        }
        return INTANCE;
    }

    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }
}
