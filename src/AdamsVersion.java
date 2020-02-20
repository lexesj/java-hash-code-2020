import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

public class Problem {
    Scanner scanner = new Scanner (System.in);

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
        int totalTime = 0;
        while(totalTime<numDaysForScanning) {
            for (int i = 0; i < libraries.length; i++) {
                Library lib = libraries[i];
                if (lib != null) {
                    int sum = 0;
                    Iterator<Book> iter = lib.books.iterator();
                    int numOfBooksToSubmit = (numDaysForScanning - totalTime - lib.signupLen) * lib.numBooksPerDay;
                    while (numOfBooksToSubmit > 0 && iter.hasNext()) {
                        sum += iter.next().score;
                    }
                    sum /= lib.signupLen;
//      lib.score = (1d / lib.signupLen) * lib.numBooksPerDay;
                    lib.score = sum;
                    if (lib.used)
                        lib.score=-1;
                }
            }
            Arrays.sort(libraries, Collections.reverseOrder(Comparator.comparing((Library lib) -> lib.score)));
            totalTime += libraries[0].signupLen;
            Library lib = libraries[0];
            int numOfBooksToSubmit = (numDaysForScanning -totalTime)*lib.numBooksPerDay;
            ArrayList <Book> books = new ArrayList<>();
            Iterator <Book> iter = lib.books.iterator();
            while(numOfBooksToSubmit>0 && iter.hasNext()) {
                books.add(iter.next());
                numOfBooksToSubmit--;
            }
            lib.booksToSubmit=books;
            libraries[0].used=true;
            for(Library lib2 : libraries) {
                if(lib2!=null) {
                    for (Book book : books) {
                        lib2.books.remove(book);
                    }
                }
            }
            answers.add(new LibraryAnswer(lib.libraryNum,books));
        }
        printAnswer(answers);
    }

    public void printAnswer(List<LibraryAnswer> answers) {
        System.out.println(answers.size());
        for (int i = 0; i < answers.size(); i++) {
            LibraryAnswer answer = answers.get(i);
            System.out.println(answer.libraryNum + " " + answer.books.size());
            for (int j = 0; j < answer.books.size(); j++) {
                System.out.print(answer.books.get(j).bookID + " ");
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
            TreeSet <Book> books = new TreeSet ();
            for (int j = 0; j < numBooks; j++) {
                int x = scanner.nextInt();
                books.add(new Book(scores[x],x));
            }
            libraries[i] = new Library(signupLen, numBooksPerDay, books, 0, i);
        }
    }

    class Library {
        int signupLen;
        int numBooksPerDay;
        double score;
        int libraryNum;
        TreeSet books;
        ArrayList <Book> booksToSubmit;
        boolean used =false;
        Library(int signupLen, int numBooksPerDay, TreeSet <Book> books, double score, int libraryNum) {
            this.score = score;
            this.libraryNum = libraryNum;
            this.signupLen = signupLen;
            this.numBooksPerDay = numBooksPerDay;
            this.books = books;
        }
    }
    class Book implements Comparable <Book>{
        int score;
        int bookID;
        Book(int score, int bookID) {
            this.score=score;
            this.bookID=bookID;
        }
        public int compareTo  (Book other) {
            if(this.score>other.score)
                return -1;
            if(this.bookID==other.bookID)
                return 0;
            return 1;
        }
    }

    class LibraryAnswer {
        int libraryNum;
        ArrayList <Book> books;

        LibraryAnswer(int libraryNum, ArrayList <Book> books) {
            this.libraryNum = libraryNum;
            this.books = books;
        }
    }
}


