package Medium;

public class RotateImage {
  public static void main(String[] args) {
    int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    rotate(arr);

    int row = arr.length;
    int col = arr[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void rotate(int[][] matrix) {
    // Reverse and Transpose
    int row = matrix.length;
    int col = matrix[0].length;

    for (int i = 0; i < row; i++) {
      for (int j = i; j < col; j++) {
        int swap = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = swap;
      }
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col / 2; j++) {
        int swap = matrix[i][j];
        matrix[i][j] = matrix[i][col - j - 1];
        matrix[i][col - j - 1] = swap;
      }
    }

  }
}
