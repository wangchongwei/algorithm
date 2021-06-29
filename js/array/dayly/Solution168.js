/**
 * 168. Excel表列名称
给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。

例如：

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

示例 1：

输入：columnNumber = 1
输出："A"
示例 2：

输入：columnNumber = 28
输出："AB"
示例 3：

输入：columnNumber = 701
输出："ZY"
示例 4：

输入：columnNumber = 2147483647
输出："FXSHRXW"
 

提示：

1 <= columnNumber <= 231 - 1
 */
/**
 * @param {number} columnNumber
 * @return {string}
 * 其实只是27进制转换
 */
var convertToTitle = function(columnNumber) {
    const arr = ['A', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
    let ans = '';
    let left = columnNumber % 27;
    let column = Math.floor(columnNumber / 27);
    while (column > 26) {
        ans = arr[left] + ans;
        left = column % 26;
        column = Math.floor(column / 26);
    }
    ans = arr[left] + ans;
    ans = (column ? arr[column] : '') + ans;
    console.log('result :', ans, ' column :', column, ' left:', left);
    return ans;
};


convertToTitle(28);