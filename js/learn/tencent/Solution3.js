/**
 * 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 

示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 

提示：

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/tencent/xx4l3g/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
    let len = nums.length;
    if(len == 3) return nums[0] + nums[1] + nums[2];
    nums.sort((a,b) => a - b);
    console.log('nums', nums);
    let left = 0, right = len - 1, sum = 0;
    let duration = 10000;
    while(left < right - 1) {
        let temp = nums[left] + nums[left + 1] + nums[right];
        let tempDuration = Math.abs(temp - target);
        if(tempDuration == 0) return temp;
        if(tempDuration < duration) {
            duration = tempDuration;
            sum = temp
        }
        if(temp > target) {
            right--;
        } else {
            left++;
        }
        console.log('sum', sum, left, right);
    }
    return sum;
};


const nums = [0,2,1,-3], target = 1;
console.log("result:", threeSumClosest(nums, target));
