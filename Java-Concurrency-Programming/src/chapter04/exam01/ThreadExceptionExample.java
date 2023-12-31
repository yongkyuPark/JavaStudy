package chapter04.exam01;

public class ThreadExceptionExample {

    public static void main(String[] args) {

        try {
            new Thread(() -> {
                throw new RuntimeException("스레드 예외 발생");
            }).start();
        } catch (Exception e) {
            // 예외는 발생하나 예외처리는 되지 않는다. (외부에서 받을 수 없음)
            notify(e);
        }

    }

    private static void notify(Exception e) {
        System.out.println("관리자에게 알림:" + e);
    }
}
