package render.texture;

import math.modifier.Const;
import math.modifier.Mutable;
import math.vector.Vector2;
import math.vector.modifier.ConstVector;
import math.vector.modifier.MutableVector;

import javax.xml.stream.events.StartDocument;

public class TextureReference {
  private final Texture target;
  private final TextureRegion region;

  public TextureReference(Texture target, TextureRegion region) {
    this.target = target;
    this.region = region;

    // TODO: Assert region is contained in target
  }

  public Color getColor(int x, int y) {
    Vector2 start = region.getStart();

    return target.getColor(
        (int)start.x() + x,
        (int)start.y() + y);
  }

  public void setColor(int x, int y, Color color) {
    Vector2 start = region.getStart();

    target.setColor(
        (int)start.x() + x,
        (int)start.y() + y,
        color);
  }

  public void foreach(Texture.TextureMapIndexed process) {
    final Vector2 start = region.getStart();

    for (int y = 0; y < region.height(); ++y) {
      for (int x = 0; x < region.width(); ++x) {
        final Vector2 p = Mutable.of(new Vector2(x, y))
            .plus(start)
            .getVec();

        target.setColor(p.x(), p.y(),
            process.map(x, y,
                target.getColor((int)p.x(), (int)p.y())));
      }
    }
  }

  public void foreach(Texture.TextureMapUv process) {
    // TODO
  }

  public void map(Texture.TextureMapIndexed mapper) {
    // TODO
  }

  public void map(Texture.TextureMapUv mapper) {
    // TODO
  }

  public Texture toTexture() {
    Texture texture = new Texture(
        target.type(),
        region.width(),
        region.height(),
        target.channels());

    texture.map((int x, int y, Color color) -> getColor(x, y));

    return texture;
  }
}