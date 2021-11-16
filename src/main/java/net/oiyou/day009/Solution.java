package net.oiyou.day009;

public class Solution {
    public boolean isPalindrome(int x) {
        // 负数不是回文数字
        if (x < 0) {
            return false;
        }

        // 数字逆转后的值，为了不使用溢出采用long
        long reverse = 0;
        int tmp = x;

        // 求逆转后的值
        while (tmp != 0) {
            reverse = reverse * 10 + tmp % 10;
            tmp /= 10;
        }

        // 判断是否是回文数字
        return x == reverse;
    }
}
