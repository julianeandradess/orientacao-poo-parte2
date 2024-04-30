package XserializacaoTest.Dominio;

import java.io.*;

public class Aluno implements Serializable {
    //quando não queremos que a senha do password seja revelada usamos a palavra transient, que não deve ser serializado
    //precisamos habilitar uma função para que esse transient seja aceito, caso não, causará uma excessão chamada serialVersionUID
    //no caso da intellij clique no ctrl+shift+a, quando habilitar vá no nome da class alt+enter @Serial
    //tiramos a palavra transient para no caso de serializar, usamos somente para deserializar
    //outra coisa que precisamos tomar cuidado são com atributos estaticos, pertencem a classe e não ao objeto, não são serializados
    //quando tentamos serializar algo que não foi serializado no começo, terá uma excessão, poderiamos mudar e colocar implementação
    //porem em alguns casos o código não é nosso para sair fazendo assim, então fazemos assim: transient (turma), adicionamos toString na class (Turma)

    @Serial
    private static final long serialVersionUID = 8544095220873737602L;

    private Long id;
    private String nome;
    private transient String password;
    private static final String NOME_ESCOLA = "Dev"; //irá serializar pois pertence a classe e não ao objeto
    private transient Turma turma;

    public Aluno(Long id, String nome, String password) {
        System.out.println("Dentro do construtor");
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    @Serial
    //metodo para escrever e serializar o objeto turma e como vai ser para ele ler esse objeto
    //oss.writeUTF = você não pode salvar o objeto, porque objeto não é serializavel mas os atributos podemos pegar e escrever
    private void writeObject(ObjectOutputStream oss){
        try {
            oss.defaultWriteObject();//primeiramente salve na forma padrão
            oss.writeUTF(turma.getNome());//em seguida terá que salvar tudo aquilo que não faz parte do default(defaultWriteObject)
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois){
        try {
            ois.defaultReadObject(); //precisa do ClassNotFoundExpection (le o padrão)
            String nomeTurma = ois.readUTF(); //le o restante, fazendo associação com o nomeTurma para que fique mais facil a visualização
            turma = new Turma(nomeTurma);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", NOME_ESCOLA ='" + NOME_ESCOLA + '\'' +
                ", Turma ='" + turma + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
