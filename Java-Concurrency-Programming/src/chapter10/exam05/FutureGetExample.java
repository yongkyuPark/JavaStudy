package chapter10.exam05;

import java.util.concurrent.*;

public class FutureGetExample {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Callable<Integer> callableTask = () -> {
            System.out.println("비동기 작업 시작..");
            Thread.sleep(2000);
            System.out.println("비동기 작업 완료");

            return 42;
        };

        Future<Integer> future = executorService.submit(callableTask);

        while (!future.isDone()) {
            System.out.println("작업을 기다리는 중..");
            Thread.sleep(500);
        }

        try {
            int result = future.get();
            System.out.println("result = " + result);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

    }
}
