import java.util.List;
import java.util.Scanner;

public class SampleProblem {
  int sliceMax;
  int[] pizzaSlices;
  static Scanner scanner = new Scanner(System.in);

  void getInput() {
    sliceMax = scanner.nextInt();
    int len = scanner.nextInt();
    for (int i = 0; i < len; i++) {
      pizzaSlices[i] = scanner.nextInt();
    }
  }

  void printAns(List<Integer> nums) {
    System.out.println(nums.size());
    for (int num : nums) {
      System.out.println(num);
    }
  }
}
