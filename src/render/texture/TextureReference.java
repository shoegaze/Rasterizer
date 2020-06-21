package render.texture;

import render.color.IColor;

public class TextureReference<N extends Number, E extends IColor<N>> {
  final Class<N> type;
  final Texture<N, E> target;
  final TextureRegion region;

  public TextureReference(Class<N> type, Texture<N, E> target, TextureRegion region) {
    this.type = type;
    this.target = target;
    this.region = region;
  }

  public TextureReference(Class<N> type, Texture<N, E> target) {
    this(type, target, new TextureRegion(0, 0, target.width(), target.height()));
  }

  public E getPixelIndexed(int i, int j) {
    return target.getPixelIndexed(region.iStart + i, region.jStart + j);
  }

  public void setPixelIndexed(int i, int j, E value) {
    target.setPixelIndexed(region.iStart + i, region.jStart + j, value);
  }

  // public <R extends Texture<N, E>> R asTexture(Class<R> type) {}
}