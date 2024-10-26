import java.util.Arrays;
import java.util.Objects;


public class CustomList implements IntegerList {

  private Integer[] items;
  private int size;

  public CustomList() {
    int DEFAULT_STORAGE_SIZE = 10;
    items = new Integer[DEFAULT_STORAGE_SIZE];
    size = 0;
  }

  public CustomList(int initialCapacity) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException("Размер массива должен быть больше нуля.");
    }
    this.items = new Integer[initialCapacity];
    this.size = 0;
  }

  @Override
  public Integer add(Integer item) {
    if (item == null) {
      throw new IllegalArgumentException("Элемент не может быть null.");
    }
    ensureCapacity();
    items[size++] = item;
    return item;
  }

  @Override
  public Integer add(int index, Integer item) {
    if (item == null) {
      throw new IllegalArgumentException("Элемент не может быть null.");
    }
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Индекс выходит за пределы.");
    }
    ensureCapacity();
    System.arraycopy(items, index, items, index + 1, size - index);
    items[index] = item;
    size++;
    return item;
  }

  @Override
  public Integer set(int index, Integer item) {
    if (item == null) {
      throw new IllegalArgumentException("Элемент не может быть null.");
    }
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Индекс выходит за пределы.");
    }
    Integer oldValue = items[index];
    items[index] = item;
    return oldValue;
  }

  @Override
  public Integer remove(Integer item) {
    int index = indexOf(item);
    if (index == -1) {
      throw new IllegalArgumentException("Элемент не найден.");
    }
    return remove(index);
  }

  @Override
  public Integer remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Индекс выходит за пределы.");
    }
    Integer removeditem = items[index];
    int numMoved = size - index - 1;
    if (numMoved > 0) {
      System.arraycopy(items, index + 1, items, index, numMoved);
    }
    items[--size] = null; // Удаление ссылки для сборщика мусора
    return removeditem;
  }

  @Override
  public boolean contains(Integer item) {
    if (item == null) {
      throw new IllegalArgumentException("Item cannot be null");
    }

    Integer[] storageCopy = toArray(); // Получаем копию массива
    Arrays.sort(storageCopy); // Сортируем копию массива
    return binarySearch(storageCopy, item) ; // Проверяем, найден ли элемент
  }


  @Override
  public int indexOf(Integer item) {
    for (int i = 0; i < size; i++) {
      if (item.equals(items[i])) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Integer item) {
    for (int i = size - 1; i >= 0; i--) {
      if (item.equals(items[i])) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public Integer get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Индекс выходит за пределы.");
    }
    return items[index];
  }

  @Override
  public boolean equals(IntegerList otherList) {
    if (otherList == null || this.size != otherList.size()) {
      return false;
    }
    for (int i = 0; i < size; i++) {
      if (!items[i].equals(otherList.get(i))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void clear() {
    for (int i = 0; i < size; i++) {
      items[i] = null;
    }
    size = 0;
  }

  @Override
  public Integer[] toArray() {
    return Arrays.copyOf(items, size);
  }

  private void ensureCapacity() {
    if (size >= items.length) {
      items = Arrays.copyOf(items, items.length * 2);
    }
  }

  @Override
  public String toString() {
    return "CustomList{" +
        "items=" + Arrays.toString(items) +
        ", size=" + size +
        '}';
  }

  private void sort(Integer[] storageCopy) {
    for (int i = 1; i < items.length; i++) {
      int temp = items[i];
      int j = i;
      while (j > 0 && items[j - 1] >= temp) {
        items[j] = items[j - 1];
        j--;
      }
      items[j] = temp;
    }

  }

  private boolean binarySearch(Integer[] arr, Integer items) {
    int min = 0;
    int max = arr.length - 1;

    while (min <= max) {
      int mid = (min + max) / 2;

      if (arr[mid].equals(items)) {
        return true;
      }

      if (items < arr[mid]) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return false;
  }


}








