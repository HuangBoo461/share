package net.oiyou.day020;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        final String left = "([{";
        final String right = ")]}";

        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);

            // 如果是左括号就入栈
            if (left.indexOf(c) > -1) {
                stack.push(c);
            } else {
                // 如果是右括号就看栈顶元素
                // 如果栈为空或者栈顶元素不匹配就返回false
                if (stack.isEmpty() || right.indexOf(c) != left.indexOf(stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
