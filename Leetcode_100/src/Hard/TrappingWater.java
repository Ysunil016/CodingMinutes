package Hard;

public class TrappingWater {

  public static void main(String[] args) {
    int trappedWater = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    System.out.println(trappedWater);
  }

  public static int trap(int[] height) {

    int[] leftRight = new int[height.length];
    int[] rightLeft = new int[height.length];

    for (int i = 1; i < height.length; i++) {
      leftRight[i] = Math.max(height[i - 1], leftRight[i - 1]);
    }

    for (int i = height.length - 2; i >= 0; i--) {
      rightLeft[i] = Math.max(height[i + 1], rightLeft[i + 1]);
    }


    int totalWater = 0;
    for (int i = 0; i < height.length; i++) {
      int minHeight = Math.min(leftRight[i], rightLeft[i]);
      totalWater += height[i] > minHeight ? 0 : minHeight - height[i];
    }

    return totalWater;
  }
}
