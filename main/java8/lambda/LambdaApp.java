package main.java8.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class LambdaApp {

    public static void main(String[] args) {

        LambdaApp app = new LambdaApp();

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        BinaryOperator<Integer> sum = (a, b) -> a + b;
        // 앞에 선언한 제너릭 타입으로 인식을 하기 때문에 파라미터에 타입은 생략이 가능하다.

        app.printNewLine();
        app.run();


    }

    private void run() {
        int baseNumber = 10;

//        로컬 클래스에서 baseNumber 참조
//        class LocalClass {
//            void printBaseNumber() {
//                int baseNumber = 11;
//                System.out.println(baseNumber); // 11
//            }
//        }

//        익명 클래스에서 baseNumber 참조
//        Consumer<Integer> intergerConsumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer baseNumber) { // 이 스코프로 전달되는 파라미터로 대체 된다.
//                System.out.println(baseNumber);
//            }
//        };
        /*
            자바 8부터는 변수에 final을 생략할 수 있는 경우가 있다. 그 조건은 아래와 같다.
            - 해당 변수가 사실상 final인 경우. final이라는 키워드는 없지만 이 변수를 어디서도 변경하지 않는 경우. (=effective final)

            그러면, 로컬/익명 클래스와 람다의 차이점은 무엇일까?
            - 로컬/익명 클래스는 쉐도윙이다.
                - 로컬와 익명 클래스는 사실상 새로운 스코프이기 때문에 쉐도윙이 일어난다.
            - 람다는 쉐도윙이 안 된다.
                - 람다는 새로운 스코프 생성이 아닌 동일한 스코프 이기 때문에 쉐도윙이 일어나지 않는다.
                - 파라미터 명이 겹치면 컴파일 에러가 발생한다.
        */
        // 람다
        // IntConsumer printNumberPlus10 = (i) -> System.out.println(i + baseNumber);
        IntConsumer printNumberPlus10 = (i) -> {
            System.out.println(i + baseNumber);
        };

        printNumberPlus10.accept(10);

        // baseNumber++ effective final이 아니라면, 더 이상 람다에서는 참조해서 쓸수 없다.
    }

    private void printNewLine() {
        System.out.println("== New Example ===================================");
    }

}
