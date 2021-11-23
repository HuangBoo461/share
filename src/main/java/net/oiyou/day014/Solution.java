package net.oiyou.day014;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return null;
        }

        if (strs.length == 0) {
            return "";
        }

        // 记录最短的字符串的长度
        int min = Integer.MAX_VALUE;

        // 找短字符串的长度
        String result = "";
        for (String str : strs) {

            if (str == null || str.length() == 0) {
                return "";
            }

            if (min > str.length()) {
                min = str.length();
                result = str;
            }
        }

        for (String s : strs) {
            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) != s.charAt(i)) {
                    result = result.substring(0, i);
                }
            }
        }

        return result;
    }
}