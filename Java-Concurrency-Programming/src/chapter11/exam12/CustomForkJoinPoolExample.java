package chapter11.exam12;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class CustomForkJoinPoolExample {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;

        }

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        RecursiveTask<Integer> task = new CustomRecursiveTask(array, 0, array.length);
        int result = pool.invoke(task);

        System.out.println("result = " + result);
        System.out.println("pool = " + pool);
        System.out.println("stealing = " + pool.getStealCount());
    }
}
