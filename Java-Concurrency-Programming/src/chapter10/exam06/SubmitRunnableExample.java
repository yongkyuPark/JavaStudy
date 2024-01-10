package chapter10.exam06;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitRunnableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("비동기 작업 실행중");
            }
        });

        Future<Integer> future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("비동기 작업 실행중");
            }
        }, 100);

        Integer result = future.get();
        System.out.println("result = " + result);

        executorService.shutdown();
    }
}
