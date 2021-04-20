package predicate;

public class Apple {
  private String color;
  private int weight;

  public Apple(int weight, String color) {
    this.weight = weight;
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String toString() {
    return String.format("a %s apple weighting %dg", color, weight);
  }
}
