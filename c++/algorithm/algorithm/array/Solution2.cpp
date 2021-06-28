//
//  Solution2.cpp
//  algorithm
//
//  Created by justin.wang on 2021/5/11.
//

/**
 
 盛最多水的容器
 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器。

  

 示例 1：



 输入：[1,8,6,2,5,4,8,3,7]
 输出：49
 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 示例 2：

 输入：height = [1,1]
 输出：1
 示例 3：

 输入：height = [4,3,2,1,4]
 输出：16
 示例 4：

 输入：height = [1,2,1]
 输出：2
  

 提示：

 n = height.length
 2 <= n <= 3 * 104
 0 <= height[i] <= 3 * 104

 作者：力扣 (LeetCode)
 链接：https://leetcode-cn.com/leetbook/read/tencent/xxcmit/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

#include <stdio.h>
#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    int maxArea(vector<int>& height) {
        int max = 0, left = 0, right = height.size() - 1;
        int h = 0;
        while (left < right) {
            int du = right - left;
            if(height[left] < height[right]) {
                h = height[left++];
            } else {
                h =  height[right--];
            }
            max = max > du * h ? max : du * h;
        }
        return max;
    }
};

int main() {
    cout << "array" << endl;
    vector<int>vec;
//    [4,3,2,1,4]
    vec.insert(vec.begin(), 4);
    vec.insert(vec.begin(), 1);
    vec.insert(vec.begin(), 2);
    vec.insert(vec.begin(), 3);
    vec.insert(vec.begin(), 4);
    Solution so;
    cout << "result: " << so.maxArea(vec) << endl;
    return 0;
}


