package chapter07.exam04;

/**
 * 동적인 락의 순서에 따른 데드락 발생
 */
public class DeadlockDynamicOrderExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            methodWithLocks(lock1, lock2);
        });

        Thread thread2 = new Thread(() -> {
            methodWithLocks(lock2, lock1);
        });
        thread1.start();
        thread2.start();
    }

    private static void methodWithLocks(Object lockA, Object lockB) {

        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + ":  " + lockA + " 획득");

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + ":  " + lockB + " 획득");
            }
        }
    }
}