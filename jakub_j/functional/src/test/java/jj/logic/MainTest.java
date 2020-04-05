package jj.logic;

import jj.model.Book;
import jj.model.RandomList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    public static List<Book> listOfBooks;

    @BeforeAll
    public static void createResource(){
        listOfBooks = RandomList.getRandomList(150);
    }

    @Test
    @DisplayName("Should cut in half book title")
    void manageBooks() {
        //given
        String bookTitle = listOfBooks.get(0).getTitle();
        String expected = bookTitle.substring(0, bookTitle.length()/2);
        //when
        List<Book> resultList = Main.manageBooks(s->s.substring(0, s.length()/2), listOfBooks);
        //then
        assertEquals(expected, resultList.get(0).getTitle());
    }
    @Test
    @DisplayName("Should reverse the book's title")
    void manageBooksTwo() {
        //given
        String expected = new StringBuilder()
                .append(listOfBooks.get(0).getTitle())
                .reverse()
                .toString();
                //reversString(bookTitle);
        //when
        List<Book> resultList = Main.manageBooks(StringManage.reverse, listOfBooks);
        //then
        assertEquals(expected, resultList.get(0).getTitle());
    }

}