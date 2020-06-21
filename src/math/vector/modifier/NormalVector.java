package math.vector.modifier;

import math.vector.Vector;

public final class NormalVector<T extends Vector> extends ConstVector<T> {
  public static <T extends Vector> NormalVector<T> from(T src) {
    return new ConstVector<T>(src).normalized();
  }

  protected NormalVector(T src) {
    super(src);
  }

  protected NormalVector(IVectorModifier<T, ?> src) {
    super(src);
  }

  @Override
  public String toString() {
    return "Normal:" + vec.toString();
  }

  @Override
  public double magnitude_2() {
    return 1;
  }

  @Override
  public NormalVector<T> normalized() {
    return this;
  }
}
