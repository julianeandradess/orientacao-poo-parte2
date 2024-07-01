package academy.dev.Optional.Dominio;

public class Mangax {
    private Integer id;
    private String titulo;
    private int chapters;

    public Mangax(Integer id, String titulo, int chapters) {
        this.id = id;
        this.titulo = titulo;
        this.chapters = chapters;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public int getChapters() {
        return chapters;
    }

    @Override
    public String toString() {
        return "Mangax{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", chapters=" + chapters +
                '}';
    }
}
