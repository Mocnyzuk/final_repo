package oop.books;

public class BookFactory {

    private static BookFactory bookFactoryInstance;

    public BookFactory() {
    }

    public static BookFactory getInstance() {
        if (bookFactoryInstance == null) {
            bookFactoryInstance = new BookFactory();
        }
        return bookFactoryInstance;
    }

    public BookInterface getBook(BookEnum bookEnum) {
        switch (bookEnum) {
            case HISTORICAL: {
                return new HistoricalBook();
            }
            case HUMOR: {
                return new HumorBook();
            }
            case DETECTIVE: {
                return new DetectiveBook();
            }
            default: {
                return null;
            }
        }
    }
}
