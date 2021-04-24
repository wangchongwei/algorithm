/**
 * 面试题 16.10. 生存人数
给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，实现一个方法以计算生存人数最多的年份。

你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。如果一个人在某一年的任意时期处于生存状态，那么他应该被纳入那一年的统计中。例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。

如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。

 

示例：

输入：
birth = {1900, 1901, 1950}
death = {1948, 1951, 2000}
输出： 1901
 

提示：

0 < birth.length == death.length <= 10000
birth[i] <= death[i]
 */
/**
 * @param {number[]} birth
 * @param {number[]} death
 * @return {number}
 */
var maxAliveYear = function(birth, death) {
    if(birth.length == 1) return birth[0];
    birth.sort((a, b) => a - b);
    death.sort((a, b) => a - b);
    // 最多生存人数肯定是人出生时，所以遍历出生数组
    let count = 0;
    let max = 0;
    let birthNum = 0;
    let desthNum = 0;
    let currentBirth = 0;
    while(birthNum < birth.length && desthNum < death.length) {
        if(birth[birthNum] <= death[desthNum]) {
            count ++;
            if(count > max) {
                max = count;
                currentBirth = birthNum;
            } else if (count == max) {
                currentBirth = Math.min(currentBirth, birthNum );
            }
            birthNum ++;
        } else {
            count --;
            desthNum ++;
        }
    }
    console.log('max', max, 'index', currentBirth);
    console.log('result', birth[currentBirth])
    return birth[currentBirth];
};
// const birth = [1900, 1901, 1950];
// const death = [1948, 1951, 2000];
const birth = [1972,1908,1915,1957,1960,1948,1912,1903,1949,1977,1900,1957,1934,1929,1913,1902,1903,1901]
const death = [1997,1932,1963,1997,1983,2000,1926,1962,1955,1997,1998,1989,1992,1975,1940,1903,1983,1969]
maxAliveYear(birth, death);

