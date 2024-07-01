package academy.dev.Concorrencia.test;


import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

//basicamente a linkedTransferQueue é uma classe que é uma junção de outras 3 queues:
//ConcurrenteLinkedQueue, SynchronousQueue e linkedBlockingQueue, juntou a funcionalidade das 3 em uma só
//foi introduzido na versão: 1.7 do java
//suas funçoes: bloquear e não bloquear. Se não tiver espaço, lança exception
//apesar do linkedTransferQueue não mostrar ou pedir a capacidade que quer, ele tem uma fixa
public class LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException{
        LinkedTransferQueue<Object> tq = new LinkedTransferQueue<>();
        System.out.println(tq.add("lila")); //add lança exception
        System.out.println(tq.offer("lilo")); //não lança, retorna true ou false
        System.out.println(tq.offer("lilu", 10, TimeUnit.SECONDS)); //digamos que queremos tentar por 10s
        tq.put("devju"); //insere e espera, bloqueia e espera ate ter espaço
        if (tq.hasWaitingConsumer()){ //verifica se tem um consumidor esperando
            tq.transfer("deev");
        }
        // transfer: bloqueia, ate um elemento tentar pegar o elemento que colocou. solução acima
        //outra solução sem ser o if, abaixo:
        System.out.println(tq.tryTransfer("kaka", 5, TimeUnit.SECONDS));
        System.out.println(tq.element()); //vai exibir o primeiro elemento dessa queue mas não vai remover
        //se tiver vazia, o element vai lançar uma exception
        System.out.println(tq.peek()); //pega o valor que tem la e null se for vazio
        System.out.println(tq.poll()); //pega e remove o 1 da fila ou retorna null se tiver vazia(lança excep)
        System.out.println(tq.remove()); //parecido com o poll sem a excep, apenas retorna null
        System.out.println(tq.take()); //pega o primeiro valor e retira da fila, vai ficar esperando colocar outro valor la
        System.out.println(tq.remainingCapacity()); //mostra a capacidade

    }
}
