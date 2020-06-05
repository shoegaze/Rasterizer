package render;

public class RenderObject {
  public RenderObject parent;

  public RenderObject(RenderObject parent) {
    this.parent = parent;
  }

  // public void render() {}
  // public Aabb getBoundingBox() {}
}