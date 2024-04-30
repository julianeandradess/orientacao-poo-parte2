package Optional.Repositorio;

import Optional.Dominio.Mangax;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaxRepositorio {
    //uma lista de repositorios
    private static List<Mangax> mangaxList = List.of(new Mangax(1, "Boku", 50), new Mangax(2, "Over Lord", 25));

    //jeito feio
    public static Optional<Mangax> findByTitle(String titulo){
        return findBy(t -> t.getTitulo().equals(titulo));
    }

    public static Optional<Mangax> findById(Integer id){
        return findBy(m -> m.getId().equals(id));
    }

    //jeito sensacional:
    public static Optional<Mangax> findBy(Predicate<Mangax> predicate){
        Mangax foundx = null;
        for (Mangax mangaxBy : mangaxList) {
            if (predicate.test(mangaxBy)){
                foundx= mangaxBy;
            }
        }
        return Optional.ofNullable(foundx);
    }
}
/*
jeito feio basico:
    private static Optional<Mangax> findByTitle(String titulo){
        Mangax found = null;
        for (Mangax mangax : mangaxList) {
            if (mangax.getTitulo().equals(titulo)){
                found = mangax;

            }
        }
        return Optional.ofNullable(found);
    }

    private static Optional<Mangax> findById(Integer id){
        Mangax founds = null;
        for(Mangax mangaxId : mangaxList){
            if (mangaxId.getId().equals(id)){
                founds = mangaxId;
            }
        }
        return Optional.ofNullable(founds);
    }
 */
