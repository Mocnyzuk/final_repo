package jj.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static jj.model.BookType.*;

public class RandomList {

    public static List<Book> getRandomList(int sizeOfList){
        List<Book> list = new ArrayList<>();
        while(sizeOfList>0){
            list.add(getRandomBook(sizeOfList));
            sizeOfList--;
        }
        return list;
    }
    private static Book getRandomBook(int index){
        Random random = new Random();
        int randomIndex = random.nextInt(index);
        int valueForSwitch = (int) (randomIndex/37.5);
        BookType bookType;
        switch (valueForSwitch){
            case 0:
                bookType = COMIC;
                break;
            case 1:
                bookType = DOCUMENTARY;
                break;
            case 2:
                bookType = RELIGIOUS;
                break;
            default:
                bookType = SCIENCE;
                break;
        }
        return new Book(randomIndex, generateRandomString(randomIndex/5), bookType);
    }
    private static String generateRandomString(int lenght){
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < lenght ; i++) {
            resultBuilder.append(alphaNumericString.charAt(
                    (int)( alphaNumericString.length()*Math.random())));
        }
        return resultBuilder.toString();
    }
}
