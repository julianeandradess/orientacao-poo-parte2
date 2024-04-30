package XserializacaoTest;

import XserializacaoTest.Dominio.Aluno;
import XserializacaoTest.Dominio.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializacaoTest01 {
    public static void main(String[] args) {
        //não se esqueça de implementar Serializable na classe a qual está trabalhando pois senão causará excessões
        //serialização significa salvar o estado atual dos objetos em arquivo em formato binário
        //desserialização permite que os objetos persistido em arquivos possam ser recuperados e seus valores recriados na memoria
        //para não "ver" a senha posta pelo aluno basta serializar e deserializar ao mesmo tempo
        Aluno aluno = new Aluno(1L, "Juliane Andrade", "12345678");
        Turma turma = new Turma("Maratona Java");
        aluno.setTurma(turma);
        serializar(aluno);
        deserializar();
    }
    //metodo que salva
    //quando serializamos trabalhamos com a classe do pacote IO, nioIO, está transformando o objeto em baixo nivel, que é String
    private static void serializar(Aluno aluno){
        Path path = Paths.get("pasta/aluno.ser");
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))){ //quando for escrever, é nesse arquivo
            oos.writeObject(aluno); //escrever um objeto
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void deserializar(){
        //como eu sei que eu mesmo to lendo, podemos colocar aluno
        //precisaremos tratar essa excessão de readObject porque pode não ser um aluno
        //o contrutor não é utilizado dentro da deserialização, cuidado se tiver trabalhando com heranças
        Path path = Paths.get("pasta/aluno.ser");
        try(ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(path))){
            Aluno aluno = (Aluno) inputStream.readObject();
            System.out.println(aluno);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
