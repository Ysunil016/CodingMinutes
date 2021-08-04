package Medium;

public class MinPath {

  public static void main(String[] args) {
    System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
  }

  public static int minPathSum(int[][] grid) {
    int[][] mem = new int[grid.length + 1][grid[0].length + 1];
    return minPath(grid, 0, 0, mem);
  }

  private static int minPath(int[][] grid, int x, int y, int[][] mem) {
    int length = grid.length;
    int width = grid[0].length;

    if (x >= length || y >= width) return Integer.MAX_VALUE;
    if (x == length - 1 && y == width - 1) return grid[x][y];

    if (mem[x][y] != 0) return mem[x][y];

    mem[x][y] = grid[x][y] + Math.min(
      minPath(grid, x + 1, y, mem),
      minPath(grid, x, y + 1, mem)
    );

    return mem[x][y];
  }
}
