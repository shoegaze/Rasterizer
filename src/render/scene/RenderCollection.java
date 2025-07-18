package render.scene;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RenderCollection extends RenderObject {
  private List<RenderObject> objects = new ArrayList<>();
  private Set<String> ids = new HashSet<>();

  public RenderCollection(String id, RenderObject parent) {
    super(id, parent);
  }
}
