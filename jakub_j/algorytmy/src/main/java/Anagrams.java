public class Anagrams {
    /**
     * Method to check if 2nd string is an anagram of the 1st.
     * @param firstString String which contains first value
     * @param anagram String which could be an anagram of a firstString
     * @return boolean that tell's us if the two strings are an anagram or not
     */
    public static boolean isAnagram(String firstString, String anagram) {
        if(firstString == null || anagram == null){
            return false;
        }
        return (firstString.length() == anagram.length()) && containsTheSameChars(firstString.toCharArray(), anagram);
    }
    private static boolean containsTheSameChars(char[] charArr1, String s2){
        for (char c : charArr1) {
            int index = s2.indexOf(c);
            if (index != -1) {
                s2 = s2.substring(0, index) + s2.substring(s2.indexOf(c) + 1);
            } else {
                return false;
            }
        }
        return s2.isEmpty();
    }
}
