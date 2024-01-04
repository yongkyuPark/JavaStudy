package chapter07.exam02;

import java.util.LinkedList;
import java.util.Queue;

class SharedQueue {

    private Queue<Integer> queue = new LinkedList<>();

    private int CAPACITY = 5;

    private final Object lock= new Object();

    public void produce(int item) throws InterruptedException {
        synchronized (lock) {
            while (queue.size() == CAPACITY) {
                System.out.println("큐가 가득 찼습니다. 생산 중지..");
                lock.wait();
            }
            queue.add(item);
            System.out.println("생산: " + item);
            lock.notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (queue.isEmpty()) {
                System.out.println("큐가 비었습니다. 소비 중지..");
                lock.wait();
            }
            int item = queue.poll();// 데이터를 하나씩 가져온다.
            System.out.println("소비: " + item);
            lock.notifyAll();
        }
    }

}

public class ProducerConsumerExample {

    public static void main(String[] args) {
        SharedQueue queue = new SharedQueue();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    queue.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "생산자").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    queue.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "소비자").start();
    }

}
