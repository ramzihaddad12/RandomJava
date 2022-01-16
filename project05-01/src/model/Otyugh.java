package model;

/**
 * A type of monster called Otyugh, that is able to eat
 * the player, and gets his/hear health decreased by half health
 * when shot by an arrow.
 */
public class Otyugh implements Monster {
  private Health health;

  /**
   * A constructor for the Otyugh monster.
   */
  public Otyugh() {
    this.health = Health.FULL_HEALTH;
  }

  /**
   * A copy constructor for the Otyugh monster.
   */
  public Otyugh(Monster monster) {
    if (monster == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    this.health = monster.getHealth();
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
