package academy.dev.Threads.Test;

class ThreadExempleRunnable2 implements Runnable {
    private final String d;
    public ThreadExempleRunnable2(String d) {this.d = d;}

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.print(d);
            if (i % 50 == 0) {
                System.out.println();
            }
            //Thread.yield();
            try {
                Thread.sleep(50);   //NAO ESQUECER DO TRY
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
// o Yield = é um método que foi criado pra voce falar para thread em execução dar uma pausa, é tipo uma indicação
// que informamos que ele pode dar a vez pra outra. Porem não tem muita garantia
//Join = a join informa para a main, que está manipulando todas, que precisa que a indicada finalize o trabalho dela
// não se esqueça de lançar a excessão

    public class ThreadsTest02 {
        public static void main(String[] args) throws InterruptedException {
            /* uma das formas a ser feita é atraves de uma innerclass Thread t1 = new Thread(new Runnable) alt+enter
            se remover a primeira parte, deixando só new Thread(() -> {codigo}).start(); - poderá dar start
            Thread t1 = new Thread(() -> {
                codigo
            });
            opcção mais organizada abaixo:
            Runnable exemple = () -> {

            }
            new Thread(exemple) */
            Thread t1 = new Thread(new ThreadExempleRunnable2("KA"));
            Thread t2 = new Thread(new ThreadExempleRunnable2("ME"));

            t1.setPriority(Thread.MAX_PRIORITY);
            t1.start();
            t1.join();
            t2.start();
        }
    }


