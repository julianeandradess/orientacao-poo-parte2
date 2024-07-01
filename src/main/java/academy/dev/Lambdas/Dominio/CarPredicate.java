package academy.dev.Lambdas.Dominio;

import academy.dev.Comportamentos.dominio.Car;

public interface CarPredicate {
    boolean test(Car car);

}
/*
Lamdas: Elas precisam obrigatoriamente que a interface que está trabalhando seja uma interface funcional
O que é interface funcional: É uma interface onde tem apenas um metodo abstrato, se tentar criar 2 em uma unica interface, dará ruim
Lambdas tem o parametro e corpo - classe, (parametro) ->  <expressão>
cars - classe
(Car, car) - parametro
car.getColor.equals("green") - expressão
 cars, (Car, car) -> car.getColor.equals("green"); ou cars, car -> car.getColor.equals("green");
 elas são anonimas, chamamos ela tbm de funções. Não estão atreladas a nenhuma classe
 o objetivo dela é deixar o codigo mais conciso

 se quisermos colocar um return é assim, porem não é necessaro, o java já entende sem ele
        List<Car> greenCars = filter(cars, car -> {return car.getColor().equals("Green")});

 */

