import render.texture.*;

public class App {
  public static void main(String[] args) {
//    System.out.println(
//      Vector3.ZERO
//        .plus(new Vector3(1, 2, 3))
//        .negate()
//        .normalized()
//        .negate());
//
//    System.out.println(
//      Vector2.RIGHT
//        .dot(Vector2.UP));
//
//    System.out.println(
//      new Matrix4_4(1,  5,  8, 10,
//                    11, 2,  6,  9,
//                    14, 12, 3,  7,
//                    16, 15, 13, 4).det());
//
//
//    System.out.println(
//      Matrix3_3.IDENTITY.dot(
//        new Matrix3_3(1, 2, 3,
//                      4, 5, 6,
//                      7, 8, 9)));
//
//    System.out.println(
//      Const.of(
//        new Matrix3_3(1, 4, 7,
//                      2, 5, 8,
//                      3, 6, 9))
//      .dot(
//        new Matrix3_3(1,  1,  2,
//                      3,  5,  8,
//                      13, 21, 34)));
//
//    Scaling2D s = new Scaling2D(2, -1);
//    System.out.println(
//      s.dot(new Vector3(1, 1, 1)));

//    System.out.println(new Color(0.5, 0, 1).getInt(0));
//      System.out.println(new Color((byte)Byte.MAX_VALUE, (byte)0, (byte)Byte.MIN_VALUE));

//    Texture tex = new Texture(TextureType.INT, 2, 2, 3);
//    tex.map((double u, double v, Color color) ->
//        new Color((int)(Integer.MAX_VALUE*u), (int)(Integer.MIN_VALUE), (int)(Integer.MAX_VALUE*v)));
//    tex.foreach((double u, double v, Color color) ->
//        System.out.println("("+u+", "+v+"): " + color));

    Texture texbw = new Texture(TextureType.FLOAT, 40, 40, 3);
    texbw.map((double u, double v, Color color) -> new Color(u, 0, v));
    texbw.foreach((int x, int y, Color color) -> {
      System.out.println("(" + x + ", " + y + "): " + color);
    });
  }
}
