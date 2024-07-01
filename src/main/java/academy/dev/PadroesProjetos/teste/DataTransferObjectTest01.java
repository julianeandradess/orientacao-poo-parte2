package academy.dev.PadroesProjetos.teste;

import academy.dev.PadroesProjetos.dominio.*;

public class DataTransferObjectTest01 {
    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft("777");
        Country country = Country.BRASIL;
        Moeda currency = MoedaFactory.newMoeda(country);
        Pessoa pessoa = Pessoa.PessoaBuilder.pessoaB().firstName("Juju").lastName("Andrade").build();
        ReportDto reportDto = ReportDto.ReporDtoBuilder.builder()
                .aircrafName(aircraft.getName())
                .country(country)
                .currency(currency)
                .personName(pessoa.getFirstName())
                .build();
        System.out.println(reportDto);

    }
}
