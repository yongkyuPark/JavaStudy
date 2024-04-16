package enumeration.ex2;

public class ClassGradeEx2_2 {

    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();

        // 새로 만든 객체이기 때문에 동작하지 않는다.
        /*ClassGrade newClassGrade = new ClassGrade();
        int result = discountService.discount(newClassGrade, price);
        System.out.println("newClassGrade 등급의 할인 금액: " + result); */
    }
}
