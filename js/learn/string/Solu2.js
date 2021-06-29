/**
 * 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

 

示例：

输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"
 

提示：

在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/array-and-string/c8su7/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let arr = s.split(' ');
    let len = arr.length;
    let result = '';
    for(let i = 0; i < len; i ++) {
        if(arr[i]) {
            arr[i] = rever(arr[i]);
        }
        if(i == 0) {
            result += arr[i];
        } else {
            result += ` ${arr[i]}`;
        }
    }
    // s = arr.toString().replace(/,/g, ' ');
    console.log('allresult:', result, '--');
    return result;
};

/**
 * @returns {string}
 * @param {string} s 
 * 
 */
var rever = function(s) {
    s = s.replace(/,/g, ' ');
    let arr = s.split('');
    let left = 0, right = arr.length - 1;
    while(left < right) {
        let temp = arr[left];
        arr[left++] = arr[right];
        arr[right--] = temp; 
    }
    s = arr.toString().replace(/,/g, '').replace(/ /g, ',');
    console.log('result:', s, '--');
    return s;
}

const s = "Let's take LeetCode contest";
reverseWords(s);

//">gnirts<rotcev tilps gnirts( ,s rahc )retimiled"