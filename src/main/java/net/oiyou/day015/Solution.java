package net.oiyou.day015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        int target = 0;

        int a = 0;
        while (a < nums.length - 2) {
            int b = a + 1;
            int c = nums.length - 1;
            while (b < c) {
                if (nums[a] + nums[b] + nums[c] < target) {
                    do {
                        ++b;
                    } while (b < c && nums[b] == nums[b - 1]);
                } else if (nums[a] + nums[b] + nums[c] > target) {
                    do {
                        --c;
                    } while (b < c && nums[c] == nums[c + 1]);
                } else {
                    List<Integer> idxs = new ArrayList<>();
                    idxs.add(nums[a]);
                    idxs.add(nums[b]);
                    idxs.add(nums[c]);
                    result.add(idxs);

                    do {
                        ++b;
                    } while (b < c && nums[b] == nums[b - 1]);
                    do {
                        --c;
                    } while (b < c && nums[c] == nums[c + 1]);
                }
            }

            // nums[a-1]已经被选过了，不用再选了
            do {
                ++a;
            } while (a < nums.length - 2 && nums[a - 1] == nums[a]);
        }
        return result;
    }
}
