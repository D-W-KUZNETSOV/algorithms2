import static java.util.Collections.sort;

public class Main {

  public static void main(String[] args) {
    IntegerList integerList = new CustomList();
    integerList.add(7);
    integerList.add(6);
    integerList.add(3);
    System.out.println(integerList);
    integerList.add(3, 7);
    System.out.println(integerList);
    integerList.contains(2);



  }
}


