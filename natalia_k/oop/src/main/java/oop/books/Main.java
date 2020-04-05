package oop.books;

public class Main {
    public static void main(String[] args) {

        exampleOfDesignPatternFactory();
    }

    private static void exampleOfDesignPatternFactory() {
        BookFactory bookFactory = new BookFactory();
        BookInterface[] bookArray = {
                bookFactory.getBook(BookEnum.DETECTIVE),
                bookFactory.getBook(BookEnum.HISTORICAL),
                bookFactory.getBook(BookEnum.HUMOR)
        };

        for (BookInterface book : bookArray) {
            book.buy();
            book.startRead();
            book.stopRead();
            book.sell();
            System.out.println("==========================");
        }
    }
}
