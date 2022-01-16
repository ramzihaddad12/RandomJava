import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//https://leetcode.com/discuss/interview-question/1412479/amazon-online-assessment-fetchitemstodisplay
public class Main {
  public static void main(String[] args) {
    List<Item> items = new ArrayList<>();
    items.add(new Item("item1",10,15));
    items.add(new Item("item2",3,4));
    items.add(new Item("item3",17,8));

    System.out.println(fetchItemsToDisplay(items, 1, 0, 2, 1));
  }

  public static List<String> fetchItemsToDisplay(List<Item> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber){
    int factor = sortOrder == 0 ? 1 : -1;

    if (sortParameter == 0) {
      Collections.sort(items, new Comparator<Item>() {
        public int compare(Item i1, Item i2) {
          return factor * i1.getName().compareTo(i2.getName());
        }
      });
    }

    else if (sortParameter == 1) {
      Collections.sort(items, new Comparator<Item>() {
        public int compare(Item i1, Item i2) {
          return factor * (i1.getRelevance() - i2.getRelevance());
        }
      });
    }

    else if (sortParameter == 2) {
      Collections.sort(items, new Comparator<Item>() {
        public int compare(Item i1, Item i2) {
          return factor * (i1.getCost() - i2.getCost());
        }
      });
    }

    //check what page
    List<String> itemsOnPage = new ArrayList<>();
    int startIndex = itemsPerPage * pageNumber;
    int numOfItems = 1;
    while (numOfItems <= itemsPerPage && startIndex < items.size()) {
      itemsOnPage.add(items.get(startIndex).toString());
      startIndex++;
      numOfItems++;
    }

    return itemsOnPage;

  }
}
