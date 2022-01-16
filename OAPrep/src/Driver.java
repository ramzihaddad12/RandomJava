public class Driver {
//  public static int numberOfSubstringsWithKDistinctCharacters(String string, int k) {
//    //Count no. of substrings with exactly k distinct letters.
//    int result = 0;
////    int[] count = new int[26];
//
//    for (int i = 0; i < string.length() - 1; i++) {
//      int numberOfDistinctCharactersInSubString = 0;
//      int[] count = new int[26];
//
//      for (int j = i; j < string.length(); j++) {
//        if (count[string.charAt(j) - 'a'] == 0) {
//          numberOfDistinctCharactersInSubString++;
//        }
//
//        count[string.charAt(j) - 'a']++;
//
//        if (numberOfDistinctCharactersInSubString == k) {
//          result++;
//        }
//
//        else if (numberOfDistinctCharactersInSubString > k) {
//          break;
//        }
//      }
//    }
//    return result;
//  }
  public static int getTotalNumberOfDistinctCharactersInSubstring(String string) {
    int result = 0;

    for (int i = 0; i < string.length(); i++) {
      int[] count = new int[26];
      int numberOfDistinctCharactersInSubstring = 0;
      for (int j = i; j < string.length(); j++) {
        if (count[string.charAt(j) - 'a'] == 0) {
          numberOfDistinctCharactersInSubstring++;
        }
        count[string.charAt(j) - 'a']++;
        result += numberOfDistinctCharactersInSubstring;

      }

    }
    return result;
  }

  public static int findRating(int[] nums) {
    int result = nums.length;

    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if(nums[j] < nums[j - 1]) {
          result++;
        }
      }
      System.out.println("Iteration #" + i + "The result is = " + result);
    }
    return result;
  }

  public static String getAlphabetToText(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    int i;
    for (i = 0; i < s.length(); i++) {
      int count = 1;
      while (i < (s.length() - 1) && s.charAt(i) == s.charAt(i + 1)) {
        count++;
        i++;
      }

      if (s.charAt(i) - 'a'<= 8) {
        stringBuilder.append(s.charAt(i) - 'a' + 1);
        if (count != 1) {
          stringBuilder.append("(" + count + ")");
        }
      }

      else{
        stringBuilder.append(s.charAt(i) - 'a' + 1);
        stringBuilder.append('#');
        if (count != 1) {
          stringBuilder.append("(" + count + ")");
        }
      }
    }
    System.out.println(" i" + i);
    return stringBuilder.toString();

  }

  public static void main(String[] args) {
    System.out.println(getTotalNumberOfDistinctCharactersInSubstring("test"));
    System.out.println(findRating(new int[] {4,3,5,4,3}));
    System.out.println(getAlphabetToText("abzx"));
    System.out.println(getAlphabetToText("aabccc"));
    System.out.println(getAlphabetToText("bajj"));
    System.out.println(getAlphabetToText("wwxyzwww"));

  }
}
