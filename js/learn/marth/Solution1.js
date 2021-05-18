/**
 * Fizz Buzz
写一个程序，输出从 1 到 n 数字的字符串表示。

1. 如果 n 是3的倍数，输出“Fizz”；

2. 如果 n 是5的倍数，输出“Buzz”；

3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。

示例：

n = 15,

返回:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xngt85/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
/**
 * @param {number} n
 * @return {string[]}
 */
var fizzBuzz = function (n) {
    const fizz = 'Fizz';
    const bizz = 'Buzz';
    const fibi = 'FizzBuzz';
    const arr = [];
    for (let i = 1; i <= n; i++) {
        let str = '';
        if (i % 3 == 0) {
            str += fizz;
        }
        if (i % 5 == 0) {
            str += bizz;
        }
        if (!str) {
            str += i;
        }
        arr.push(str);
    }
    console.log(arr);
    return arr;
};
fizzBuzz(15);