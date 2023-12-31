package chapter04.exam01;

public class UncaughtExceptionHandlerExamle {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("스레드1 시작!");

            // 예기치 않은 예외 발생
            throw new RuntimeException("예기치 않은 예외!");
        });

        thread1.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(t.getName() + "에서 예외 발생 " + e);
        });

        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println("스레드2 시작!");

            // 예기치 않은 예외 발생
            throw new RuntimeException("예기치 않은 예외!");
        });

        thread2.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(t.getName() + "에서 예외 발생 했습니다. " + e);
        });

        thread2.start();
    }
}
