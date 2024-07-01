package academy.dev.PadroesProjetos.teste;

import academy.dev.PadroesProjetos.dominio.Pessoa;

public class BuilderPatternTest01 {
    public static void main(String[] args) {
        // em vez de usarmos o Pessoa pessoa = new Pessoa(); chamamos:
        Pessoa build = new Pessoa.PessoaBuilder()
                .firstName("Juliane").lastName("Andrade").userName("juju").email("juju@...").build();
        System.out.println(build);
    }
}
