import java.util.*;

public class Problem {
  Scanner scanner = new Scanner(System.in);

  int numDaysForScanning;
  int[] scores;
  Library[] libraries;

  public static void main(String[] args) {
    Problem p = new Problem();
    p.getInput();
  }

  public void bruteForce() {

  }

  public void getInput() {
    scores = new int[scanner.nextInt()];
    libraries = new Library[scanner.nextInt()];
    numDaysForScanning = scanner.nextInt();
    for (int i = 0; i < scores.length; i++) {
      scores[i] = scanner.nextInt();
    }

    for (int i = 0; i < libraries.length; i++) {
      int numBooks = scanner.nextInt();
      int signupLen = scanner.nextInt();
      int numBooksPerDay = scanner.nextInt();
      int[] books = new int[numBooks];
      for (int j = 0; j < books.length; j++) {
        books[j] = scanner.nextInt();
      }
      libraries[i] = new Library(signupLen, numBooksPerDay, books);
    }
  }

  class Library {
    int signupLen;
    int numBooksPerDay;
    int[] books;

    Library(int signupLen, int numBooksPerDay, int[] books) {
      this.signupLen = signupLen;
      this.numBooksPerDay = numBooksPerDay;
      this.books = books;
    }
  }
}


