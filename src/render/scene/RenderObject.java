package render.scene;

import math.matrix.transform.Transform3D;

public class RenderObject {
  private Class<? extends RenderObject> type;
  private final String id;
  private RenderObject parent;
  private Transform3D transform;

  public RenderObject(String id, RenderObject parent) {
    this(RenderObject.class, id, parent);
  }

  protected RenderObject(Class<? extends RenderObject> type, String id, RenderObject parent) {
    this.type = type;
    this.id = id;
    this.parent = parent;
    // ...
  }
}
