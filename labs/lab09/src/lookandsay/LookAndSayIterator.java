package lookandsay;

import java.math.BigInteger;
import java.util.NoSuchElementException;

/**
 * A LookAndSay iterator which will be able to go back
 * and forth in a sequence of BigIntegers.
 */

public class LookAndSayIterator implements RIterator<BigInteger> {
  private BigInteger curr;
  private BigInteger prev;
  private final BigInteger end;
  private static final BigInteger DEFAULT_SEED = new BigInteger("1");
  private static final BigInteger DEFAULT_MAX = new BigInteger("9".repeat(100));

  /**
   * A constructor for the iterator,
   * taking in a seed and a max value.
   *
   * @param curr the seed of the iterator.
   * @param end the max value of the iterator.
   */

  public LookAndSayIterator(BigInteger curr, BigInteger end) {
    if (curr.compareTo(end) >= 0) {
      throw new IllegalArgumentException("Starting seed should be less than end value");
    }

    if (curr.toString().contains("0")) {
      throw new IllegalArgumentException("Starting seed cannot contain zeroes");
    }

    if (curr.compareTo(new BigInteger("0")) <= 0) {
      throw new IllegalArgumentException("Starting seed cannot be negative");
    }
    this.prev = curr;
    this.curr = curr;
    this.end = end;
  }

  /**
   * A constructor for the iterator,
   * taking in a seed and having a max of 9 100s which is the default value for max.
   *
   * @param curr the seed of the iterator.
   */

  public LookAndSayIterator(BigInteger curr) {
    this(curr, DEFAULT_MAX);
  }

  /**
   * A default constructor for the iterator,
   * having a seed of 1 which is the default value,
   * and a max of 9 100s which is also the default value for max.
   */

  public LookAndSayIterator() {
    this(DEFAULT_SEED, DEFAULT_MAX);
  }

  private BigInteger runLengthEncoding(BigInteger number) {
    StringBuilder builder = new StringBuilder();
    String numString = number.toString();

    int count = 1;

    for (int i = 0; i < numString.length(); i++) {
      if (i + 1 < numString.length() && numString.charAt(i) == numString.charAt(i + 1)) {
        count++;
      }

      else {
        builder.append(Integer.toString(count)).append(Character.toString(numString.charAt(i)));
        count = 1;
      }

    }

    return new BigInteger(builder.toString());
  }

  private BigInteger reverseRunLengthEncoding(BigInteger number) {
    StringBuilder builder = new StringBuilder();
    String numString = number.toString();
    for (int i = 0; i < numString.length() - 1; i += 2) {
      int count = Integer.parseInt(String.valueOf(numString.charAt(i)));
      int value = Integer.parseInt(String.valueOf(numString.charAt(i + 1)));

      for (int j = 0; j < count; j++) {
        builder.append(value);
      }
    }
    return new BigInteger(builder.toString());
  }

  @Override
  public BigInteger prev() throws NoSuchElementException {
    if (!hasPrevious()) {
      throw new NoSuchElementException("Sequence has ended");
    }

    this.curr = this.prev;
    this.prev = reverseRunLengthEncoding(this.prev);
    return this.prev;
  }

  @Override
  public boolean hasPrevious() {
    return this.prev.toString().length() % 2 == 0
            && reverseRunLengthEncoding(this.prev).compareTo(end) < 0;
  }

  @Override
  public boolean hasNext() {
    return this.curr.compareTo(end) < 0;
  }

  @Override
  public BigInteger next() throws NoSuchElementException {
    if (!hasNext()) {
      throw new NoSuchElementException("Sequence has ended");
    }

    this.prev = this.curr;
    this.curr = runLengthEncoding(this.curr);
    return this.prev;
  }
}
