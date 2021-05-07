/**
 * 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。



示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。


提示：

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成


作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/array-and-string/ceda1/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
    let len = strs.length;
    if (len == 0) return "";
    if (len == 1) return strs[0];
    let common = pickCommonStr(strs[0], strs[1]);
    for (let i = 2; i < len; i++) {
        console.log('common', common);
        if (!common) {
            return "";
        }
        common = pickCommonStr(common, strs[i]);
    }
    return common;
};

/**
 * 
 * @param {string} str1 
 * @param {string} str2 
 */
function pickCommonStr(str1, str2) {
    let l1 = str1.length;
    let l2 = str2.length;
    let common = "";
    let index = 0;
    while (index < l1 && index < l2) {
        if (str1.charAt(index) == str2.charAt(index)) {
            common += str1.charAt(index);
            index++;
        } else {
            return common;
        }
    }
    console.log('common', common);
    return common;
}

const strs = ["ab", "a"];


console.log('result', longestCommonPrefix(strs));