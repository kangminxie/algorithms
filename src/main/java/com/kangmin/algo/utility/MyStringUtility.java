package com.kangmin.algo.utility;

public class MyStringUtility {

   /**
    * For encoding string
    * Encoding help method to convert a raw String to 8-bit 1-0 String
    *
    * @param data String the raw data
    * @return Converted String
    */
   public static String transferToBinaryString(final String data) {
       final StringBuilder sb = new StringBuilder();
       final String encodedLengthInfo = String.format("%08d", Integer.parseInt(Integer.toBinaryString(data.length())));
       sb.append(encodedLengthInfo);
       for (final char ch : data.toCharArray()) {
           // e.g. ch = 'a' (97), 97 = 64 + 32 + 1, binaryStr = 01100001
           int checkSum = 0;
           final String binaryStr = String.format("%08d", Integer.parseInt(Integer.toBinaryString(ch)));
           sb.append(binaryStr);
           for (char digit : binaryStr.toCharArray()) {
               if (digit == '1') {
                   checkSum++;
               }
           }
           checkSum = (checkSum % 2 == 0) ? 0 : 1;
           sb.append(String.format("%08d", checkSum));
       }
       return sb.toString();
   }

   // helper method, convert four digits binStr to hexStr
   private static char bin4ToHex1(final String bin) {
       switch (bin) {
           case "0000":    return '0';
           case "0001":    return '1';
           case "0010":    return '2';
           case "0011":    return '3';
           case "0100":    return '4';
           case "0101":    return '5';
           case "0110":    return '6';
           case "0111":    return '7';
           case "1000":    return '8';
           case "1001":    return '9';
           case "1010":    return 'a';
           case "1011":    return 'b';
           case "1100":    return 'c';
           case "1101":    return 'd';
           case "1110":    return 'e';
           case "1111":    return 'f';
       }
       return '0';
   }

   // helper method, convert 32 digits binStr to hexStr
   public static String bin32ToHex8(String bin) {
       // bin must be 32-bit binary, index from 0 to 31
       // result will be 8-bit hex
       final StringBuilder sb = new StringBuilder();
       int i  = 0;
       while (i < 8) {
           final String sub = bin.substring(4 * i, 4 * i + 4);
           final char hex = bin4ToHex1(sub);
           sb.append(hex);
           i++;
       }
       return sb.toString();
   }

   // helper method, convert four digits binStr to hexStr
   public static String hexToBin(final char c) {
       switch (c) {
           case '0':   return "0000";
           case '1':   return "0001";
           case '2':   return "0010";
           case '3':   return "0011";
           case '4':   return "0100";
           case '5':   return "0101";
           case '6':   return "0110";
           case '7':   return "0111";
           case '8':   return "1000";
           case '9':   return "1001";
           case 'a':   return "1010";
           case 'b':   return "1011";
           case 'c':   return "1100";
           case 'd':   return "1101";
           case 'e':   return "1110";
           case 'f':   return "1111";
       }
       return "0000";
   }

   // convert binary String to decimal
   public static int binToDec(String bin) {
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
