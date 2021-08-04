package Hard;

import java.util.Arrays;

public class EditDistance {

  public static void main(String[] args) {
    System.out.println(minDistance("horse", "ore"));
  }

  public static int minDistance(String word1, String word2) {
    int[][] mem = new int[word1.length() + 1][word2.length() + 1];
    for (int[] x : mem) Arrays.fill(x, -1);
    return solve(word1, word2, 0, 0, mem);
  }

  private static int solve(String word1, String word2, int a, int b, int[][] mem) {
    if (a >= word1.length()) return word2.length() - b;
    if (b >= word2.length()) return word1.length() - a;

    if (mem[a][b] != -1) return mem[a][b];

    int way;

    if (word1.charAt(a) == word2.charAt(b)) {
      way = solve(word1, word2, a + 1, b + 1, mem);
    } else {
      way = 1 + Math.min(
        Math.min(
          solve(word1, word2, a + 1, b, mem),
          solve(word1, word2, a, b + 1, mem)
        ),
        solve(word1, word2, a + 1, b + 1, mem)
      );
    }

    mem[a][b] = way;

    return way;

  }
}
