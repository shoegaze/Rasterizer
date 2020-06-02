package math.vec;

import java.util.Arrays;

public abstract class Vector {
  private double[] elements;

  protected Vector(double ...elements) {
    this.elements = elements.clone();
  }

  public abstract Vector copy();
  public abstract int getSize();

  public boolean equals(Vector rhs, double epsilon) {
    if (this.getClass() != rhs.getClass()) {
      return false;
    }

    for (int i = 0; i < getSize(); ++i) {
      if (Math.abs(this.getElement(i) - rhs.getElement(i)) > epsilon) {
        return false;
      }
    }

    return true;
  }

  public String toString() {
    String elems = Arrays.toString(elements);
    return "(" + elems.substring(1, elems.length()-1) + ")";
  }

  public double getElement(int i) {
    return elements[i];
  }

  public void setElement(int i, double value) {
    elements[i] = value;
  }
}
