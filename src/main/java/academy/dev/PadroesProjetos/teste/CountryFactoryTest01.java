package academy.dev.PadroesProjetos.teste;

import academy.dev.PadroesProjetos.dominio.Country;
import academy.dev.PadroesProjetos.dominio.Moeda;
import academy.dev.PadroesProjetos.dominio.MoedaFactory;

public class CountryFactoryTest01 {
    public static void main(String[] args) {
        Moeda moeda = MoedaFactory.newMoeda(Country.BRASIL);
        System.out.println(moeda.getSimbol());
    }
}
