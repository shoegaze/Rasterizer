import math.matrix.ConstMatrix;
import math.matrix.Matrix3_3;
import math.matrix.Matrix4_4;
import math.vec.*;

public class App {
  public static void main(String[] args) {
    ConstVector<Vector3> cv3 = new ConstVector<>(Vector3.ZERO);

    System.out.println(
      cv3
        .plus(new Vector3(1, 2, 3))
        .negate()
        .normalized()
        .negate()
        .getVec());

    System.out.println(
      Vector2.RIGHT
        .dot(Vector2.UP.getVec())
    );

    System.out.println(new Matrix4_4(1,  5,  8,  10,
                                     11, 2,  6,  9,
                                     14, 12, 3,  7,
                                     16, 15, 13, 4).det());


    System.out.println(Matrix3_3.IDENTITY.dot(new Matrix3_3(1, 2, 3,
                                                            4, 5, 6,
                                                            7, 8, 9)));

    System.out.println(new ConstMatrix<>(
      new Matrix3_3(1, 4, 7,
                    2, 5, 8,
                    3, 6, 9)).dot(
      new Matrix3_3(1,  1,  2,
                    3,  5,  8,
                    13, 21, 34)));

  }
}