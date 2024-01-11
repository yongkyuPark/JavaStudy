package chapter10.exam09;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleAtFixedRateExample {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        Runnable task = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        ScheduledFuture<?> scheduledFuture = scheduler.scheduleAtFixedRate(task, 1, 1, TimeUnit.SECONDS);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        scheduledFuture.cancel(true);
        scheduler.shutdown();

    }
}
