package chapter07.exam01.method;

public class InstanceMethodSynchronizedExamples {

    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " 가 증가시켰습니다. 현재 값:" + count);
    }

    public synchronized void decrement() {
        count--;
        System.out.println(Thread.currentThread().getName() + " 가 감소시켰습니다. 현재 값:" + count);
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {

        InstanceMethodSynchronizedExamples counter = new InstanceMethodSynchronizedExamples();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                counter.decrement();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("최종값:" + counter.getCount());

    }
}
