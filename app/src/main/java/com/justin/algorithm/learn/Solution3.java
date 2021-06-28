package com.justin.algorithm.learn;
/*
 * created by Justin on 2021/5/17
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/tencent/xxst6e/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 思路：将三数之和转变为二数之和
 */
class Solution3 {


    public static void main(String[] args) {
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println("result: " + threeSum(nums).size());
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        int len = nums.length;
        if(len < 3) return ans;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Arrays.sort(nums);
        for(int i = 0; i < len; i ++) {
            for(int j = i + 1; j < len && j > 1; j ++) {
                if(nums[0] + nums[i] + nums[j] > 0) return ans;
                int result = 0 - nums[i] - nums[j];
                if(map.containsValue(result)) {
//                    boolean flag = true;
//                    for(int k = 0; k < ans.size(); k++) {
//                        if(ans.get(k).get(0) == result && ans.get(k).get(1) == nums[i]) {
//                           flag = false;
//                           break;
//                        }
//                    }
//                    if(flag) {
                        List list = new ArrayList(3);
                        list.add(result);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        ans.add(list);
//                    }
                }
            }
            map.put(i, nums[i]);
        }
        return ans;
    }
}
