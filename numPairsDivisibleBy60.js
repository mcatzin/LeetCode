/*
You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0
Input: time = [30,20,150,100,40]
Output: 3

Time: O(n) and space: O(N)
*/
var numPairsDivisibleBy60 = function (time) {
  let appearDic = new Map();
  let result = 0;

  time.forEach((el) => {
    const mod = el % 60;
    const left = (60 - mod) % 60;
    result += appearDic[left] ? appearDic[left] : 0;
    appearDic[mod] = appearDic[mod] ? appearDic[mod] + 1 : 1;
  });

  return result;
};
