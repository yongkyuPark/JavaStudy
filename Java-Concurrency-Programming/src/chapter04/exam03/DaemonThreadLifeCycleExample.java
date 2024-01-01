package chapter04.exam03;

public class DaemonThreadLifeCycleExample {

    public static void main(String[] args) throws InterruptedException {
        Thread userThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("사용자 스레드 실행 중..");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread daemonThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                    System.out.println("데몬 스레드 실행 중..");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

        userThread.join();

        // 데몬 스레드는 사용자 스레드가 모두 종료되면 종료된다.

        System.out.println("메인 스레드 종료");
    }
}
