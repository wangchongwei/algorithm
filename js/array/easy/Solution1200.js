/**
 * 1200. 最小绝对差
给你个整数数组 arr，其中每个元素都 不相同。

请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。

 

示例 1：

输入：arr = [4,2,1,3]
输出：[[1,2],[2,3],[3,4]]
示例 2：

输入：arr = [1,3,6,10,15]
输出：[[1,3]]
示例 3：

输入：arr = [3,8,-10,23,19,-4,-14,27]
输出：[[-14,-10],[19,23],[23,27]]
 

提示：

2 <= arr.length <= 10^5
-10^6 <= arr[i] <= 10^6
 */

/**
 * @param {number[]} arr
 * @return {number[][]}
 */
var minimumAbsDifference = function(arr) {
    arr.sort((a, b) => a - b);
    var result = [];
    var min = 200001;
    for(let i = 1; i < arr.length; i ++) {
        let duration = Math.abs(arr[i] - arr[i - 1]);
        if(duration < min) {
            min = duration;
            result = [];
            result.push([arr[i - 1], arr[i]]);
        } else if (duration == min) {
            result.push([arr[i - 1], arr[i]]);
        }
    }
    console.log('result', result);
    return result;
};

const arr = [1,2,3,4,5, 7, 8, 6];
minimumAbsDifference(arr);


