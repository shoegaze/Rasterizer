import math.vec.*;

public class App {
  public static void main(String[] args) {
    Const<Vector3> cv3 = new Const<>(Vector3.ZERO);

    System.out.println(
      cv3
        .plus(new Vector3(1, 2, 3))
        .negate()
        .normalized()
        .negate()
        .getVec());

    System.out.println(
      new Const<>(Vector2.RIGHT)
        .dot(new Const<>(Vector2.UP).getVec())
    );
  }
}