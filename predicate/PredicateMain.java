package predicate;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class PredicateMain {
  public static void main(String[] args) {
    List<Apple> inventory = Arrays.asList(
      new Apple(80,"green"),
      new Apple(155, "green"),
      new Apple(120, "red")
    );

    List<Apple> greenApples = inventory
      .stream()
      .filter((Apple a) -> a.getColor().equals("green"))
      .collect(toList());
    System.out.println(Arrays.toString(greenApples.toArray()));

    List<Apple> notRedApples =  filterApples(inventory, (apple) -> isGreenApple(apple));
    System.out.println(Arrays.toString(notRedApples.toArray()));

    List<Apple> heavyApples =  filterApples(inventory, (apple) -> isHeavyApple(apple));
    System.out.println(Arrays.toString(heavyApples.toArray()));

    List<String> alphabetList = Arrays.asList("aaa", "abc", "bbb", "bbd", "ddd", "adb");
    Collections.sort(alphabetList, (s1, s2) -> s1.compareTo(s2));
    System.out.println(Arrays.toString(alphabetList.toArray()));

  }

  public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
    List<Apple> result = new ArrayList<>();
    for(Apple apple : inventory){
      if(p.test(apple)){
        result.add(apple);
      }
    }
    return result;
  }
  
  // 동작 파라미터들
  public static boolean isGreenApple(Apple apple) { return "green".equals(apple.getColor()); }
  public static boolean isHeavyApple(Apple apple) { return apple.getWeight() > 150; }
  
}
