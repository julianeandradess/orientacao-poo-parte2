package academy.dev.Comportamentos.Test;

import academy.dev.Comportamentos.dominio.Car;
import academy.dev.Lambdas.Dominio.CarPredicate;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest02 {
   private static List<Car> cars = List.of(new Car("Green", 2011), new Car("Black", 1998), new Car("Red",2019));

    public static void main(String[] args) {
        //Fizemos uma interface CarPredicate para exemplo, porem, no proprio java podemos chamar a Predicate, tem a mesma função.

        //em lambda ficaria assim:
        //List<Car> greenCars = filter(cars -> car.getColor().equals("Green");
        //List<Car> carYearBefore = filter(cars -> car.getYear() < 2015;
        //List<Car> redCars = filter(cars -> car.getColor().equals("Red");

        List<Car> greenCars = filter(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("Green");
            }
        });
        System.out.println(greenCars);

        System.out.println("----------");
        List<Car> carYearbefore = filter(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
               return car.getYear() < 2015;
            }
        });
        System.out.println(carYearbefore);

        System.out.println("-----------");

        List<Car> redCars = filter(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("Red");
            }
        });
        System.out.println(redCars);
    }

    //agora a responsabilidade de filtrar não será mais da regra de negócio que passamos antes(String cor)
    //e sim será enviada via pelo CarPredicate, a interface. Atraves do polimorfismo.
    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate){
        List<Car> filterCar = new ArrayList<>();
        for (Car car : cars) {
            if(carPredicate.test(car)){
                filterCar.add(car);
            }
        }
        return filterCar;
    }


}
