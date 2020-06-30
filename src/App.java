import math.modifier.Const;
import math.modifier.Mutable;
import math.vector.Vector2;
import math.vector.modifier.MutableVector;
import render.texture.*;

public class App {
  public static void main(String[] args) {
    Texture texture = new Texture(TextureType.FLOAT, 40, 40, 3);
    texture.map((double u, double v, Color color) -> {
      MutableVector<Vector2> p = Mutable.of(new Vector2(u, v))
          .minus(new Vector2(0.5, 0.5));

      return (p.magnitude() < 0.25) ?
          new Color(1.0) : new Color(0.0);
    });

    printTexture(texture);
  }

  private static void printTexture(Texture texture) {
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
}
