import java.util.*;
class Book {

  private int bookId;
  private String title;
  private String author;

  public Book(int bookId, String title, String author) {
    this.bookId = bookId;
    this.title = title;
    this.author = author;
  }

  public int getBookId() {
    return bookId;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public String toString() {
    return (
      "Book{" +
      "bookId=" +
      bookId +
      ", title='" +
      title +
      '\'' +
      ", author='" +
      author +
      '\'' +
      '}'
    );
  }
}

public class Library_Management_System {

  public static Book linearSearch(List<Book> books, String title) {
    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        return book;
      }
    }
    return null;
  }

  public static Book binarySearch(List<Book> books, String title) {
    int low = 0;
    int high = books.size() - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      Book midBook = books.get(mid);
      int comparison = midBook.getTitle().compareToIgnoreCase(title);

      if (comparison == 0) {
        return midBook;
      } else if (comparison < 0) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    List<Book> books = new ArrayList<>();
    books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
    books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
    books.add(new Book(3, "1984", "George Orwell"));
    books.add(new Book(4, "Pride and Prejudice", "Jane Austen"));
    books.add(new Book(5, "The Catcher in the Rye", "J.D. Salinger"));

    // Perform Linear Search
    String searchTitle = "1984";
    Book foundBook = linearSearch(books, searchTitle);
    if (foundBook != null) {
      System.out.println("Linear Search: Book found - " + foundBook);
    } else {
      System.out.println("Linear Search: Book not found");
    }

    // Sort books by title for binary search
    Collections.sort(
      books,
      new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
          return b1.getTitle().compareToIgnoreCase(b2.getTitle());
        }
      }
    );

    // Perform Binary Search
    foundBook = binarySearch(books, searchTitle);
    if (foundBook != null) {
      System.out.println("Binary Search: Book found - " + foundBook);
    } else {
      System.out.println("Binary Search: Book not found");
    }
  }
}
