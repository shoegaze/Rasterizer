package render.texture;

import math.vector.Vector2;

public final class Graphics {
  public static void drawLine(Texture target, Vector2 start, Vector2 end) {
    // Implementation of Bresenham's algorithm

    // Permute start and end s.t. start.x <= end.x
    if (end.x() < start.x()) {
      final Vector2 tmp = start.copy();
      start = end;
      end = tmp;
    }

    int dx = (int)(end.x() - start.x());
    int dy = (int)(end.y() - start.y());
    int epsilon = 0;

    // Distribute inner loops into separate branches to avoid branch mispredictions
    if (dy >= 0) {
      if (dy <= dx) {
        int y = (int)start.y();

        for (int x = (int)start.x(); x <= (int)end.x(); ++x) {
          target.setColor(x, y, new Color(1, 1, 1));

          epsilon += dy;
          if (2*epsilon >= dx) {
            epsilon -= dx;
            ++y;
          }
        }
      } else { // dy > dx
        int x = (int)start.x();

        for (int y = (int)start.y(); y <= (int)end.y(); ++y) {
          target.setColor(x, y, new Color(1, 1, 1));

          epsilon += dx;
          if (2*epsilon >= dy) {
            epsilon -= dy;
            ++x;
          }
        }
      }
    }
    else { // dy < 0
      if (dy >= -dx) {
        int y = (int)start.y();

        for (int x = (int)start.x(); x <= (int)end.x(); ++x) {
          target.setColor(x, y, new Color(1, 1, 1));

          epsilon += -dy;
          if (2*epsilon >= dx) {
            epsilon -= dx;
            --y;
          }
        }
      }
      else { // dy < -dx
        int x = (int)start.x();

        for (int y = (int)start.y(); y >= (int)end.y(); --y) {
          target.setColor(x, y, new Color(1, 1, 1));

          epsilon += dx;
          if (2*epsilon >= -dy) {
            epsilon += dy;
            ++x;
          }
        }
      }
    }
  }
}
