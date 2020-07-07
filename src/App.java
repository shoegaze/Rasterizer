import math.modifier.Const;
import math.modifier.Mutable;
import math.vector.Vector;
import math.vector.Vector2;
import math.vector.Vector3;
import math.vector.modifier.ConstVector;
import math.vector.modifier.NormalVector;
import render.RenderUtilities;
import render.texture.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {
  public static void main(String[] args) {
    Texture texture = new Texture(TextureType.FLOAT, 400, 400, 3);

    // Camera
    ConstVector<Vector3> eye = Vector3.BACKWARD.times(5);
    double focus = 0.05;
    double near = 0.01;
    // Light
    ConstVector<Vector3> lo = Const.of(new Vector3(4, 4, -4));
    double lPower = 500;
    // Sphere
    ConstVector<Vector3> co = Vector3.ZERO;
    double cr = 2;

    texture.map((double u, double v, Color color) -> {
      // UV to world position
      NormalVector<Vector3> dir = eye
          .plus(Vector3.FORWARD.times(near))
          .plus(
              // TODO: Proper camera transform
              Mutable.of(new Vector3(u-0.5, v-0.5, 0))
                  .times(focus/near)
                  .getVec())
          .normalized();

      // Ray-Sphere intersection test
      ConstVector<Vector3> delta = eye.minus(co);
      final double b = 2*dir.dot(delta);
      final double c = delta.length_2() - cr*cr;
      final double D = b*b - 4*c;

      if (D < 0) {
        return new Color(0.0);
      }

      final double t = Math.min(
          2*c / (-b - Math.sqrt(D)),
          2*c / (-b + Math.sqrt(D)));

      // Light calculation
      ConstVector<Vector3> p = eye.plus(dir.times(t));
      ConstVector<Vector3> l = lo.minus(p);
      NormalVector<Vector3> n = p.minus(co).normalized();

      final double r_2 = l.length_2();
      final double intensity = lPower * -l.normalized().dot(n) / (4*Math.PI * r_2);

      return new Color(intensity);
    });

    String imagesFolder = new java.io.File("./images").getAbsolutePath();
    String spherePath = imagesFolder.concat("/sphere.bmp");
    RenderUtilities.writeBmp(texture, spherePath);

    Texture texture1 = RenderUtilities.openBmp(spherePath);
    texture1.map((double u, double v, Color color) -> (color.luminance() > 0) ?
        color : new Color(1, 0, 1));
    RenderUtilities.writeBmp(texture1, imagesFolder.concat("/sphere-1.bmp"));

    TextureReference ref = new TextureReference(
        texture,
        new TextureRegion(
          new Vector2(0, 0),
          new Vector2(400, 400)));

    Texture texture2 = ref.toTexture();
    RenderUtilities.writeBmp(texture2, imagesFolder.concat("/sphere-slice.bmp"));

    Texture texture3 = new Texture(TextureType.FLOAT, 2, 2, 3);
    texture3.setColor(0, 0, new Color(0, 0, 0));
    texture3.setColor(1, 0, new Color(1, 0, 0));
    texture3.setColor(0, 1, new Color(0, 0, 1));
    texture3.setColor(1, 1, new Color(1, 1, 1));

    RenderUtilities.writeBmp(texture3, imagesFolder.concat("/orientation-test.bmp"));
  }
}
