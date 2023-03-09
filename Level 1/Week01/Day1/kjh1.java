import java.util.*;

class Solution {
  public int solution(int n) {
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);

    for (int i = 2; i <= n; i++) {
      if (isPrime[i] == false)
        continue;

      for (int j = i + i; j <= n; j += i) {
        isPrime[j] = false;
      }
    }

    int primeCount = 0;
    for (int i = 2; i <= n; i++) {
      if (isPrime[i])
        primeCount++;
    }

    return primeCount;
  }
}