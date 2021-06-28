//
//  Solution3.cpp
//  algorithm
//
//  Created by justin.wang on 2021/5/11.
//

/**
 合并两个有序链表
 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

  

 示例 1：


 输入：l1 = [1,2,4], l2 = [1,3,4]
 输出：[1,1,2,3,4,4]
 示例 2：

 输入：l1 = [], l2 = []
 输出：[]
 示例 3：

 输入：l1 = [], l2 = [0]
 输出：[0]
  

 提示：

 两个链表的节点数目范围是 [0, 50]
 -100 <= Node.val <= 100
 l1 和 l2 均按 非递减顺序 排列

 作者：力扣 (LeetCode)
 链接：https://leetcode-cn.com/leetbook/read/tencent/x59tp7/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

#include <stdio.h>
#include <iostream>
#include <list>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* prev = new ListNode(0);
        ListNode* prevHelper = prev;
        while (l1 != nullptr && l2 != nullptr) {
            if(l1->val < l2->val) {
                prevHelper->next = l1;
                l1 = l1->next;
            } else {
                prevHelper->next = l2;
                l2 = l2->next;
            }
            prevHelper = prevHelper->next;
        }
        prevHelper->next = l1 == nullptr ? l2 : l1;
        return prev->next;
    }
};

int mainl3() {
    cout << "开始" << endl;
    ListNode list1(1);
    ListNode list2(2, &list1);
    ListNode list3(3, &list2);
    ListNode list4(4, &list3);
    ListNode list5(5, &list4);
    
    Solution so;
    
    
    return 0;
}

