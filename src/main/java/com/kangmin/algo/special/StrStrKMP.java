package main.java.com.kangmin.algo.special;

public class StrStrKMP {

    private int[] failureFunction(char[] str) {
        int[] func = new int[str.length + 1];
        for (int i = 2; i < func.length; i++) {
            int j = func[i - 1];
            while (j > 0 && str[j] != str[i - 1]){
                j = func[j];
            }
            if (j > 0 || str[j] == str[i - 1]) {
                func[i] = j + 1;
            }
        }
        return func;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() <= haystack.length()) {
            int[] f = failureFunction(needle.toCharArray());
            int i = 0, j = 0;
            while (i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                    if (j == needle.length()) return i - j;
                } else if (j > 0) {
                    j = f[j];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
}
