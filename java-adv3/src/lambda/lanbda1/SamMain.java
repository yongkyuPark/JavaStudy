package lambda.lanbda1;

public class SamMain {

    public static void main(String[] args) {
        SamInterface samInterface = () -> {
            System.out.println("sam");
        };
        samInterface.run();

        // 컴파일 오류
        /*NotSamInterface notSamInterface = () -> {
            System.out.println("not sam");
        };

        notSamInterface.go();
        notSamInterface.run();*/
    }
}
