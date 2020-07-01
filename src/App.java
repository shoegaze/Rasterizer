import math.modifier.Const;
import math.modifier.Mutable;
import math.vector.Vector2;
import math.vector.Vector3;
import math.vector.modifier.ConstVector;
import math.vector.modifier.MutableVector;
import render.RenderUtilities;
import render.texture.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class App {
  public static void main(String[] args) {
    Texture texture = new Texture(TextureType.FLOAT, 40, 40, 3);
    ConstVector<Vector3> eye = Vector3.FORWARD.times(5);

    texture.map((double u, double v, Color color) -> {
      double r = Mutable.of(new Vector2(u, v))
          .minus(new Vector2(0.5, 0.5))
          .magnitude();

      double intensity = (r < 0.25)? 1.0 : 0.0;

      return new Color(intensity);
    });

    RenderUtilities.writeBmp(texture, "C:/Users/bighead/Desktop/test.bmp");
//    RenderUtilities.printTexture(texture);
  }
}
