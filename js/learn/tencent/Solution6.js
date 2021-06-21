/**
 * 螺旋矩阵
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

 

示例 1：


输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：


输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 

提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/tencent/x5elr5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {
    let m = matrix.length;
    let n = matrix[0].length;
    if(m == 1) return matrix[0];
    let size = 0;
    let ans = [];
    for(let i = 0; i < m; i ++) {
        if(size % 4 == 0) {
            // 取上面

        } else if (size % 4 == 1) {
            // 取右边

        } else if (size % 4 == 2) {
            // 取下边
            
        } else {
            // 取左边

        }
        for(let j = 0; j < n; j ++) {
           
        }
    }
};