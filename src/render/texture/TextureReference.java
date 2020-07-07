package render.texture;

import math.vector.Vector2;

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
        target.height()-1 - ((int)start.y() + y));
  }

  public void setColor(int x, int y, Color color) {
    Vector2 start = region.getStart();

    target.setColor(
        (int)start.x() + x,
        (int)start.y() + y,
        color);
  }

  public void foreach(Texture.TextureMapIndexed process) {
    // TODO
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