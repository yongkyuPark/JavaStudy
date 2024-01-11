package chapter10.exam09;

import java.util.concurrent.*;

public class ScheduleRunnableExample {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            System.out.println("작업이 한 번 실행 됩니다.");
        };

        scheduler.schedule(task, 3, TimeUnit.SECONDS);

        Thread.sleep(5000);

        scheduler.shutdown();

    }
}
