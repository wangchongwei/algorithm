/**
 * 1122. 数组的相对排序
给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

 

示例：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
 

提示：

1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * 
 * @param {*} arr1 
 * @param {*} arr2 
 */
var relativeSortArray = function(arr1, arr2) {
    let arr1Sort = arr1.sort((a, b) => a >= b ? 1 : -1);
    let result = [];
    for(let i = 0; i < arr2.length; i ++) {
        if(arr1Sort.includes(arr2[i])) {
            var start = arr1Sort.indexOf(arr2[i]);
            var end = arr1Sort.lastIndexOf(arr2[i]);
            result = result.concat(arr1Sort.splice(start, end - start + 1));
        }
    }
    result = result.concat(arr1Sort);
    console.log('result:',result);
};

var arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6];
relativeSortArray(arr1, arr2);

/**
 * 解题思路，先对arr1做排序，
 * 然后遍历arr2，取出元素在arr1的第一个下标位置、最后一个下标位置，
 * 然后将arr1中的这段数组截取放入新数组中，当arr2遍历完成，只需再将剩余的排序数组拼接到结果数组即可
 */
