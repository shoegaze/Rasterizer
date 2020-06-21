package render.scene;

public class Camera extends RenderObject {
  private double fov;
  private double aspect;
  private double near;
  private double far;

  public Camera(String id, RenderObject parent) {
    super(id, parent);
  }
}
