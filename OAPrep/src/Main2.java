//import java.util.ArrayList;
//import java.util.List;
//
//public class Main2 {
//  public static void main(String[] args) {
//    List<String> strings = new ArrayList<>();
//    strings.add("abba");
//    strings.add("abca");
//    List<Integer> result = findValidDiscountCoupons(strings);
//    System.out.println(result.toString());
//    System.out.println(numberOfDecreasingSubarrays(new int[] {4,3,5,4,3}));
//  }
//
//  public static List<Integer> findValidDiscountCoupons(List<String> discounts) {
//    List<Integer> result = new ArrayList<>();
//
//    for (String s: discounts) {
//      if (isValid(s, 0, s.length() - 1)) {
//        result.add(1);
//      }
//
//      else{
//        result.add(0);
//      }
//    }
//    return result;
//  }
//
//  public static int isValid(String s, int start, int end) {
//    if (start > end) {
//      return 1;
//    }
//
//    int checkIndex = start + 1;
//
//    while (checkIndex < s.length()) {
//      if (s.charAt(start) == s.charAt(checkIndex) && isPalindrome(s, start, checkIndex) && isValid(s, checkIndex + 1, end)){
//        return 1;
//      }
//
//      checkIndex += 2;
//    }
//
//    if (s.charAt(start) == s.charAt(end)) {
//      return isValid(s, start + 1, end - 1);
//    }
//
//    return false;
//  }
//
//  public static int numberOfDecreasingSubarrays(int[] arr) {
//    //ratings = [4,3,5,4,3] answer = 9
//    int count = 0;
//    int left = 0;
//    int right = 0;
//
//    for (int i = 0; i < arr.length; i++) {
//      left = i;
//      right = i;
//
//      while (i < arr.length - 1&& arr[i] - arr[i + 1] == 1) {
//        i++;
//        right = i;
//      }
//      int lengthOfTriangle = right - left + 1;
//      count += (lengthOfTriangle) * (lengthOfTriangle + 1) / 2;
//    }
//    return count;
//  }
//}
