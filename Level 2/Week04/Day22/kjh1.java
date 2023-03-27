import java.util.*;

class Solution {
  public int[] solution(long begin, long end) {
    List<Long> maxDivisors = new ArrayList<>();

    for (long i = begin; i <= end; i++) {
      long maxDivisor = getMaxDivisor(i);
      maxDivisors.add(maxDivisor);
    }

    return maxDivisors.stream().mapToInt(i -> i.intValue()).toArray();
  }

  public int getMaxDivisor(long num) {
    if (num == 1)
      return 0;

    int availableMax = (int) Math.floor(Math.sqrt(num));

    for (int i = 2; i <= availableMax; i++) {
      if (num % i == 0)
        return (int) (num / i);
    }
    return 1;
  }
}