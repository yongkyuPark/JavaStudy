package chapter06.exam02;

public class CountingSemaphoreExample {

    public static void main(String[] args) throws InterruptedException {
        int permits = 3;
        CommonSemaphore semaphore = new CountingSemaphore(permits);
        SharedResource resource = new SharedResource(semaphore);

        int threadCount = 15;

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                synchronized (CountingSemaphoreExample.class) {
                    resource.sum();
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
        }

        System.out.println("최종 값:" + resource.getSum());
    }
}
