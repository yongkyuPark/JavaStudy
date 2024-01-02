package chapter06.exam02;

public class BinarySemaphoreExample {

    public static void main(String[] args) throws InterruptedException {

        SharedResource sharedResource = new SharedResource(new BinarySemaphore());

        Thread thread1 = new Thread(() -> {
            sharedResource.sum();
        });

        Thread thread2 = new Thread(() -> {
            sharedResource.sum();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("최종 합계 : " + sharedResource.getSum());

    }

}

class SharedResource {

    private int sharedValue = 0;
    private CommonSemaphore commonSemaphore;

    public SharedResource(CommonSemaphore commonSemaphore) {
        this.commonSemaphore = commonSemaphore;
    }

    public void sum() {
        try {
            commonSemaphore.acquired();
            for (int i = 0; i < 1000; i++) {
                sharedValue++;
            }
        } finally {
            commonSemaphore.release();
        }
    }

    public int getSum() {
        return sharedValue;
    }

}