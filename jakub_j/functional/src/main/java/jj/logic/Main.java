package jj.logic;

import jj.model.RandomList;
import jj.model.Book;
import java.util.List;
import java.util.stream.Collectors;
import static jj.logic.StringManage.reverse;
import static jj.model.Book.*;

public class Main {
    public static void main(String[] args) {
        List<Book> listOfBooks = RandomList.getRandomList(150);
        listOfBooks
                .stream()
                .filter(isScienceBook)
                .filter(hasMoreThan100Pages)
                .sorted(sortingByPages)
                .forEach(System.out::println);
        manageBooks(reverse, listOfBooks);
        manageBooks(s->s.substring(0, s.length()/2), listOfBooks);
    }

    public static List<Book> manageBooks(StringManage stringManage, List<Book> books){
        return books
                .stream()
                .peek(b -> b.setTitle(stringManage.manage(b.getTitle())))
                .collect(Collectors.toList());
    }



}
