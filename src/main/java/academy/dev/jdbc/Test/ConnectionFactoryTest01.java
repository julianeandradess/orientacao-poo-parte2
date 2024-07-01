package academy.dev.jdbc.Test;

import academy.dev.jdbc.dominio.Producer;
import academy.dev.jdbc.repository.ProducerRepository;
import academy.dev.jdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2

public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        /*Producer producer = Producer.ProducerBuilder.builder()
                .name("NHK").build();
        ProducerRepository.save(producer);
        como funciona se tiver todos os get/hashcode
        sem eles:
        */
        Producer producer = Producer.builder().id(1).name("madhouse").build();
        //ProducerService.save(producer); //usamos o producer service por ser mais seguro, por conta das camadas
        //ProducerService.delete(4);
        //ProducerService.update(producer);
        //List<Producer> producers = ProducerService.findAll();
        //List<Producer> producers = ProducerService.findByName("Mad");
        //log.info("Producers found '{}'", producers);
        //ProducerService.showProducerMetaData();
        //ProducerService.showDriverMetaData();
        //ProducerService.showTypeScrollWorking();
        //List<Producer> deen = ProducerService.findByNameAndUpdateToUpperCase("Deen");
        //List<Producer> bones = ProducerService.findByNameAndInsertWhenNotFound("Booking");
        //log.info("Producers '{}'", bones);
        //ProducerService.findByNameAndDelete("Booking");
        //List<Producer> producers = ProducerService.findByNamePreparedStatement("Bo"); //sql
        //log.info("Producers '{}'", producers);
        //ProducerService.updatePreparedStatement(producer);
        List<Producer> producers = ProducerService.findByNameCallableStatement("Bo"); //sql
        log.info("Producers '{}'", producers);


        /*  cada um desses para ser utilizado precisa ser incluido no arquivo log4j2.xml
            trocando as palavras, info, debug, trace, warn...
            log.info(); mensagem, podemos colocar em produção
            log.debug(); não colocamos em produção porque podem conter dados sensitivos
            log.warn(); realiza uma operação que pode causar um erro, mensagem de aviso
            log.error(); indica que o servidor falhou ao realizar uma operação ou responder solicitação
            log.fatal(); ocorreu um erro fatal
            log.trace(); indica operaçoes do servidor TDM em um nivel mais especifico que os logs de
            depuração. As mensagens de rastreamento são geralmente caminhos de codigo de rastreio
            log.off(); desativa o registro em log

        */
    }
}
