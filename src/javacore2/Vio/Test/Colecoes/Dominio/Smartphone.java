package javacore2.Vio.Test.Colecoes.Dominio;

public class Smartphone {
    private String serialNumber;
    private String marca;

    //ctrl + o ---- regras do equals =
    // reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null.
    // simetrico: para x e y diferente de null, se x.equals(y) == true logo, y.equals(x) == true.
    // transitividade: para x, y e z diferentes de null, se x.equals(y) == true, logo x.equals(z) == true, logo y.equals(z) tambem tem que ser true.
    // consistencia: para independente de quantas vezes que você chamar x.equals(x), sempre tem que retornar true, se x for diferente de null.
    // para x diferente de null. x.equals(null), tem que retornar false.

    //para fazer 2 objetos distintos com conteudos iguais com resultado false, dar true:
    //mas atenção, só deu true porque estamos comparando o serialNumber, se mudassemos a marca, por exemplo
    //daria true novamente porque não estamos comprando ela, se atente ao que quer fazer comparação
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if(this.getClass() != getClass()) return false; //estamos verificando se esse objeto faz parte do smartphone
        Smartphone smartphone = (Smartphone) obj; //nessa linha confirmamos que o Smart é o obj
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber);//comparação
    }
    // retorna um int
    // regras do hashCode:
    // se x.equals(y) == true, y.hashCode() == x.hashCode(). Ex: se o hashCode de Alex é 42, todo alex será 42
    // se y.hashCode() == x.hashCode() não necessariamenteo equals de y.equals(x) tem que ser true
    // ex: Alex é 42 e Dirk tbm é 42, mas não significa que são o mesmo objeto apesar do mesmo valor de hashCode
    // se x.equals(y) == false, tem que ser diferente
    // y.hashCode() != x.hashCode(), x.equals(y) deverá ser false. Precisam estar em sintonia para ser true
    @Override
    public int hashCode() {
        return serialNumber == null ? 0 : this.serialNumber.hashCode(); //a classe já tem um calculo pronto.
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }

    public String getSerialNumber() {
        return serialNumber;
    }



    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
