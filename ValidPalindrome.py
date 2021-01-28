# Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

# Note: For the purpose of this problem, we define empty string as valid palindrome.

# Example 1:

# Input: "A man, a plan, a canal: Panama"
# Output: true
# Time O(N) and space O(N)
class ValidPalindrome:
    def isPalindrome(self, s: str) -> bool:
        r = ''

        for c in s:
            if c.isalnum():
                r += c.lower()

        return r == r[::-1]
