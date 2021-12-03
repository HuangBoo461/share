package net.oiyou.day018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (num == null || num.length < 4) {
            return result;
        }

        // 对数组进行排序
        Arrays.sort(num);

        // 第一个加数
        for (int i = 0; i < num.length - 3; ) {
            // 第四个加数
            for (int j = num.length - 1; j > i + 2; j--) {
                // 第四个加数使用不重复
                if (j < num.length - 1 && num[j] == num[j + 1]) {
                    continue;
                }

                // 第二个加数
                int start = i + 1;
                // 第三个加数
                int end = j - 1;
                int n = target - num[i] - num[j];

                while (start < end) {
                    if (num[start] + num[end] == n) {
                        List<Integer> four = new ArrayList<>(4);
                        four.add(num[i]);
                        four.add(num[start]);
                        four.add(num[end]);
                        four.add(num[j]);

                        result.add(four);

                        do {
                            start++;
                            // 保证再次使用第二个数不重复
                        } while (start < end && num[start] == num[start - 1]);
                        do {
                            end--;
                            // 保证再次使用第三个数不重复
                        } while (start < end && num[end] == num[end + 1]);
                    } else if (num[start] + num[end] < n) {
                        do {
                            start++;
                            // 保证再次使用第二个数不重复
                        } while (start < end && num[start] == num[start - 1]);
                    } else {
                        do {
                            end--;
                            // 保证再次使用第三个数不重复
                        } while (start < end && num[end] == num[end + 1]);
                    }
                }
            }

            // 相同的数字作为处理只能使用一次
            do {
                i++;
            } while (i < num.length - 2 && num[i - 1] == num[i]);
        }
        return result;
    }
}
