package render.texture;

public class TextureRegion {
  public final int iStart;
  public final int jStart;
  public final int iEnd;
  public final int jEnd;

  public TextureRegion(int iStart, int jStart, int iEnd, int jEnd) {
    // verify 0 <= start <= end <= (width, height)
    if (iStart < 0 || jStart < 0 || iEnd < iStart || jEnd < jStart) {
      throw new IllegalArgumentException();
    }

    this.iStart = iStart;
    this.jStart = jStart;
    this.iEnd = iEnd;
    this.jEnd = jEnd;
  }

  public int getWidth() {
    return iEnd - iStart;
  }

  public int getHeight() {
    return jEnd - jStart;
  }

  // public boolean hasPoint(int i, int j) {}
  // public boolean overlaps(TextureRegion region) {}
}