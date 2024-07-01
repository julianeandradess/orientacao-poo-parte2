package academy.dev.PadroesProjetos.dominio;

public interface Moeda {
    String getSimbol();
}
class Real implements Moeda{

    @Override
    public String getSimbol() {
        return "R$";
    }
}
class UsDollar implements Moeda{

    @Override
    public String getSimbol() {
        return "$";
    }
}
