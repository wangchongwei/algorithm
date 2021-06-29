/**
 * 除自身以外数组的乘积
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。



示例:

输入: [1,2,3,4]
输出: [24,12,8,6]
 

提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

进阶：
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/tencent/xxfcwh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    let len = nums.length;
    if(len <= 1) return [];
    let ansLeft = [];
    let result = 1;
    ansLeft.push(result);
    for(let i = 1; i < len; i ++) {
        result *= nums[i - 1];
        ansLeft.push(result);
    }
    console.log('left', ansLeft);
    result = 1;
    // let ansRight = [];
    // ansRight.push(result);
    // ansLeft[len - 1] = ansLeft[]
    for(let i = len - 2; i >= 0; i --) {
        result *= nums[i + 1];
        ansLeft[i] = ansLeft[i] * result;
        // ansRight.push(result);
    }
    
    // console.log('right', ansRight);
    // for(let i = 0; i < len; i ++) {
    //     ansLeft[i] = ansLeft[i] * ansRight[len - i - 1];
    // }
    console.log('result', ansLeft);
    return ansLeft;
};

const nums =  [1,2,3, 4, 5];

productExceptSelf(nums);

