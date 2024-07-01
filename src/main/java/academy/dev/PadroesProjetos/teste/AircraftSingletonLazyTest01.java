package academy.dev.PadroesProjetos.teste;


import academy.dev.PadroesProjetos.dominio.AircraftSingletonLazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AircraftSingletonLazyTest01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        bookSeat("1A");
        bookSeat("1A");
        System.out.println(AircraftSingletonLazy.getInstance());
        System.out.println(AircraftSingletonLazy.getInstance());
        System.out.println("---");

        //fazendo o construtor ficar publico:
        //tornando ele acessivel (setAccessible)
        //não se esqueça de lançar as exceptions
        Constructor<AircraftSingletonLazy> constructor = AircraftSingletonLazy.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        AircraftSingletonLazy aircraftSingletonLazy = constructor.newInstance("799-800");
        System.out.println(aircraftSingletonLazy);
    }

    private static void bookSeat(String seat){

        System.out.println(AircraftSingletonLazy.getInstance());
        AircraftSingletonLazy aircraftSingletonLazy = AircraftSingletonLazy.getInstance();
        System.out.println(aircraftSingletonLazy.bookSeat(seat));
    }
}
