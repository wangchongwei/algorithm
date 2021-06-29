/**
 * 19. 删除链表的倒数第 N 个结点
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？

 

示例 1：


输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]
 

提示：

链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
通过次数413,634提交次数982,335
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
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 * 双指针-快慢指针 即可解决
 */
var removeNthFromEnd = function(head, n) {
    if(n == 1 && !head.next) {
        return null;
    }
    let fast = head;
    let slow = head;
    let ans = slow;
    let fastCount = 0;
    let slowCount = 0;
    while(fast.next) {
        fast = fast.next;
        if(fastCount == n + slowCount) {
            console.log('----', fastCount)
            slow = slow.next;
            slowCount++;
        }
        fastCount ++;
    }
    if(fastCount == n + slowCount) {
        slow.next = slow.next.next;
    } else {
        if(slow.next) {
            slow.val = slow.next.val;
            slow.next = slow.next.next;
        } else {
            slow = null;
        }
    }
    console.log('ans', ans);
    return ans;
};



var head = new ListNode(1,new ListNode(2, null))

removeNthFromEnd(head, 2);
