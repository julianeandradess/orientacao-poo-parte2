package academy.dev.jdbc.listener;

import lombok.extern.log4j.Log4j2;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import java.sql.SQLException;

@Log4j2
public class CustomRowSetListener implements RowSetListener {

    //quando o comando é ativado
    @Override
    public void rowSetChanged(RowSetEvent event) {
        log.info("Command execute triggered");
    }

    //vai ser chamado quando você fizer uma alteração no banco de dados
    //precisamos verificar se quem gerou esse evento é um rowSet, se for uma instancia de rowset
    //significa que podemos fazer o seguinte:
    //poderiamos em vez de usar o try, usar o @SneakyThrows, lombok, basicamente coloca seu codigo dentro do try sem ter
    //porem voce perde a oportunidade de tratar sua exception

    @Override
    public void rowChanged(RowSetEvent event) {
        log.info("Row inserted, updated or deleted");
        if (event.getSource() instanceof RowSet){
            try {
                ((RowSet) event.getSource()).execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //quando o cursor se move
    @Override
    public void cursorMoved(RowSetEvent event) {
        log.info("Cursor moved");
    }
}
