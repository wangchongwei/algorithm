//
//  Solution1720.cpp
//  algorithm
//
//  Created by justin.wang on 2021/5/8.
//
/**
 1720. 解码异或后的数组
 未知 整数数组 arr 由 n 个非负整数组成。

 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。

 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。

 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。

  

 示例 1：

 输入：encoded = [1,2,3], first = 1
 输出：[1,0,2,1]
 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 示例 2：

 输入：encoded = [6,2,7,3], first = 4
 输出：[4,2,0,7,4]
  

 提示：

 2 <= n <= 104
 encoded.length == n - 1
 0 <= encoded[i] <= 105
 0 <= first <= 105
 */

#include <stdio.h>
#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    vector<int> decode(vector<int>& encoded, int first) {
        int size = encoded.size() + 1;
        vector<int>ans(size);
        ans[0]=first;
        for(int i = 1; i < size; i ++) {
            ans[i] = encoded[i - 1] ^ ans[i - 1];
            cout << "i:" << ans[i] << endl;
        }
//        for(vector<int>::iterator it = encoded.begin(); it != encoded.end(); it ++) {
//            last = * it ^ last;
//            cout << "last :" << last << endl;
//            ans.insert(ans.end(), last);
//        }
        return ans;
    }
};

int main() {
    cout << "Hello" << endl;
    
    vector<int> encoded;
    encoded.insert(encoded.end(), 6);
    encoded.insert(encoded.end(), 2);
    encoded.insert(encoded.end(), 7);
    encoded.insert(encoded.end(), 3);
    int first = 4;
    Solution so;
    so.decode(encoded, first);
    return 0;
}
