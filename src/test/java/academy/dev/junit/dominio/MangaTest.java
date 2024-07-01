package academy.dev.junit.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MangaTest {
    private Manga manga1;
    private Manga manga2;


    @BeforeEach
    public void setUp(){
        manga1 = new Manga("Kimetsu no Yaiba", 24);
        manga2 = new Manga("Kimetsu no Yaiba", 24);
    }

    //verificação pra ver se está retornando os dados certos.
    @Test
    public void acessors_ReturnData_WhenInitialized(){
        Assertions.assertEquals("Kimetsu no Yaiba", manga1.name());
        Assertions.assertEquals(24, manga1.episodios());

    }

    //testar pra saber se são iguais, ele mesmo chamará o equals
    @Test
    public void equals_ReturnTrue_WhenObjectAreTheSame(){
        Assertions.assertEquals(manga1, manga2);
    }

    @Test
    public void hashCode_ReturnTrue_WhenObjectAreTheSame(){
        Assertions.assertEquals(manga1.hashCode(), manga2.hashCode());
    }

    @Test
    public void constructor_ThrowNullPointerException_WhenNameIsNull(){
        Assertions.assertThrows(NullPointerException.class, ()-> new Manga(null, 12));
    }

    //verificando se a classe é um record
    @Test
    public void isRecord_ReturnTrue_WhenCallendFromManga(){
        Assertions.assertTrue(Manga.class.isRecord());
    }
}