//
//  Solution1.cpp
//  algorithm
//
//  Created by justin.wang on 2021/5/11.
//
/**
 反转链表
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

 作者：力扣 (LeetCode)
 链接：https://leetcode-cn.com/leetbook/read/tencent/x5xg2m/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 
 */

#include <stdio.h>
#include <iostream>
#include <list>

using namespace std;


/**
 * Definition for singly-linked list.
 *
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        
        ListNode* prev = nullptr;
        ListNode* curr = head;
        while (curr) {
            ListNode* next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        cout << "result:" << prev->val << endl;
        return prev;
    }
};

int mainl1() {
    ListNode list1(1);
    ListNode list2(2, &list1);
    ListNode list3(3, &list2);
    ListNode list4(4, &list3);
    ListNode list5(5, &list4);
    
    Solution so;
    so.reverseList(&list5);
    
    return 0;
}


