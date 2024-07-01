package academy.dev.Concorrencia.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest01 {
    private static final ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(1);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static void beeper(){
        Runnable run = () -> {
            System.out.println(LocalTime.now().format(formatter)+ " beep");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        //o scheduled serve para a gente determinar quando quer que tais coisas sejam feitas, ex do beep
        // scheduledService.schedule(run, 5, TimeUnit.SECONDS); vai executar dps de 5seg

        //abaixo: o metodo, se inicia dps de 1seg, tendo um delay a cada 5seg e mostrando eternamente
        //fixedDelay, não é continuo, quando tem o sleep junto, ele basicamente reinicia toda vez que bater nele
        //fazendo assim uma recontagem
        ScheduledFuture<?> scheduledFixedDelay = scheduledService.scheduleWithFixedDelay(run, 1, 5, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledRate = scheduledService.scheduleAtFixedRate(run, 1, 5, TimeUnit.SECONDS);
        //já essa não, ela é continua mesmo com o sleep, não importa o tempo de sleep, ela continua

        //parar o scheduled que ta rodando eternamente abaixo:  -- pode deixar ou não o Runnable
        scheduledService.schedule((Runnable) () -> {
            System.out.println("Cancelando o SheduleWithFIxedDelay");
            scheduledFixedDelay.cancel(false); // "deve interromper se tiver rodando? nao"
            scheduledService.shutdown(); //para de rodar
        },20, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(formatter));
        beeper();
    }
}
