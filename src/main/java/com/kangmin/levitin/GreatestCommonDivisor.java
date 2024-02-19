package main.java.com.kangmin.levitin;

public class GreatestCommonDivisor {

    public static int getByEuclid(int m, int n) {
        while (n != 0) {
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    public static void main(String[] args) {
        assert 12 == getByEuclid(60, 24);
        assert 12 == getByEuclid(24, 60);

        assert 45 == getByEuclid(105, 45);
        assert 45 == getByEuclid(45, 105);
    }
}
