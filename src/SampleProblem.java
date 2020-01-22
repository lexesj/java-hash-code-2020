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
    List<Integer> ans = solveRepeatedGreedy();

    printAns(ans);

    System.out.println();
    System.out.println(getScore(ans));
  }

  List<Integer> solveGreedy() {
    return solveGreedy(pizzaSlices.length - 1);
  }

  int getScore(List<Integer> ans) {
    int sum = 0;
    for (int index : ans) {
      sum += pizzaSlices[index];
    }
    return sum;
  }

  List<Integer> solveGreedy(int startIndex) {
    int sum = 0;
    LinkedList<Integer> ans = new LinkedList<>();
    for (int i = startIndex; i >= 0; --i) {
      int numSlices = pizzaSlices[i];
      if (sum + numSlices <= sliceMax) {
        sum += numSlices;
        ans.addFirst(i);
      }
    }
    return ans;
  }

  List<Integer> solveRepeatedGreedy() {
    int maxScore = Integer.MIN_VALUE;
    List<Integer> bestAns = new LinkedList<>();
    for (int i = 0; i < pizzaSlices.length; i++) {
      int startIndex = pizzaSlices.length - i - 1;
      List<Integer> ans = solveGreedy(startIndex);
      int score = getScore(ans);
      System.out.println(score);
      if (score > maxScore) {
        maxScore = score;
        bestAns = ans;
      }
    }
    return bestAns;
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
