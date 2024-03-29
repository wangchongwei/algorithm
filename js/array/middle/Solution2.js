/**
 * 45. 跳跃游戏 II
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

假设你总是可以到达数组的最后一个位置。

 

示例 1:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
示例 2:

输入: [2,3,0,1,4]
输出: 2
 

提示:

1 <= nums.length <= 1000
0 <= nums[i] <= 105
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function (nums) {
    let size = 0;
    let len = nums.length;
    if (len == 1) return 0;
    let currentIndex = 0;
    let nextIndex = 0;
    let max = 0
    while (currentIndex < len - 1 && len - currentIndex - 1 > nums[currentIndex]) {
        for (let i = currentIndex + 1; i <= nums[currentIndex] + currentIndex; i++) {
            if (nums[i] + i - currentIndex > max) {
                max = nums[i] + i - currentIndex;
                nextIndex = i;
            }
        }
        size++;
        console.log('nextIndex: ', nextIndex, ' max:', max);
        currentIndex = nextIndex;
        max = 0;
    }
    return ++size;
};

console.log('result:', jump([2]));
