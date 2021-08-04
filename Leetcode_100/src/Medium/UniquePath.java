package Medium;

public class UniquePath {

  public static void main(String[] args) {
    int[][] mem = new int[21][21];
    System.out.println(uniquePaths(20, 20, 0, 0, mem));
  }

  // Exponential
  private static int uniquePaths(int m, int n, int x, int y) {
    if (x == m - 1 && y == n - 1) return 1;
    if (x >= m || y >= n) return 0;

    return uniquePaths(m, n, x + 1, y) + uniquePaths(m, n, x, y + 1);
  }

  // Quadratic
  private static int uniquePaths(int m, int n, int x, int y, int[][] mem) {
    if (x == m - 1 && y == n - 1) return 1;
    if (x >= m || y >= n) return 0;

    if (mem[x][y] != 0) return mem[x][y];

    mem[x][y] = uniquePaths(m, n, x + 1, y, mem) + uniquePaths(m, n, x, y + 1, mem);

    return mem[x][y];
  }
}
