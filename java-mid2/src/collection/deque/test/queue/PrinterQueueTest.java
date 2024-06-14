package collection.deque.test.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrinterQueueTest {

    public static void main(String[] args) {
        Queue<String> printQueue = new ArrayDeque<>();

        printQueue.offer("docs1");
        printQueue.offer("docs2");
        printQueue.offer("docs3");

        System.out.println("출력: " + printQueue.poll());
        System.out.println("출력: " + printQueue.poll());
        System.out.println("출력: " + printQueue.poll());
    }
}
