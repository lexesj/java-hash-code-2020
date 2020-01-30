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
  }

  List<Integer> solveGreedy() {
    return solveGreedy(pizzaSlices.length - 1, -1);
  }

  int getScore(List<Integer> ans) {
    int sum = 0;
    for (int index : ans) {
      sum += pizzaSlices[index];
    }
    return sum;
  }

  List<Integer> solveGreedy(int startIndex, int ignoreIndex) {
    int sum = 0;
    LinkedList<Integer> ans = new LinkedList<>();
    for (int i = startIndex; i >= 0; --i) {
      if (ignoreIndex != -1 && ignoreIndex == i) continue;
      int numSlices = pizzaSlices[i];
      if (sum + numSlices <= sliceMax) {
        sum += numSlices;
        ans.addFirst(i);
      }
    }
    return ans;
  }

  /** Solves the problem using greedy algorithm repeatedly */
  List<Integer> solveRepeatedGreedy() {
    List<Integer> bestAns = solveGreedy();
    int maxScore = getScore(bestAns);
    int lastIndex = pizzaSlices.length - 1;
    for (int i = 0; i < pizzaSlices.length; i++) {
      int startIndex = pizzaSlices.length - i - 1;
      List<Integer> changeStart = solveGreedy(startIndex, -1);
      List<Integer> skipIndex = solveGreedy(lastIndex, i);
      int changeStartScore = getScore(changeStart);
      int skipIndexScore = getScore(skipIndex);
      if (changeStartScore > maxScore) {
        maxScore = changeStartScore;
        bestAns = changeStart;
      }
      if (skipIndexScore > maxScore) {
        maxScore = skipIndexScore;
        bestAns = skipIndex;
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
