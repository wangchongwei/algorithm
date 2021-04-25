/**
 * 只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
/**
 * @param {number[]} nums
 * @return {number}
 * 异或位运算符规则：
 * 1、0与一个数A异或结果为该数本身A
 * 2、任一数与自身异或结果为0
 * 3、多个数字取异或满足数学的交换律
 */
var singleNumber = function(nums) {
    let result = 0;
    for(let i = 0; i < nums.length; i ++) {
        result = result ^ nums[i];
    }
    console.log('result', result);
    return result;
};
const arr =[4,1,2,1,2];
singleNumber(arr);
