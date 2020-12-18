package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2020/12/16
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 1128. 等价多米诺骨牌对的数量
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 */




class Solution1128 {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2}, {2,1}, {1, 1}, {2,1}, {5, 6}, {3, 4}, {4, 1}, { 4,3 }, {6, 5 }, {1, 1}};
        System.out.println("result = " + numEquivDominoPairs(a));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        if(dominoes.length == 1) return 0;
        HashMap<String, Integer>map = new HashMap<>();
        for(int i = 0; i < dominoes.length; i ++) {
            int left = dominoes[i][0];
            int right = dominoes[i][1];
            String str = Math.max(left, right) + "" + Math.min(left, right);
            if(map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        int count = 0;
        Solution1128.map.put(2,1);
        Solution1128.map.put(3,3);
        for(Map.Entry entry : map.entrySet()) {
            if((int)entry.getValue() > 1) {
                count = count + getCount((int)entry.getValue());
            }
        }
        return count;
    }

    static HashMap<Integer, Integer>map = new HashMap<>();
    public static int getCount(int i) {
        if(i == 2) return 1;
        if(i == 3) return 3;
        if(map.containsKey(i)) return map.get(i);
        int result = getCount(i - 1) + i - 1;
        map.put(i, result);
        return result;
    }

}
