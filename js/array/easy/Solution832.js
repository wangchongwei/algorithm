/**
 * 832. 翻转图像
给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

 

示例 1：

输入：[[1,1,0],[1,0,1],[0,0,0]]
输出：[[1,0,0],[0,1,0],[1,1,1]]
解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
示例 2：

输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 

提示：

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1
 * 
 */
/**
 * @param {number[][]} image
 * @return {number[][]}
 */
var flipAndInvertImage = function(image) {
    let rows = image.length;
    let columns = image[0].length;
    for(let i = 0; i < rows; i ++) {
        let rowValue = image[i];
        for(let j = 0; j < columns; j ++) {
            if(j < Math.floor(columns / 2)) {
                // 翻转
                let temp = rowValue[j];
                rowValue[j] = rowValue[columns - j - 1]
                rowValue[columns - j - 1] = temp;
            }
            // 反转
            rowValue[j] = 1 - rowValue[j];
        }
    }
    return image;
};


// const arr = [[1,1,0],[1,0,1],[0,0,0]];
// console.log('result', flipAndInvertImage(arr));


/**
 * 遍历二维数组，先翻转，即第一位与最后一位互换，依次类推，换到下标为中间位置，则翻转完成
 * 同时进行反转，直接使用 1 - 即可 或者 ^ 1
 * 
 * 还有一种更简单的，就是互换时，如果两个相等，则不需要互换，直接都反转，
 * 如果两个不相等，则无需处理
 * 因为如果 两个数必然 一个为0 一个为1 当翻转在反转后，与原值一样，所以无需修改
 */
var flipAndInvertImage2 = function(image) {
    let rows = image.length;
    let columns = image[0].length;
    for(let i = 0; i < rows; i ++) {
        let rowValue = image[i];
        for(let j = 0; j < Math.floor(columns / 2); j ++) {
            if(rowValue[j] == rowValue[columns - j - 1]) {
               rowValue[j] = rowValue[j] ^ 1;
               rowValue[columns - j - 1] = rowValue[columns - j - 1] ^ 1;
            }
        }
        if(columns % 2 == 1) {
            const index= Math.floor(columns / 2);
            rowValue[index] = rowValue[index] ^ 1;
        }
    }
    return image;
};



const arr = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]];
console.log('result', flipAndInvertImage2(arr));
