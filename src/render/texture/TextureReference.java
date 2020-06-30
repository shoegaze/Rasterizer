package render.texture;

public class TextureReference {
  final TextureType type;
  final Texture target;
  final TextureRegion region;

  public TextureReference(TextureType type, Texture target, TextureRegion region) {
    this.type = type;
    this.target = target;
    this.region = region;
  }

  public TextureReference(TextureType type, Texture target) {
    this(type, target, new TextureRegion(0, 0, target.width(), target.height()));
  }

  public Color getColor(int i, int j) {
    return target.getColor(region.iStart + i, region.jStart + j);
  }

  public void setColor(int i, int j, Color value) {
    target.setColor(region.iStart + i, region.jStart + j, value);
  }

  // public Texture asTexture(TextureType type) {}
}