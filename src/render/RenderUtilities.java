package render;

import render.texture.Color;
import render.texture.Texture;
import render.texture.TextureType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class RenderUtilities {
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
      texture = new Texture(TextureType.DOUBLE, image.getWidth(), image.getHeight(), 3);
      texture.map((int x, int y, Color color) -> {
        int rgb = image.getRGB(x, y);
        return Color.from(
            (rgb >> 16) & 0xFF,
            (rgb >> 8) & 0xFF,
            (rgb >> 0) & 0xFF);
      });
    } catch (IOException e) {
      e.printStackTrace();
    }

    return texture;
  }

  public static void writeBmp(Texture texture, String path) {
    BufferedImage image = new BufferedImage(texture.width(), texture.height(), BufferedImage.TYPE_INT_RGB);
    texture.foreach((int x, int y, Color color) -> {
      int rgb = color.toAwtColor().getRGB();
      image.setRGB(x, y, rgb);
    });

    try {
      ImageIO.write(image, "bmp", new File(path));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private RenderUtilities() {}
}
