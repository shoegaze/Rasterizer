package render;

import render.texture.Color;
import render.texture.Texture;
import render.texture.TextureType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class RenderUtilities {
  private RenderUtilities() {
    throw new UnsupportedOperationException("This class cannot be instantiated");
  }


  public static void printTexture(Texture texture) {
    StringBuilder s = new StringBuilder(texture.height() * (texture.width()+1));

    for (int y = texture.height()-1; y >= 0; --y) {
      for (int x = 0; x < texture.width(); ++x) {
        Color c = texture.getColor(x, y);
        double l = c.luminance();

        s.append(switch ((int)(l * 10)) {
          case 0 -> ' ';
          case 1 -> '.';
          case 2 -> '_';
          case 3 -> '-';
          case 4 -> '=';
          case 5 -> '+';
          case 6 -> 'o';
          case 7 -> 'X';
          case 8 -> '#';
          case 9 -> '@';
          case 10 -> '%';
          default -> '?';
        });
      }

      s.append('\n');
    }

    System.out.print(s);
  }

  public static Texture openBmp(String path) {
    Texture texture = null;

    try {
      BufferedImage image = ImageIO.read(new File(path));
      // HACK: TextureType.DOUBLE covers all bases
      texture = new Texture(TextureType.DOUBLE, image.getWidth(), image.getHeight(), 3);

      // Apparently getRGB really means getARGB
      texture.map((int x, int y, Color color) ->
          Color.from(image.getRGB(x, image.getHeight()-1 - y)));

    } catch (IOException e) {
      e.printStackTrace();
    }

    return texture;
  }

  public static void writeBmp(Texture texture, String path) {
    BufferedImage image = new BufferedImage(
        texture.width(),
        texture.height(),
        BufferedImage.TYPE_INT_RGB);

    texture.foreach((int x, int y, Color color) ->
        image.setRGB(x, texture.height()-1 - y, color.getARGB()));

    try {
      ImageIO.write(image, "bmp", new File(path));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
