package uk.co.openkappa.bitrules.matchers;

import org.junit.jupiter.api.Test;
import uk.co.openkappa.bitrules.masks.SmallMask;
import uk.co.openkappa.bitrules.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static uk.co.openkappa.bitrules.masks.SmallMask.contiguous;
import static uk.co.openkappa.bitrules.Mask.with;
import static uk.co.openkappa.bitrules.Mask.without;

public class LongNodeTest {


  @Test
  public void testGreaterThan() {
    LongMatcher.LongNode<SmallMask> node = build(100, Operation.GT);
    SmallMask mask = contiguous(100);
    assertTrue(node.apply(0L, mask.clone()).isEmpty());
    assertEquals(with(new SmallMask(), 0), node.apply(1L, mask.clone()));
  }


  @Test
  public void testGreaterThanOrEqual() {
    LongMatcher.LongNode<SmallMask> node = build(100, Operation.GE);
    SmallMask mask = contiguous(100);
    assertTrue(node.apply(-1L, mask.clone()).isEmpty());
    assertEquals(with(new SmallMask(), 0), node.apply(0L, mask.clone()));
    assertEquals(with(with(new SmallMask(), 0), 1), node.apply(10L, mask.clone()));
  }

  @Test
  public void testEqual() {
    LongMatcher.LongNode<SmallMask> node = build(100, Operation.EQ);
    SmallMask mask = contiguous(100);
    assertTrue(node.apply(-1L, mask.clone()).isEmpty());
    assertEquals(with(new SmallMask(), 0), node.apply(0L, mask.clone()));
    assertEquals(with(new SmallMask(), 1), node.apply(10L, mask.clone()));
  }


  @Test
  public void testLessThanOrEqual() {
    LongMatcher.LongNode<SmallMask> node = build(100, Operation.LE);
    SmallMask mask = contiguous(100);
    assertTrue(node.apply(1001, mask.clone()).isEmpty());
    assertEquals(mask, node.apply(0L, mask.clone()));
    assertEquals(without(mask.clone(), 0), node.apply(10L, mask.clone()));
  }

  @Test
  public void testLessThan() {
    LongMatcher.LongNode<SmallMask> node = build(100, Operation.LT);
    SmallMask mask = contiguous(100);
    assertTrue(node.apply(1001, mask.clone()).isEmpty());
    assertEquals(without(mask.clone(), 0), node.apply(0L, mask.clone()));
    assertEquals(without(without(mask.clone(), 0), 1), node.apply(10L, mask.clone()));
  }

  @Test
  public void testGreaterThanRev() {
    LongMatcher.LongNode<SmallMask> node = buildRev(100, Operation.GT);
    SmallMask mask = contiguous(100);
    assertTrue(node.apply(0L, mask.clone()).isEmpty());
    assertEquals(with(new SmallMask(), 0), node.apply(1L, mask.clone()));
  }

  @Test
  public void testBuildNode() {
    LongMatcher.LongNode<SmallMask> node = new LongMatcher.LongNode<>(Operation.EQ, new SmallMask());
    node.add(0, 0);
    assertEquals(contiguous(1), node.apply(0, contiguous(1)));
    node.add(0, 1);
    assertEquals(contiguous(2), node.apply(0, contiguous(2)));
  }

  @Test
  public void testGreaterThanOrEqualRev() {
    LongMatcher.LongNode<SmallMask> node = buildRev(100, Operation.GE);
    SmallMask mask = contiguous(100);
    assertTrue(node.apply(-1L, mask.clone()).isEmpty());
    assertEquals(with(new SmallMask(), 0), node.apply(0L, mask.clone()));
    assertEquals(with(with(new SmallMask(), 0), 1), node.apply(10L, mask.clone()));
  }

  @Test
  public void testEqualRev() {
    LongMatcher.LongNode<SmallMask> node = buildRev(100, Operation.EQ);
    SmallMask mask = contiguous(100);
    assertTrue(node.apply(-1L, mask.clone()).isEmpty());
    assertEquals(with(new SmallMask(), 0), node.apply(0L, mask.clone()));
    assertEquals(with(new SmallMask(), 1), node.apply(10L, mask.clone()));
  }


  @Test
  public void testLessThanOrEqualRev() {
    LongMatcher.LongNode<SmallMask> node = buildRev(100, Operation.LE);
    SmallMask mask = contiguous(100);
    assertTrue(node.apply(1001, mask.clone()).isEmpty());
    assertEquals(mask, node.apply(0L, mask.clone()));
    assertEquals(without(mask, 0), node.apply(10L, mask.clone()));
  }

  @Test
  public void testLessThanRev() {
    LongMatcher.LongNode<SmallMask> node = buildRev(100, Operation.LT);
    SmallMask mask = contiguous(100);
    assertTrue(node.apply(1001, mask.clone()).isEmpty());
    assertEquals(without(mask.clone(), 0), node.apply(0L, mask.clone()));
    assertEquals(without(without(mask.clone(), 0), 1), node.apply(10L, mask.clone()));
  }


  private LongMatcher.LongNode<SmallMask> build(int count, Operation relation) {
    LongMatcher.LongNode<SmallMask> node = new LongMatcher.LongNode<>(relation, new SmallMask());
    for (int i = 0; i < count; ++i) {
      node.add(i * 10, i);
    }
    return node.optimise();
  }

  private LongMatcher.LongNode<SmallMask> buildRev(int count, Operation relation) {
    LongMatcher.LongNode<SmallMask> node = new LongMatcher.LongNode<>(relation, new SmallMask());
    for (int i = count - 1; i >= 0; --i) {
      node.add(i * 10, i);
    }
    return node.optimise();
  }

}