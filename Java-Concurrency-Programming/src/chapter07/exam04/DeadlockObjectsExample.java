package chapter07.exam04;

/**
 * 각 스레드가 락을 획득하고 있는 상태에서 서로의 락을 획득하려고 할때 서로 대기하여 데드락이 발생
 */
public class DeadlockObjectsExample {
    public static void main(String[] args) {

        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        Thread thread1 = new Thread(() -> {
            resourceA.methodA(resourceB);
        });

        Thread thread2 = new Thread(() -> {
            resourceB.methodB(resourceA);
        });

        thread1.start();
        thread2.start();
    }
}

class ResourceA {

    public synchronized void methodA(ResourceB resourceB) {
        System.out.println(Thread.currentThread().getName() + ": methodA 실행");
        try {
            Thread.sleep(100);  // 각 메소드에 지연을 추가하여 데드락 가능성 높임
        } catch (InterruptedException e) {}
        resourceB.methodB2();
    }

    public synchronized void methodA2() {
        System.out.println(Thread.currentThread().getName() + ": methodA2 실행");
    }
}

class ResourceB {

    public synchronized void methodB(ResourceA resourceA) {
        System.out.println(Thread.currentThread().getName() + ": methodB 실행");
        try {
            Thread.sleep(100);  // 각 메소드에 지연을 추가하여 데드락 가능성 높임
        } catch (InterruptedException e) {}
        resourceA.methodA2();
    }

    public synchronized void methodB2() {
        System.out.println(Thread.currentThread().getName() + ": methodB2 실행");
    }
}