import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SampleProblem {
  int sliceMax;
  int[] pizzaSlices;
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    SampleProblem sp = new SampleProblem();
    sp.getInput();
    sp.solve();
  }

  void solve() {
    List<Integer> ans = solveGreedy();

    printAns(ans);
  }

  List<Integer> solveGreedy() {
    int sum = 0;
    LinkedList<Integer> ans = new LinkedList<>();
    for (int i = pizzaSlices.length - 1; i >= 0; --i) {
      int numSlices = pizzaSlices[i];
      if (sum + numSlices <= sliceMax) {
        sum += numSlices;
        ans.addFirst(i);
      }
    }

    return ans;
  }

  void getInput() {
    sliceMax = scanner.nextInt();
    int len = scanner.nextInt();
    pizzaSlices = new int[len];
    for (int i = 0; i < pizzaSlices.length; i++) {
      pizzaSlices[i] = scanner.nextInt();
    }
  }

  void printAns(List<Integer> nums) {
    System.out.println(nums.size());
    int i = 0;
    for (int num : nums) {
      if (i == 0) System.out.print(num);
      else System.out.print(" " + num);
      i++;
    }
  }
}
