/**
 * 2. 两数相加
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 

示例 1：


输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：

输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：

输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
 

提示：

每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
 */

 /**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    let ans = l1;
    let moreTen = false;
    while(l1.next) {
        if(l2) {
            l1.val += l2.val;
            if(moreTen) {
                l1.val += 1;
                moreTen = false;
            }
            if(l1.val >= 10) {
                moreTen = true;
                l1.val -= 10;
            } else {
                moreTen = false;
            }
            l2 = l2.next;
        } else {
            if(moreTen) {
                l1.val += 1;
                if(l1.val >= 10) {
                    moreTen = true;
                    l1.val -= 10;
                } else {
                    moreTen = false;
                }
            } else {
            }
            
        }
        console.log('l1 va', l1, moreTen);
        l1 = l1.next;

    };
   
    if(moreTen) {
        l1.next = new ListNode(1);
    }
    
    console.log('ans = ', ans);
    return ans;
};

// let l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
// let l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))

let l1 = new ListNode(1, new ListNode(9));
let l2 = new ListNode(9);

addTwoNumbers(l1, l2);