package academy.dev.Comportamentos.Test;

import academy.dev.Comportamentos.dominio.Car;

import java.util.ArrayList;
import java.util.List;

//filtrar a lista de carros
public class ComportamentoPorParametroTest01 {
    //atributo de classe
   private static List<Car> cars = List.of(new Car("Green", 2011), new Car("Black", 1998), new Car("Red",2019));

    public static void main(String[] args) {
        System.out.println(filterGreenCar(cars));
        System.out.println(filterRedCar(cars));
        System.out.println(filterCarByColor(cars, "Black"));
        System.out.println("-----");
        System.out.println(filterByYearBefore(cars, 2015));
    }

    //metodos
    //em vez de duplicar para mudar a cor pedida por exemplo, pedimos a cor ao parametro, os 2 primeiros são copia e cola
    //o 3 funciona super bem
    private static List<Car> filterGreenCar (List<Car> cars){
        List<Car> greenCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("Green")){
                greenCars.add(car);
            }
        }
        return greenCars;
    }

    private static List<Car> filterRedCar (List<Car> cars){
        List<Car> redCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("Red")){
                redCars.add(car);
            }
        }
        return redCars;
    }
    private static List<Car> filterCarByColor(List<Car> cars){
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("Red")){
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }
    //basta pedir a cor ao cliente, ele fará o proprio filtro.
    private static List<Car> filterCarByColor(List<Car> cars, String cor){
        List<Car> filterByColor = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals(cor)){
                filterByColor.add(car);
            }
        }
        return filterByColor;
    }
    private static List<Car> filterByYearBefore(List<Car> cars, int year){
        List<Car> filterAnoAntes = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() < year){
                filterAnoAntes.add(car);
            }
        }
        return filterAnoAntes;
    }


}


/* escolha
witch (color){

        case "Green":
        System.out.println("você escolheu a cor verde");
        break;
        case "Red":
        System.out.println("você escolheu a cor vermelha");
        break;
        case "Black":
        System.out.println("você escolheu a cor preta");
        break;
default:
        System.out.println("Escolha uma cor novamente");
        }
        return colorsCars;

 */