package dungeon;

/**
 * A type of monster called Otyugh.
 */
public class Otyugh implements Monster {
  private Health health;

  /**
   * A constructor for the Otyugh monster.
   */
  public Otyugh() {
    this.health = Health.FULL_HEALTH;
  }


  @Override
  public Health getHealth() {
    Health copyHealth = this.health;
    return copyHealth;
  }

  @Override
  public void decreaseHealth() {
    if (health == null) {
      throw new IllegalArgumentException("New health cannot be null");
    }

    if (this.health == Health.ZERO_HEALTH) {
      throw new IllegalArgumentException("Health already zero");
    }

    else if (this.health == Health.FULL_HEALTH) {
      this.health = Health.HALF_HEALTH;
    }

    else if (this.health == Health.HALF_HEALTH) {
      this.health = Health.ZERO_HEALTH;
    }
  }
}
