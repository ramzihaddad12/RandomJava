public class Item {
  private String name;
  private int relevance;
  private int cost;

  public Item(String name, int relevance, int cost) {
    this.name = name;
    this.relevance = relevance;
    this.cost = cost;
  }

  public String toString() {
    return String.format("name: %s, relevance: %d, and cost: %d", name, relevance, cost);
  }

  public String getName() {
    return name;
  }

  public int getRelevance() {
    return relevance;
  }

  public int getCost() {
    return cost;
  }
}
