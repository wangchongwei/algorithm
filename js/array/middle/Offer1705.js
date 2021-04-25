/**
 * 面试题 17.05.  字母与数字
给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。

返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。

示例 1:

输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]

输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
示例 2:

输入: ["A","A"]

输出: []
提示：

array.length <= 100000
 */
/**
 * @param {string[]} array
 * @return {string[]}
 */
var findLongestSubarray = function(array) {
    if(array.length <= 1) return [];
    let numArr = [];
    let wordArr = [];
    var Regx = /^[0-9]*$/
    for(let i = 0; i < array.length; i ++) {
        if(Regx.test(array[i])) {
            // 数字
            numArr.push(i);
        } else {
            wordArr.push(i);
        }
    }
    // 将数字与字母分别放入到两个数组中保存 使用两个指针来遍历
    let num = 0;
    let word = 0;
    let startNum = 0;
    let startWord = 0;
    let maxLength = 0;
    while(num < numArr.length || word < wordArr.length) {
        if(numArr[num] = wordArr[word] + 1 || numArr[num] == wordArr[word] - 1) {
            if(startNum || startWord) {
                
            }
            num ++;
            word ++;
        }
    }
};