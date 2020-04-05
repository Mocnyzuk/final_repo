package oop.books;

public class HumorBook implements BookInterface {
    @Override
    public void startRead() {
        System.out.println("I've started to read a humor book.");
    }

    @Override
    public void stopRead() {
        System.out.println("I've finished reading a humor book.");
    }

    @Override
    public void buy() {
        System.out.println("I'm buying a humor book.");
    }

    @Override
    public void sell() {
        System.out.println("I'm selling a humor book.");
    }
}
