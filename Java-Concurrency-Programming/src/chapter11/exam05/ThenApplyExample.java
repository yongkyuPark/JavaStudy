package chapter11.exam05;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ThenApplyExample {
    public static void main(String[] args) {

        MyService service = new MyService();

        long started = System.currentTimeMillis();
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("thread1: " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 40;
        }).thenApply(r -> {
            System.out.println("thread2: " + Thread.currentThread().getName());
            int result = service.getData1();
            return r + result;
        }).thenApplyAsync(r -> {
            System.out.println("thread3: " + Thread.currentThread().getName());
            int result = service.getData2();
            return r + result;
        });

        int finalResult = cf.join();
        System.out.println("finalResult = " + finalResult);
        System.out.println("총 소요 시간:" + (System.currentTimeMillis() - started));

    }

    static class MyService {

        public int getData1() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 50;
        }

        public int getData2() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 60;
        }
    }
}
