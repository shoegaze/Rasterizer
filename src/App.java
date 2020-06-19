import math.Const;
import math.matrix.Matrix3_3;
import math.matrix.Matrix4_4;
import math.matrix.Scaling2D;
import math.vec.*;
import render.*;

public class App {
  public static void main(String[] args) {
    System.out.println(
      Vector3.ZERO
        .plus(new Vector3(1, 2, 3))
        .negate()
        .normalized()
        .negate());

    System.out.println(
      Vector2.RIGHT
        .dot(Vector2.UP));

    System.out.println(
      new Matrix4_4(1,  5,  8, 10,
                    11, 2,  6,  9,
                    14, 12, 3,  7,
                    16, 15, 13, 4).det());


    System.out.println(
      Matrix3_3.IDENTITY.dot(
        new Matrix3_3(1, 2, 3,
                      4, 5, 6,
                      7, 8, 9)));

    System.out.println(
      Const.of(
        new Matrix3_3(1, 4, 7,
                      2, 5, 8,
                      3, 6, 9))
      .dot(
        new Matrix3_3(1,  1,  2,
                      3,  5,  8,
                      13, 21, 34)));

    Scaling2D s = new Scaling2D(2, -1);
    System.out.println(
      s.dot(new Vector3(1, 1, 1)));

    TextureRGB<Byte> tex = new TextureRGB<>(Byte.class, 2, 3);
    tex.setPixelIndexed(0, 0, new PixelRGB<>((byte)0xff, (byte)0x00, (byte)0x00));
    tex.setPixelIndexed(1, 0, new PixelRGB<>((byte)0x00, (byte)0xff, (byte)0x00));
    tex.setPixelIndexed(0, 1, new PixelRGB<>((byte)0x00, (byte)0x00, (byte)0xff));
    tex.setPixelIndexed(1, 1, new PixelRGB<>((byte)0xff, (byte)0xff, (byte)0xff));

    System.out.println(tex.getPixelIndexed(0, 0));
    System.out.println(tex.getPixelIndexed(1, 0));
    System.out.println(tex.getPixelIndexed(0, 1));
    System.out.println(tex.getPixelIndexed(1, 1));

    TextureGrayscale<Float> texbw = new TextureGrayscale<>(Float.class, 10, 10);
    texbw.setPixelIndexed(0, 0, new PixelGrayscale<>(50000.0f));

    System.out.println(texbw.getPixelIndexed(0, 0));
    System.out.println(texbw.getPixelIndexed(1, 0));
  }
}
