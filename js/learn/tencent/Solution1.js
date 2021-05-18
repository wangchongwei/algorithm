/**
 * 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
示例 2：

输入：nums = []
输出：[]
示例 3：

输入：nums = [0]
输出：[]
 

提示：

0 <= nums.length <= 3000
-105 <= nums[i] <= 105

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/tencent/xxst6e/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    const ans = [];
    let len = nums.length;
    if(len < 3) return ans;
    // 获取下标
    // for(let i = 2; i < len; i ++) {
    //     for(let a = 0; a < i; a ++) {
    //         for(let j = a + 1; j < i; j ++) {
    //             if(nums[a] + nums[j] == (0 - nums[i])) {
    //                 ans.push([a, j, i]);
    //             }
    //         }
    //     }
    // }
    // 获取值
    nums.sort((a, b) => a - b);
    let map = {}
    map[nums[0]] = 0;
    map[nums[1]] = 1;
    let target = 0;
    for(let i = 2; i < len; i ++) {
        target = 0 - nums[i];
        Object.keys(map).forEach(it => {
            it = parseInt(it);
            console.log('target', target, 'it', it);
            if(target - it != it && map.hasOwnProperty(`${target - it}`)) {
                if(map[`${it}`] > map[`${target - it}`]) {
                    ans.push([target - it, it, nums[i]]);
                } else {
                    ans.push([it, target - it, nums[i]]);
                }
            }
        })
        map[nums[i]] = i;
    }
    console.log('map', map)
    console.log('result', ans);
    return ans;
};

/**
 * 
 * @param {Object} map 
 * @param {number} target 
 */
var twoSum = function(map, target) {
    let ans = [];
    for (const it of map) {
        if(target - it != it && map.hasOwnProperty(target - it)) {
            if(map[it] > map[target - it]) {
                ans.push([target - it, it, ])
            }
        }
    }
    return ans;
}

const arr = [-1,0,1,2,-1,-4];
threeSum(arr);

// const ae = {1: 2, 3: 5};
// Object.keys(ae).forEach(it => {
//     console.log('ae', it);
// })
