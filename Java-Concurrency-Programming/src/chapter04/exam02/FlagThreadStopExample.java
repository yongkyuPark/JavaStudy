package chapter04.exam02;

public class FlagThreadStopExample {

    //private volatile static boolean running = true;
    private static boolean running = true;

    public static void main(String[] args) {

        new Thread(() -> {
            int count = 0;
            while (running) {
                try {
                    // 컨텍스트 스위칭이 일어나면 cpu 캐시를 비운다
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
            }
            System.out.println("스레드 1 종료, count:" + count);
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("스레드 2 종료");
            running = false;
        }).start();
    }
}
