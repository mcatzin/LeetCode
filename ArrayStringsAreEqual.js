/*
Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.
Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
*/

// time O(n) and space O(n)
var arrayStringsAreEqual = function (word1, word2) {
  const w1 = word1.reduce((acc, cur) => acc + cur, "");
  const w2 = word2.reduce((acc, cur) => acc + cur, "");

  return w1 === w2;
};
