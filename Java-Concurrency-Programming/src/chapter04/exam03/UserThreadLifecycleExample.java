package chapter04.exam03;

public class UserThreadLifecycleExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("사용자 스레드 1 실행 중..");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("사용자 스레드 1 종료");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("사용자 스레드 2 실행 중..");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("사용자 스레드 2 종료");
            }
        });

        thread1.start();
        thread2.start();

        // 모든 사용자 스레드가 종료되어야 어플리케이션이 종료가 된다.

        //thread1.join();
        //thread2.join();

        System.out.println("모든 사용자 스레드가 종료되었습니다. 메인 스레드 종료");
    }
}
