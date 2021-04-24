/**
 * 1304. 和为零的N个唯一整数
给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。

 

示例 1：

输入：n = 5
输出：[-7,-1,1,3,4]
解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
示例 2：

输入：n = 3
输出：[-1,0,1]
示例 3：

输入：n = 1
输出：[0]
 

提示：

1 <= n <= 1000
 */
/**
 * @param {number} n
 * @return {number[]}
 * thinking: 相加和为0， 0 是偶数，必然存在偶数个奇数
 */
var sumZero = function(n) {
    if(n == 1) return [0];
    let result = [];
    let len = n;
    let last = 0;
    if(n % 2 == 1) {
        // 代表时奇数 此时添加一个0
        result.push(0);
        len --;
    }
    for(let i = 0; i < len; i ++) {
        if(last >= 0) {
            last = (last + 1) * -1;
        } else {
            last = last * -1;
        }
        result.push(last);
    }
    console.log('result', result);
    return result;
};
sumZero(8);