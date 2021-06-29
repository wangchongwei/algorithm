/**
 * 6. Z 字形变换
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
 

示例 1：

输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
示例 3：

输入：s = "A", numRows = 1
输出："A"
 

提示：

1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000
 */
/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 * 此解法超时
 */
var convert = function(s, numRows) {
    let len = s.length;
    if(len <= numRows) return s;
    let ans = '';
    let x = numRows * 2 - 2;
    let dur = Math.floor(len / x) + 1;
    let arr = [];
    for(let k = 0; k < dur; k ++) {
        let count = 0;
        for(let i = 0; i< numRows - 1; i++) {
            let an = [];
            let left = count % numRows;
            for(let j = 0; j < numRows; j ++) {
                if(i == 0) {
                    an.push(s.charAt(count));
                    count++
                } else if (j == numRows - left- 2) {
                    an.push(s.charAt(count));
                    count++
                } else {
                    an.push('');
                }
            }
            arr.push(an);
        }
        console.log('arr', arr);
        s = s.substring(x);
        console.log('s', s);
    }
    for(let i = 0; i < numRows; i ++) {
        for(let j = 0; j < arr.length; j ++) {
            ans += arr[j][i];
        }
    }
    console.log('ans', ans);
    return ans;
};
//PINALSIGYAHRPI
convert('PAYPALISHIRING', 2);
// PAHNAPLSIIGYIR