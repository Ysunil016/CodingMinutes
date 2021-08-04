package Medium;

public class NumberOfBsTree {

  public static void main(String[] args) {
    System.out.println(numTrees(10));
  }

  public static int numTrees(int n) {
    int[] nums = new int[n + 1];
    return solve(n, nums);
  }

  private static int solve(int n, int[] mem) {
    if (n <= 1) return 1;
    if (n == 2) return 2;

    if (mem[n] != 0) return mem[n];

    int ways = 0;
    for (int i = 1; i <= n; i++) {
      ways += solve(i - 1, mem) * solve(n - i, mem);
    }

    mem[n] = ways;

    return ways;
  }
}
