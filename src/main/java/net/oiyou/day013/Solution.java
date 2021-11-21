package net.oiyou.day013;

public class Solution {
    public int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            // 当前的值比前一个值大，说明[i-1, i]组成一个值，并且值是s[i-1]-s[i]
            if (i > 0 && charToInt(s.charAt(i)) > charToInt(s.charAt(i - 1))) {
                // 要减去两倍之前前值才能回到真实值
                result += charToInt(s.charAt(i)) - 2 * charToInt(s.charAt(i - 1));
            } else {
                result += charToInt(s.charAt(i));
            }
        }

        return result;
    }

    private int charToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}