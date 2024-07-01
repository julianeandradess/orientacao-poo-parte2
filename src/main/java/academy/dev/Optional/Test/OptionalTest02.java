package academy.dev.Optional.Test;

import academy.dev.Optional.Dominio.Mangax;
import academy.dev.Optional.Repositorio.MangaxRepositorio;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
        /*
        1º requisito:
        faremos uma busca por titulos e se existir esse titulo queremos alterar
        MangaxRepositorio repositorio = new MangaxRepositorio(); COMO É STATIC NAO PRECISAMOS
        MangaxRepositorio.findByTitle("Boku").ifPresent(m-> m.setTitulo("Boku no Hero 2")); //se existir, quero altera-lo
        se quiser ver a alteração precisamos dividir todo o processo */
        
        
        Optional<Mangax> repositoTi = MangaxRepositorio.findByTitle("Boku");
        repositoTi.ifPresent(m -> m.setTitulo("Boku no Hero 2"));
        System.out.println(repositoTi);

        System.out.println("--------------");
        // 2° requisito: procurarmos pelo o id, senão existir terá que lançar uma excessao:

        Mangax mangaxId = MangaxRepositorio.findById(2).orElseThrow(IllegalArgumentException::new);
        System.out.println(mangaxId);
        System.out.println("-----------");

        //3º requisito: Caso não exista o titulo, queremos criar um novo:
        Mangax orElseGet = MangaxRepositorio.findByTitle("Drifters").orElseGet(() -> new Mangax(3, "Drifters", 30));
        System.out.println(orElseGet);
    }
}
