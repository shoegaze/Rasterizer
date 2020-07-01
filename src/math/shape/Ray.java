package math;

import math.modifier.Const;
import math.vector.Vector3;
import math.vector.modifier.ConstVector;
import math.vector.modifier.NormalVector;

public class Ray {
  public ConstVector<Vector3> origin;
  public NormalVector<Vector3> direction;

  public Ray(Vector3 origin, NormalVector<Vector3> direction) {
    this.origin = Const.of(origin);
    this.direction = direction;
  }
}
