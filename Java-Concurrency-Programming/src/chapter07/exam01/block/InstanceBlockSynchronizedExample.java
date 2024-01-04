package chapter07.exam01.block;

import chapter07.exam01.method.InstanceStaticMethodSynchronizedExamples;

public class InstanceBlockSynchronizedExample {

    private int count = 0;

    private Object lockObject = new Object();

    public void incrementBlockThis() {
        synchronized (this) {
            count++;
            System.out.println(Thread.currentThread().getName() + " 가 This 에 의해 블록 동기화 함 :" + count);
        }
    }

    public void incrementBlockLockObject() {
        synchronized (lockObject) {
            count++;
            System.out.println(Thread.currentThread().getName() + " 가 LockObject 에 의해 블록 동기화 함 :" + count);
        }
    }

    public static void main(String[] args) {

        InstanceBlockSynchronizedExample examples = new InstanceBlockSynchronizedExample();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                examples.incrementBlockThis();
            }
        }, "스레드 1");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                examples.incrementBlockThis();
            }
        }, "스레드 2");

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                examples.incrementBlockLockObject();
            }
        }, "스레드 3");

        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                examples.incrementBlockLockObject();
            }
        }, "스레드 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // 각기 다른 두 모니터가 하나의 공유변수를 사용하면 동기화에 문제가 발생한다.

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("최종값:" + examples.count);

    }

}
