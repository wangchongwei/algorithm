/**
 * 反转链表
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 

示例 1：


输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
示例 2：


输入：head = [1,2]
输出：[2,1]
示例 3：

输入：head = []
输出：[]
 

提示：

链表中节点的数目范围是 [0, 5000]
-5000 <= Node.val <= 5000
 

进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/tencent/x5xg2m/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */

// function ListNode(val, next) {

//     return this;
// }
class ListNode {
    constructor(val, next) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (head) {
    if (!head || !head.next) return head
    console.log('head', head);
    let first = new ListNode(head.val);
    let ans;
    while (head.next) {
        ans = new ListNode(head.next.val, first);
        first = ans;
        head = head.next;
    }
    console.log('ans', ans);
    return ans;
};




const node1 = new ListNode(1);
const node2 = new ListNode(2, node1);
const node3 = new ListNode(3, node2);
const node4 = new ListNode(4, node3);
const node5 = new ListNode(5, node4);
// console.log('node5', node5);
reverseList(null);

