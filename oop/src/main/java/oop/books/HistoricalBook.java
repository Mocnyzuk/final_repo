package oop.books;

public class HistoricalBook implements BookInterface {
    @Override
    public void startRead() {
        System.out.println("I've started to read a historical book.");
    }

    @Override
    public void stopRead() {
        System.out.println("I've finished reading a historical book.");
    }

    @Override
    public void buy() {
        System.out.println("I'm buying a historical book.");
    }

    @Override
    public void sell() {
        System.out.println("I'm selling a historical book.");
    }
}
