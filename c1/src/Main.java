import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    int[][] numbers = {{1, 2, 3, 2, 5, 7}, {4, 5, 6, 1, 7, 6}, {7, 8, 9, 4, 8, 3}};
    boolean[] res = C1.isSubmatrixFull(numbers);

    for (int i = 0; i < res.length; i++) {
      System.out.println(res[i]);
    }

    String[] words = {"abcd", "abdd" , "da" ,"dd"};
    boolean[] res1 = C1.isCharactersSame(words);

    for (int i = 0; i < res1.length; i++) {
      System.out.println(res1[i]);
    }

    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(5);
    list.add(3);
    list.add(7);
    list.add(2);
    List<Integer> res2 = C1.findPeaks(list);
    for (int i = 0; i < res2.size(); i++) {
      System.out.println(res2.get(i));
    }

    List<Integer> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(9);
    list2.add(7);
    list2.add(8);
    list2.add(2);
    list2.add(6);
    List<Integer> res22 = C1.findPeaks(list2);
    for (int i = 0; i < res22.size(); i++) {
      System.out.println(res22.get(i));
    }

    String[] operations = {"INSERT Da", "COPY 0", "UNDO", "PASTE", "PASTE", "COPY 2", "PASTE", "PASTE", "DELETE", "INSERT aaam"}; //, "INSERT aaam"

    System.out.println(C1.textEditor(operations));



  }
}
