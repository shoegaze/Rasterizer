import math.vector.Vector2;
import render.RenderUtilities;
import render.texture.*;

public class App {
  public static void main(String[] args) {
    String imagesFolder = new java.io.File("images").getAbsolutePath();

    Texture texture1 = new Texture(TextureType.FLOAT, 100, 100, 3);

    // 0 <= m <= 1
    Graphics.drawLine(
        texture1,
        new Vector2(5, 5),
        new Vector2(25, 95));

    // 1 < m < +inf
    Graphics.drawLine(
        texture1,
        new Vector2(25, 95),
        new Vector2(50, 60));

    // -1 <= m < 0
    Graphics.drawLine(
        texture1,
        new Vector2(50, 60),
        new Vector2(95, 50));

    // -inf < m < -1
    Graphics.drawLine(
        texture1,
        new Vector2(95, 50),
        new Vector2(5, 5));

    RenderUtilities.writeBmp(texture1, imagesFolder.concat("/line.bmp"));
  }
}
