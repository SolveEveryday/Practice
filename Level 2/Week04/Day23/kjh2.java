import java.util.Stack;

class Solution {
  public int[] solution(int[] prices) {
    Stack<StockPrice> stack = new Stack<>();

    int[] seconds = new int[prices.length];
    for (int i = 0; i < prices.length; i++) {
      int currentPrice = prices[i];

      while (!stack.isEmpty() && stack.peek().price > currentPrice) {
        StockPrice stockPrice = stack.pop();

        seconds[stockPrice.idx] = i - stockPrice.idx;
      }

      stack.push(new StockPrice(currentPrice, i));
    }

    while (stack.size() > 0) {
      StockPrice stockPrice = stack.pop();

      seconds[stockPrice.idx] = prices.length - stockPrice.idx - 1;
    }

    return seconds;
  }
}

class StockPrice {
  public int price;
  public int idx;

  public StockPrice(int price, int idx) {
    this.price = price;
    this.idx = idx;
  }
}