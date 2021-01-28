"""
Balanced strings are those who have equal quantity of 'L' and 'R' characters.

Given a balanced string s split it in the maximum amount of balanced strings.

Return the maximum amount of splitted balanced strings.

Input: s = "RLRRLLRLRL"
Output: 4
"""


class Solution:
    def balancedStringSplit(self, s: str) -> int:
        maximumAmount = balancedChar = 0

        for char in s:
            if char == 'L':
                balancedChar += 1
            if char == 'R':
                balancedChar -= 1
            if balancedChar == 0:
                maximumAmount += 1

        return maximumAmount
