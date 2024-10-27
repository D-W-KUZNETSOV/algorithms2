import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomListTest {

  private IntegerList integerList;

  @BeforeEach
  void setUp() {
    integerList = new CustomList(
        5); // Предполагаем, что у нас есть реализация IntegerList под названием IntegerListImpl
  }

  @Test
  void testAdd() {
    assertEquals(Integer.valueOf(1), integerList.add(1));
    assertEquals(1, integerList.size());
  }

  @Test
  void testAddAtIndex() {
    integerList.add(1);
    integerList.add(0, 2);
    assertEquals(Integer.valueOf(2), integerList.get(0));
    assertEquals(2, integerList.size());
  }

  @Test
  void testSet() {
    integerList.add(1);
    assertEquals(Integer.valueOf(1), integerList.set(0, 2));
    assertEquals(Integer.valueOf(2), integerList.get(0));
  }

  @Test
  void testRemoveByValue() {
    integerList.add(1);
    integerList.add(2);
    assertEquals(Integer.valueOf(2), integerList.remove(Integer.valueOf(2)));
    assertEquals(1, integerList.size());
  }

  @Test
  void testRemoveByIndex() {
    integerList.add(1);
    integerList.add(2);
    assertEquals(Integer.valueOf(2), integerList.remove(1));
    assertEquals(1, integerList.size());
  }

  @Test
  void testContains() {
    integerList.add(1);
    integerList.add(2);
    assertTrue(integerList.contains(1));
    assertFalse(integerList.contains(3));
  }

  @Test
  void testIndexOf() {
    integerList.add(1);
    integerList.add(2);
    assertEquals(1, integerList.indexOf(2));
    assertEquals(-1, integerList.indexOf(3));
  }

  @Test
  void testLastIndexOf() {
    integerList.add(1);
    integerList.add(2);
    integerList.add(2);
    assertEquals(2, integerList.lastIndexOf(2));
    assertEquals(-1, integerList.lastIndexOf(3));
  }

  @Test
  void testGet() {
    integerList.add(1);
    assertEquals(Integer.valueOf(1), integerList.get(0));
  }

  @Test
  void testEquals() {
    IntegerList otherList = new CustomList(5);
    integerList.add(1);
    otherList.add(1);
    assertTrue(integerList.equals(otherList));
  }

  @Test
  void testSize() {
    assertEquals(0, integerList.size());
    integerList.add(1);
    assertEquals(1, integerList.size());
  }

  @Test
  void testIsEmpty() {
    assertTrue(integerList.isEmpty());
    integerList.add(1);
    assertFalse(integerList.isEmpty());
  }

  @Test
  void testClear() {
    integerList.add(1);
    integerList.clear();
    assertTrue(integerList.isEmpty());
  }

  @Test
  void testToArray() {
    integerList.add(1);
    integerList.add(2);
    Integer[] expectedArray = {1, 2};
    assertArrayEquals(expectedArray, integerList.toArray());
  }

  @Test
  void testGetAtInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> integerList.get(-1));
    assertThrows(IndexOutOfBoundsException.class, () -> integerList.get(0));
  }

  @Test
  void testRemoveAtInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> integerList.remove(-1));
    assertThrows(IndexOutOfBoundsException.class, () -> integerList.remove(0));
  }

  @Test
  void testAddNull() {
    assertThrows(IllegalArgumentException.class, () -> integerList.add(null));
  }

  @Test
  void testContainsNull() {
    assertThrows(IllegalArgumentException.class, () -> integerList.contains(null));
  }

  @Test
  void testAddAtInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> integerList.add(-1, 1));
    assertThrows(IndexOutOfBoundsException.class, () -> integerList.add(1, 1));
  }

  @Test
  void testSetAtInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> integerList.set(-1, 1));
    assertThrows(IndexOutOfBoundsException.class, () -> integerList.set(0, 1));
  }
}


