import java.util.List;

/*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
TC: O(n^3) Dynamic Programming
*/

public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    if (s.length() == 0) {
      return false;
    }

    Set<String> set = new HashSet<>();
    for (String str : wordDict) {
      set.add(str);
    }
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int len = 1; len <= s.length(); len++) {
      for (int i = 0; i < len; i++) {
        if (dp[i] && set.contains(s.substring(i, len))) {
          dp[len] = true;
          break;
        }
      }
    }

    return dp[s.length()];
  }
}
