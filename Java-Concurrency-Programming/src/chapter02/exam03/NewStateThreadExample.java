package chapter02.exam03;

public class NewStateThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("스레드 실행 중");
            }
        });

        System.out.println("스레드 상태: " + thread.getState());
    }
}
