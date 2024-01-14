package chapter11.exam10;

import java.util.concurrent.CompletableFuture;

public class CompletedFutureExample {
    public static void main(String[] args) {

        CompletableFuture<String> cf = CompletableFuture.completedFuture("Hello World");

        CompletableFuture<Void> finalCf = cf.thenAccept(r -> {
            System.out.println("result: " + r);
        });
    }
}
