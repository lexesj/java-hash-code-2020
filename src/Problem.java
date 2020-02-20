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
    List<LibraryAnswer> answers = new ArrayList<>();
    for (int i = 0 ; i < libraries.length; i++) {
      Library lib = libraries[i];
      answers.add(new LibraryAnswer(i, lib.books));
    }
    printAnswer(answers);
  }

  public void printAnswer(List<LibraryAnswer> answers) {
    System.out.println(answers.size());
    for (int i = 0; i < answers.size(); i++) {
      LibraryAnswer answer = answers.get(i);
      System.out.println(answer.libraryNum + " " + answer.books.length);
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
      libraries[i] = new Library(signupLen, numBooksPerDay, books, 0, i);
    }
  }

  class Library {
    int signupLen;
    int numBooksPerDay;
    int score;
    int libraryNum;
    int[] books;

    Library(int signupLen, int numBooksPerDay, int[] books, int score, int libraryNum) {
      this.score = score;
      this.libraryNum = libraryNum;
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


