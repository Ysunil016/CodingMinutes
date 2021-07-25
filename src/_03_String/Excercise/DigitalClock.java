package _03_String.Excercise;

public class DigitalClock {

  public static void main(String[] args) {
    System.out.println(solve(1180));
  }

  private static String solve(int minutes) {
    int hour = minutes / 60;
    int min = minutes % 60;
    return hour + ":" + min;
  }
}
