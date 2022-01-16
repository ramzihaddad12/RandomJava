import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class C1 {
  public static boolean[] isSubmatrixFull(int[][] numbers) {
    int n = numbers[0].length;
    boolean[] booleans = new boolean[n - 2];
    int[] nums = new int[10];
    int count = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if ( nums[numbers[i][j]] == 0) {
          count++;
        }
        nums[numbers[i][j]]++;
      }
    }

    if (count == 9) {
      booleans[0] = true;
    }

//    else {
//      booleans[0] = false;
//    }

    for (int j = 1; j < n - 2; j++) {

      //remove
      for (int row = 0; row < 3; row++) {
        nums[numbers[row][j - 1]]--;
        if (nums[numbers[row][j - 1]] == 0) {
          count--;
        }
      }

      //add
      for (int row = 0; row < 3; row++) {
        if (nums[numbers[row][j + 2]] == 0) {
          count++;
        }
        nums[numbers[row][j + 2]]++;
      }

      if (count == 9) {
        booleans[j] = true;
      }

//      else {
//        booleans[j] = false;
//      }
    }
    return booleans;
  }

  public static boolean[] isCharactersSame(String[] strings) {

    int n = strings.length;
    boolean[] booleans = new boolean[n - 1];

    for (int i = 0; i < n - 1; i++) {
      if (strings[i].charAt(0) == strings[i + 1].charAt(0) && strings[i].charAt(strings[i].length() - 1) == strings[i + 1].charAt(strings[i + 1].length() - 1)) {
        booleans[i] = true;
      }
//      else{
//        booleans[i] = false;
//      }
    }
    return booleans;
  }
  public static List<Integer> findPeaks(List<Integer> list) {
    List<Integer> res = new ArrayList<>();
    int n = list.size();
    for (int i = 0; i < n; i++) {
      //find peaks
      int size = list.size();
      int min = Integer.MAX_VALUE;
      int index = -1;
      for (int j = 0; j < size; j++) {
        if (j == 0 && j + 1 < size) {
          if (list.get(j) > list.get(j + 1) && min > list.get(j)) {
            min = list.get(j);
            index = j;
          }
        }

        else if (j == size - 1 && j - 1 >= 0) {
          if (list.get(size - 1) > list.get(j - 1) && list.get(j) < min) {
            min = list.get(j);
            index = j;
          }
        }

        else if (size == 1) {
          min = list.get(j);
          index = j;
        }

        else if (list.get(j) > list.get(j - 1) && list.get(j) > list.get(j + 1) && list.get(j) < min) {
          min = list.get(j);
          index = j;
        }
      }
      list.remove(index);
      res.add(min);
      //get Minimum peak
    }
    return res;
  }

  public static String textEditor(String[] operations) {
    String copied = "";
    Stack<String> result = new Stack<>();
    Stack<String[]> undo = new Stack<>();
    Stack<String[]> redo = new Stack<>();

    for (String s: operations) {
      String[] action = s.split(" ");
      if (action[0].equals("INSERT")) {
        result.push(action[1]);
        undo.push(action);
      }

      else if (action[0].equals("DELETE")) {
        String stringToBeEdited = result.peek();
        System.out.println("String to be edited " + stringToBeEdited);
        if (stringToBeEdited.length() == 1) {
          result.pop();
        }

        else{
          result.pop();
          result.push(stringToBeEdited.substring(0, stringToBeEdited.length() - 1));
        }
        undo.push(new String[] {action[0], stringToBeEdited.substring(stringToBeEdited.length() - 1)});
      }

      else if (action[0].equals("COPY")) {
        int index = Integer.parseInt(action[1]);
        String stringToBeCopied = result.peek();
        if (index < stringToBeCopied.length()) {
          copied = stringToBeCopied.substring(index);
        }
      }

      else if (action[0].equals("PASTE")) {
        if (!copied .equals(" ")) {
          result.push(copied);
          undo.push(new String[] {action[0], copied});
        }
      }

      else if (action[0].equals("UNDO")) {
        if (!undo.isEmpty()) {
          String[] actionToUndo = undo.pop();
          if (actionToUndo[0].equals("INSERT") ) {
            result.pop();
          }
          else if (actionToUndo[0].equals("DELETE")) {
            result.push(action[1]);
          }
          else if (actionToUndo[0] == "PASTE") {
            result.pop();
          }
          redo.push(actionToUndo);
        }
      }

      else if (action[0].equals("REDO")) {
        if (!redo.isEmpty()) {
          String[] actionToRedo = redo.pop();
          if (actionToRedo[0] == "INSERT") {
            result.push(actionToRedo[1]);
          }
          else if (actionToRedo[0] == "DELETE") {
            result.pop();
          }
          else if (actionToRedo[0] == "PASTE") {
            result.push(actionToRedo[1]);
          }
          undo.push(actionToRedo);
        }
      }
    }

    StringBuffer sb = new StringBuffer();
    List<String> stringList = new ArrayList<>();
    while(!result.isEmpty()) {
      stringList.add(result.pop());
    }
    for (int i = stringList.size() - 1; i >= 0; i--) {
      sb.append(stringList.get(i));
    }
    return sb.toString();
  }
  }
