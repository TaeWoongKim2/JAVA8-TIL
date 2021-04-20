package main.java8.functionalInterface;

import java.util.function.*;

public class App {

    public static void main(String[] args) {
        // @FunctionalInterface
        RunSomething runSomething = () -> System.out.println("Hello, My name is EHOTO!");
        runSomething.doIt();

        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(10));

        // Lambda Interface
        Function<Integer, Integer> plus20 = (i) -> i + 20;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        System.out.println(plus20.apply(10));
        System.out.println(multiply2.apply(20));


        // 고차함수
        // x에 대해 10을 더하기 전에 곱하기 2를 하겠다!
        System.out.println(plus10.compose(multiply2).apply(10)); // 10 * 2 + 10
        // x에 대해 10을 더하고 곱하기 2를 하겠다!
        System.out.println(plus10.andThen(multiply2).apply(10)); // (10 + 10) * 2


        // BiFunction<T, U, R>
        BiFunction<Integer, String, String> numberString = (i, s) -> i + s;
        System.out.println(numberString.apply(1, "1"));


        // Consumer<T>
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(100);

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        Predicate<String> startsWithJava = (s) -> s.startsWith("java");
        Predicate<Integer> isEven = (i) -> i%2 == 0;
        System.out.println(startsWithJava.test("java is good!"));
        System.out.println(isEven.test(10));

        UnaryOperator<Integer> plus100 = (i) -> i + 100; // 입력값 결과값의 타입이 같은 경우,
        UnaryOperator<Integer> multiply3 = (i) -> i * 3;
        System.out.println(plus100.apply(10));
        System.out.println(multiply3.apply(10));


        // BiFunction의 특수한 타입 BinaryOperator
        BinaryOperator<Integer> numberString2 = (i, j) -> i + j;

        // 복잡한 함수형 인터페이스가 필요하다면, 새롭게 함수형 인터페이스를 정의해야겠지만,
        // 간단한 로직의 경우, Java에서 지원해주는 여러가지 함수형인터페이스를 사용할 수 있다.


    }

}
