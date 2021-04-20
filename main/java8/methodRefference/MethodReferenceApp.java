package main.java8.methodRefference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReferenceApp {

    public static void main(String[] args) {
        // Function<Integer, String> intToString = (i) -> "number";
        // UnaryOperator<String> hi = (s) -> "hi, " + s; // 이 함수는 Greeting.java에 있는 기능과 동일하다. 이를 간략하게 나타내자!

        Greeting greeting = new Greeting();

        // :: 두 개 있다면, 이것이 메서드 레퍼런스이다!
        // 특정 객체의 인스턴스 메소드 참조, 스태틱 메소드 참조
        UnaryOperator<String> hello = greeting::hello;
        UnaryOperator<String> hi = Greeting::hi;

        System.out.println(hello.apply("EHOTO"));
        System.out.println(hi.apply("EHOTO"));

        System.out.println();

        Supplier<Greeting> newGreeting = Greeting::new; // 여기서 객체가 만들어지진 않는다.
        Greeting mrGreeting = newGreeting.get(); // .get()을 해야 Greeting 인스턴스가 생성된다.

        UnaryOperator<String> mrHello = mrGreeting::hello;
        // UnaryOperator<String> mrHi = mrGreeting::hi; // static 함수는 메서드 레퍼런스 불가능!!

        System.out.println(mrHello.apply("EHOTO"));
        System.out.println(hi.apply("EHOTO"));

        System.out.println();

        // 생성자를 참조하는 방법
        Function<String, Greeting> ehotoGreeting = Greeting::new; // (1)
        Greeting ehoto = ehotoGreeting.apply("EHOTO");
        System.out.println(ehoto.getName());

        Supplier<Greeting> newEhotoGreeting = Greeting::new;    // (2)

        System.out.println();

        // 불특정 다수에 대해 참조하는 방법
        String[] names = {"keesun", "ehoto", "toby"};
        Arrays.sort(names, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        // Comparator가 자바 8부터는 Functional Interface로 변경되었기 때문에 축약하여 사용할 수 있다.

    }

}
