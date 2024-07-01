package academy.dev.PadroesProjetos.dominio;

public class MoedaFactory {
    public static Moeda newMoeda(Country country){
        switch (country){
            case USA ->{ // ou case USA: return new UsDollar();
                return new UsDollar();
            }
            case BRASIL -> {
                return new Real();
            }
            default -> {
                throw new IllegalArgumentException("Essa moeda não está na pasta country");
            }
        }
    }
}
