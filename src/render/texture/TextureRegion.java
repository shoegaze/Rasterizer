package render.texture;

import math.modifier.Const;
import math.vector.Vector2;
import math.vector.modifier.ConstVector;

import java.util.Arrays;

// Describes a rectangular subregion of some texture space
public final class TextureRegion {
  private final ConstVector<Vector2> start;
  private final ConstVector<Vector2> end;

  public TextureRegion(Vector2 start, Vector2 end) {
    this.start = Const.of(start);
    this.end = Const.of(end);

    // verify 0 <= start <= end <= (width, height)
    if (start.x() < 0 || start.y() < 0 || width() < 0 || height() < 0) {
      throw new IllegalArgumentException();
    }
  }

  public Vector2 getStart() {
    return start.getVec().copy();
  }

  public Vector2 getEnd() {
    return end.getVec().copy();
  }

  public int width() {
    final Vector2 e = end.getVec();
    final Vector2 s = start.getVec();

    return (int)(e.x() - s.x());
  }

  public int height() {
    final Vector2 e = end.getVec();
    final Vector2 s = start.getVec();

    return (int)(e.y() - s.y());
  }

  public Vector2[] getPoints() {
    final Vector2 w = new Vector2(width(), 0);
    final Vector2 topRight = getEnd();
    final Vector2 topLeft = end.minus(w).getVec();
    final Vector2 bottomLeft = getStart();
    final Vector2 bottomRight = start.plus(w).getVec();

    return new Vector2[] {
        topRight,
        topLeft,
        bottomLeft,
        bottomRight
    };
  }

  public boolean hasPoint(Vector2 p) {
    final Vector2 e = end.getVec();
    final Vector2 s = start.getVec();

    return (s.x() <= p.x() && p.x() <= e.x()) &&
           (s.y() <= p.y() && p.y() <= e.y());
  }

  public boolean overlaps(TextureRegion region) {
    return Arrays.stream(getPoints()).anyMatch(region::hasPoint);
  }
}
