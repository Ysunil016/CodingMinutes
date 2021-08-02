package Medium;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}; // Expected - 49
    System.out.println(maxWaterContain(heights));
  }

  static int maxWaterContain(int[] heights) {
    int maxWater = 0;

    int left = 0;
    int right = heights.length - 1;

    while (left < right) {
      int width = right - left;
      int minHeight = Math.min(heights[left], heights[right]);
      maxWater = Math.max(maxWater, minHeight * width);

      if (heights[left] > heights[right]) {
        right--;
      } else {
        left++;
      }
    }

    return maxWater;
  }

}
