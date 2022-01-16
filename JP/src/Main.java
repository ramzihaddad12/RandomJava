import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
      String str  = "Hello\n" +
              "World\n" +
              "\n" +
              "My\n" +
              "Name\n" +
              "Is\n" +
              "Zancrow";
    System.out.println(makeCamelCase(str));

    System.out.println(getPairs(new int[] {3, 5, 1, 7, 8, 10, 62, 13}));
  }

  public static String makeCamelCase(String string) {
    StringBuilder stringBuilder = new StringBuilder();
    String[] array = string.split("\\r\\n");
    boolean isFirstLetter = true;
    for (String str: array) {
      if (isFirstLetter) {
        stringBuilder.append(Character.toLowerCase(str.charAt(0)));
        if (str.length() > 1) stringBuilder.append(str.substring(1));
        isFirstLetter = false;
      }
      else{
        stringBuilder.append(Character.toUpperCase(str.charAt(0)));
        if (str.length() > 1) stringBuilder.append(str.substring(1));
      }

      if (str.equals(" ")) {
        isFirstLetter = true;
      }

    }

    return stringBuilder.toString();

  }

  public static int getPairs(int[] numbers) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num: numbers) {
      map.put(getNumberOfOnes(num) , map.getOrDefault(getNumberOfOnes(num), 0) + 1);
    }
    int sum = 0;

    for ( Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int x = entry.getValue();
      sum += x * (x - 1) * 0.5;
    }

    return sum;
  }

  public static int getNumberOfOnes(int n)
  {
    int count = 0;
    String binary = Integer.toBinaryString(n);
    for(int i=0;i<binary.length();i++)
    {
      if (binary.charAt(i) == '1')
      {
        count += 1;
      }
    }
    return count;
  }
}
