package render.scene;

import java.util.ArrayList;
import java.util.List;

public class RenderScene {
  // OctTree<RenderObject> scene;
  private final List<RenderObject> hierarchy = new ArrayList<>();
  private final List<LightSource> lights = new ArrayList<>();
  private final List<Camera> cameras = new ArrayList<>();

  public RenderScene() {
    //
  }

  // public RenderObject find(String id) {}
  // public void add(RenderObject obj, RenderObject parent) {}
  // public void add(RenderObject obj) {}
}