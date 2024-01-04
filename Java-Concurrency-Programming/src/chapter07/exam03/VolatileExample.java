package chapter07.exam03;

public class VolatileExample {
    // volatile 키워드 추가
   volatile boolean running = true;
//    boolean running = true;

    public void volatileTest() {
        new Thread(() -> {
            int count = 0;
            // 일반 변수의 경우 cpu 캐시에서 데이터를 가져오기 때문에
            // thread2에서 false로 바꿔도 반영되지 않아 무한루프에 빠진다
            // volatile 타입으로 주면 메모리에서 데이터를 바로 가져와 가시성이 확보된다.
            while (running) {
                /*try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
                count++;
            }
            System.out.println("Thread 1 종료. Count: " + count);
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            System.out.println("Thread 2 종료 중..");
            running = false;
        }).start();
    }

    public static void main(String[] args) {
        new VolatileExample().volatileTest();
    }
}