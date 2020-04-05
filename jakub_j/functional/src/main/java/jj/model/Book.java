package jj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Comparator;
import java.util.function.Predicate;
import static jj.model.BookType.*;

@Data
@AllArgsConstructor
public class Book {
    private long numberOfPages;
    private String title;
    private BookType bookType;

    public static Predicate<Book> isScienceBook = t -> t.getBookType().equals(SCIENCE);
    public static Predicate<Book> hasMoreThan100Pages = t -> t.getNumberOfPages()>100;

    public static Comparator<Book> sortingByPages = Comparator.comparing(Book::getNumberOfPages);
    public static Comparator<Book> sortingByTitle = Comparator.comparing(Book::getTitle);
}


