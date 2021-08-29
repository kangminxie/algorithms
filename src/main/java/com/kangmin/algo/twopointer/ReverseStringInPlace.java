package main.java.com.kangmin.algo.twopointer;

public class ReverseStringInPlace {

    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = word.length - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

    public String reverseString(char[] word) {
        int i = 0;
        int j = word.length - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }
}
