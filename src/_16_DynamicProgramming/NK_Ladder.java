package _16_DynamicProgramming;

import java.util.Arrays;

public class NK_Ladder {
  public static void main(String[] args) {
    int ladderSize = 4;
    int maxJump = 3;

    System.out.println(ways(ladderSize, maxJump));
    System.out.println();

    int[] mem = new int[ladderSize + 1];
    Arrays.fill(mem, -1);
    System.out.println(ways(ladderSize, maxJump, mem));
    System.out.println();
    System.out.println(ways2(ladderSize, maxJump));
    System.out.println();
    System.out.println(ways3(ladderSize, maxJump));
  }

  // O(Exponential)
  static int ways(int ladderSize, int maxJump) {
    if (ladderSize == 0) return 1;
    if (ladderSize < 0) return 0;

    int ways = 0;
    for (int jump = 1; jump <= maxJump; jump++) {
      ways += ways(ladderSize - jump, maxJump);
    }

    return ways;
  }

  // O(NK - TD) - Recursive
  static int ways(int ladderSize, int maxJump, int[] mem) {
    if (ladderSize == 0) return 1;
    if (ladderSize < 0) return 0;

    if (mem[ladderSize] != -1) return mem[ladderSize];

    mem[ladderSize] = 0;
    for (int jump = 1; jump <= maxJump; jump++) {
      mem[ladderSize] += ways(ladderSize - jump, maxJump);
    }

    return mem[ladderSize];
  }

  // O(NK - BU)
  static int ways2(int ladderSize, int maxJump) {
    if (ladderSize <= 1) return 1;

    int[] dp = new int[ladderSize + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= ladderSize; i++) {
      int counter = i;
      while (counter >= 0 && counter >= i - maxJump) {
        dp[i] += dp[counter];
        counter--;
      }
    }

    return dp[ladderSize];
  }

  // O(N)
  static int ways3(int ladderSize, int maxJump) {
    if (ladderSize <= 1) return 1;

    int[] dp = new int[ladderSize + 1];
    dp[0] = 1;
    dp[1] = 1;

    int sum = 1;
    for (int i = 2; i <= maxJump; i++) {
      dp[i] = sum + dp[i - 1];
      sum = dp[i];
    }

    for (int i = maxJump + 1; i <= ladderSize; i++) {
      dp[i] = 2 * dp[i - 1] - dp[i - maxJump - 1];
    }

    return dp[ladderSize];
  }

}
