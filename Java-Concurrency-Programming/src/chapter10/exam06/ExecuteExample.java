package chapter10.exam06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            System.out.println("비동기 작업 실행");
        });

        /*new Thread(() -> {
            System.out.println("비동기 작업 실행");
        }).start();*/

        executorService.shutdown();

    }
}
