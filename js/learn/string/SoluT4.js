/**
 * 17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



 

示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]
 

提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字
 */

 /**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations2 = function(digits) {
    let params = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz'
    }
    let len = digits.length;
    if(len == 0) return [];
    if(len == 1) return digits.split('');
    let ans = [];
    ans = ans.concat(params[digits.charAt(0)].split(''));
    console.log('len', len)
    for(let i = 1; i < len; i ++) {
        let duration = ans.length;
        let ch = params[digits.charAt(i)];
        let chLen = ch.length;
        // du = 3 
        for(let j = 0; j < duration; j ++) {
            for(let k = 1; k < chLen; k ++) {
                let v = ans[j]
                ans.push(ch.charAt(k) + v);
            }
        }
        for(let j = 0; j < duration; j ++) {
            ans[j] = ans[j] + ch.charAt(0);
        }
        console.log('ans = ', ans);
    }
    console.log('result:', ans);
    return ans;
};

var letterCombinations = function(digits) {
    let params = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz'
    }
    let len = digits.length;
    if(len == 0) return [];
    if(len == 1) return params[digits].split('');
    let ans = [];
    ans = ans.concat(params[digits.charAt(0)].split(''));
    console.log('len', len)
    for(let i = 1; i < len; i ++) {
        let duration = ans.length;
        let ch = params[digits.charAt(i)];
        let chLen = ch.length;
        // du = 3 
        for(let j = 1; j < duration; j ++) {
            for(let k = 0; k < chLen; k ++) {
                let v = ans[j]
                ans.push(v + ch.charAt(k));
            }
        }
        for(let j = 0; j < chLen; j ++) {
            ans[j] = ans[j] + ch.charAt(0);
        }
        console.log('ans = ', ans);
    }
    console.log('result:', ans);
    return ans;
};


// 3 d e f
console.log(letterCombinations('2'))
