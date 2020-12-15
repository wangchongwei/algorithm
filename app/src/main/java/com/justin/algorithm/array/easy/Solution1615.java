package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2020/12/15
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

/**
 * 面试题 16.15. 珠玑妙算
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 *
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
 * 例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。
 * 作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；
 * 要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 *
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，
 * 返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 *
 * 示例：
 *
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 * 提示：
 *
 * len(solution) = len(guess) = 4
 * solution和guess仅包含"R","G","B","Y"这4种字符
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1615 {

    public static void main(String[] args) {
        masterMind("YYRG", "RRRR");
    }

    public static int[] masterMind(String solution, String guess) {
        int realGuess = 0;
        int fakeGuess = 0;
        // 存储guess中单个值以及值出现的次数
        HashMap<Character, Integer>guessMap = new HashMap<>();
        HashMap<Character, Integer>solutionMap = new HashMap<>();
        for(int i = 0; i < guess.length(); i ++) {
            char singleChar = guess.charAt(i);
            if(guessMap.containsKey(singleChar)) {
                guessMap.put(singleChar, guessMap.get(singleChar) + 1);
            } else {
                guessMap.put(singleChar, 1);
            }
            char solutionChar = solution.charAt(i);
            if(solutionMap.containsKey(solutionChar)) {
                solutionMap.put(solutionChar, solutionMap.get(solutionChar) + 1);
            } else {
                solutionMap.put(solutionChar, 1);
            }

            if(solution.charAt(i) == guess.charAt(i)) {
                realGuess ++;
                guessMap.put(singleChar, guessMap.get(singleChar) - 1);
                solutionMap.put(singleChar, solutionMap.get(singleChar) - 1);
            }
        }
        for(Map.Entry entry : guessMap.entrySet()) {
            if(solutionMap.containsKey(entry.getKey())) {
                fakeGuess = Math.min(solutionMap.get(entry.getKey()), (int)entry.getValue()) + fakeGuess;
            }
        }

        System.out.println("realGuess = " + realGuess + "  fakeGuess = " + fakeGuess);
        return new int[]{realGuess, fakeGuess};
    }
}


/**
 * 用两个map存放两个字符中出现的单个颜色的次数
 * 当位置与颜色都对时，则猜中+1
 * 最后在对map迭代，取两个map中次数少的累加。
 * */