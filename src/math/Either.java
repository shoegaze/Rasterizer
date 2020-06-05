package math;

public class Either<L, R> {
  public interface DoLeft<L> {
    void doLeft(L left);
  }

  public interface DoRight<R> {
    void doRight(R right);
  }

  public static <L, R> Either<L, R> fromLeft(L left) {
    return new Either<>(left, null);
  }

  public static <L, R> Either<L, R> fromRight(R right) {
    return new Either<>(null, right);
  }


  private L left;
  private R right;

  private Either(L left, R right) {
    if (left != null && right != null) {
      throw new IllegalArgumentException();
    }

    if (left != null) {
      this.left = left;
    }
    else if (right != null) {
      this.right = right;
    }
  }

  public Either<L, R> ifLeft(DoLeft<L> doLeft) {
    if (hasLeft()) {
      doLeft.doLeft(left);
    }

    return this;
  }

  public Either<L, R> ifRight(DoRight<R> doRight) {
    if (hasRight()) {
      doRight.doRight(right);
    }

    return this;
  }

  private boolean hasLeft() {
    return left != null;
  }

  private boolean hasRight() {
    return right != null;
  }
}
