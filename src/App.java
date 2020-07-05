import math.modifier.Const;
import math.modifier.Mutable;
import math.vector.Vector3;
import math.vector.modifier.ConstVector;
import math.vector.modifier.NormalVector;
import render.RenderUtilities;
import render.texture.*;

public class App {
  public static void main(String[] args) {
    Texture texture = new Texture(TextureType.FLOAT, 400, 400, 3);

    // Camera
    ConstVector<Vector3> eye = Vector3.BACKWARD.times(5);
    double near = 0.1;
    // Light
    ConstVector<Vector3> lo = Const.of(new Vector3(4, 4, 4));
    double lPower = 300;
    // Sphere
    ConstVector<Vector3> co = Vector3.ZERO;
    double cr = 2;

    texture.map((double u, double v, Color color) -> {
      // UV to world position
      NormalVector<Vector3> dir = eye
          .plus(Vector3.FORWARD.times(near))
          .plus(
              // TODO: Proper camera transform
              Mutable.of(new Vector3(-(u-0.5), v-0.5, 0))
                  .divide(near)
                  .getVec())
          .normalized();

      // Ray-Sphere intersection test
      ConstVector<Vector3> delta = eye.minus(co);
      final double b = 2*dir.dot(delta);
      final double c = delta.magnitude_2() - cr*cr;
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

      final double r_2 = l.magnitude_2();
      final double intensity = lPower * l.normalized().dot(n) / (4*Math.PI * r_2);

      return new Color(intensity);
    });

    String imagesFolder = new java.io.File("./images").getAbsolutePath();
    String spherePath = imagesFolder.concat("/sphere.bmp");
    RenderUtilities.writeBmp(texture, spherePath);

    Texture texture1 = RenderUtilities.openBmp(spherePath);
    texture1.map((double u, double v, Color color) -> (color.luminance() > 1e-4) ?
        color : new Color(1, 0, 1));
    RenderUtilities.writeBmp(texture1, imagesFolder.concat("/sphere-1.bmp"));
  }
}
