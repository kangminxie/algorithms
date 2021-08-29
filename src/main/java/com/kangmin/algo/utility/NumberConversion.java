package main.java.com.kangmin.algo.utility;


public class NumberConversion {

    /**
     * hardcoded method to convert hex to binary char
     * @param c character number from 0 to f
     * limitation: 32-bit
     */
    public static String hexCharToBin(char c) {
        if (c == '0') { return "0000"; }
        if (c == '1') { return "0001"; }
        if (c == '2') { return "0010"; }
        if (c == '3') { return "0011"; }
        if (c == '4') { return "0100"; }
        if (c == '5') { return "0101"; }
        if (c == '6') { return "0110"; }
        if (c == '7') { return "0111"; }
        if (c == '8') { return "1000"; }
        if (c == '9') { return "1001"; }
        if (c == 'a') { return "1010"; }
        if (c == 'b') { return "1011"; }
        if (c == 'c') { return "1100"; }
        if (c == 'd') { return "1101"; }
        if (c == 'e') { return "1110"; }
        if (c == 'f') { return "1111"; }
        return "0000";
    }


    /**
     * method to convert binary String to decimal
     * @param bin the Binary representation of number
     * limitation: 32-bit
     */
    public static int binToDec(String bin) {
    	if (bin == null || bin.length() == 0 || bin.length() > 32) {
    		return 0;
    	}
        int result = 0;
        int base = 1;
        for (int i = bin.length() - 1; i >= 0; i--) {
            if (bin.charAt(i) == '1') {
                result = result + base;
            }
            base = base * 2;
        }
        return result;
    }

}
