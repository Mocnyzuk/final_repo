package jj.logic;

import static java.lang.Character.MIN_VALUE;

@FunctionalInterface
public interface StringManage {
    String manage(String s);

    StringManage getFirstLetterToUpper = s-> s.substring(0, 1).toUpperCase();
    StringManage deleteA = s-> (s.contains("a"))? s.replace('a', MIN_VALUE):s;
    StringManage reverse = s-> {
        byte[] byteArrayString = s.getBytes();
        byte[] reversedString = new byte[byteArrayString.length];
        for (int i = 0; i < byteArrayString.length; i++) {
            reversedString[i] = byteArrayString[byteArrayString.length-1-i];
        }
        return new String(reversedString);
    };
}
