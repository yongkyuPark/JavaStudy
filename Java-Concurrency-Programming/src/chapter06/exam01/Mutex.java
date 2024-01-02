package chapter06.exam01;

public class Mutex {

    private boolean lock = false;

    public synchronized void acquired() {
        while (lock) {
            try {
                wait();  // 스레드를 대기시킨다.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.lock = true;
    }

    public synchronized void release() {
        this.lock = false;
        this.notify();  // 스레드를 깨운다.
    }

}
