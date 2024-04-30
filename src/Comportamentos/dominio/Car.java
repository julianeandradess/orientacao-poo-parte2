package Comportamentos.dominio;

public class Car {
    private String nome = "Audi";
    private String color;
    private int year;

    //construtor de color e year porque já tem o nome definido.

    public Car(String color, int year) {
        this.color = color;
        this.year = year;
    }

    public String getNome() {
        return nome;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nome='" + nome + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }
}
