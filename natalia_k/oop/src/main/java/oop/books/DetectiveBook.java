package oop.books;

public class DetectiveBook implements BookInterface {
    @Override
    public void startRead() {
        System.out.println("I've started to read a detective book.");
    }

    @Override
    public void stopRead() {
        System.out.println("I've finished reading a detective book.");
    }

    @Override
    public void buy() {
        System.out.println("I'm buying a detective book.");
    }

    @Override
    public void sell() {
        System.out.println("I'm selling a detective book.");
    }
}
