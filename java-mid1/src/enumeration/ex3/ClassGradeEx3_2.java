package enumeration.ex3;


public class ClassGradeEx3_2 {

    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();



        // enum 생성 불가
        /*Grade grade = new Grade();
        int result = discountService.discount(grade, price);
        System.out.println("newClassGrade 등급의 할인 금액: " + result); */
    }
}
