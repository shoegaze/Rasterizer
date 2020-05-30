import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import math.*;

public class SimpleTest {
  @Test
  void dotProduct() {
    MutableVec2 v2 = new MutableVec2(0, 0);
  }

  @Test
  void euclidianLength() {

  }

  @Test
  void immutableAddition() {
    ImmutableVec2 v1 = new ImmutableVec2(0, 1);
    ImmutableVec2 v2 = new ImmutableVec2(-2, 3);
    MutableVec2 v3 = new MutableVec2(4, -5);

    assertNotEquals(v1.add(v2), v1);
    assertNotEquals(v2.add(v3), v2);
    assertTrue(v1.add(v2).equals(new MutableVec2(-2, 4)));
  }

  @Test
  void mutableAddition() {
    MutableVec2 v1 = new MutableVec2(0, 1);
    MutableVec2 v2 = new MutableVec2(-2, 3);

    assertEquals(v1.add(v2), v1);
    assertTrue(v1.equals(new ImmutableVec2(-2, 4)));
  }

  @Test
  void immutableSubtraction() {}

  @Test
  void mutableSubtraction() {}

  @Test
  void immutableTimes() {}

  @Test
  void mutableTimes() {}

  @Test
  void immutableDivide() {}

  @Test
  void mutableDivide() {}

  @Test
  void immutableNegate() {}

  @Test
  void mutableNegate() {}

  @Test
  void immutableNormalized() {}

  @Test
  void mutableNormalized() {}

  @Test
  @Disabled
  void mutation() {

  }

  @Test
  @Disabled
  void freezing() {

  }
}