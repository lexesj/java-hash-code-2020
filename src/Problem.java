import java.util.*;

public class Problem {
  Scanner scanner = new Scanner(System.in);

  int numDaysForScanning;
  int[] scores;
  Library[] libraries;

  public static void main(String[] args) {
    Problem p = new Problem();
    p.bruteForce();
  }

  public void bruteForce() {
    getInput();
    LibraryAnswer a = new LibraryAnswer(0, new int[]{1, 2, 3});
    printAnswer(new LibraryAnswer[]{a});
  }

  public void printAnswer(LibraryAnswer[] answers) {
    System.out.println(answers.length);
    for (int i = 0; i < answers.length; i++) {
      LibraryAnswer answer = answers[i];
      System.out.println(answer.libraryNum + answer.books.length);
      for (int j = 0; j < answer.books.length; j++) {
        System.out.print(answer.books[j] + " ");
      }
      System.out.println();
    }
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

  class LibraryAnswer {
    int libraryNum;
    int[] books;

    LibraryAnswer(int libraryNum, int[] books) {
      this.libraryNum = libraryNum;
      this.books = books;
    }
  }
}


