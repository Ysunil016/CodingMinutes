package Medium;

import java.util.Arrays;

public class CoinChange {

  public static void main(String[] args) {
    int[] denos = new int[]{1, 3, 5, 6, 7};
    System.out.println(coinChange(denos, 50));
  }

  public static int coinChange(int[] coins, int amount) {
    int[][] mem = new int[coins.length + 1][amount + 1];
    for (int[] x : mem) Arrays.fill(x, -1);
    int finalValue = minCoin(coins, amount, 0, mem);
    return finalValue >= infinite ? -1 : finalValue;
  }

  static int infinite = 1000000;

  private static int minCoin(int[] coins, int amount, int idx, int[][] mem) {
    if (idx >= coins.length || amount < 0) return infinite;
    if (amount == 0) return 0;

    if (mem[idx][amount] != -1) return mem[idx][amount];

    mem[idx][amount] = Math.min(
      1 + minCoin(coins, amount - coins[idx], idx, mem),
      minCoin(coins, amount, idx + 1, mem)
    );

    return mem[idx][amount];
  }
}
