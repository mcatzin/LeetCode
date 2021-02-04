import java.util.*;
/*
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not in the list of banned words. It is guaranteed there is at least
 * one word that isn't banned, and that the answer is unique.
 * 
 * Words in the list of banned words are given in lowercase, and free of
 * punctuation. Words in the paragraph are not case sensitive. The answer is in
 * lowercase.
 * 
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit." banned
 * = ["hit"] Output: "ball"
 */

class Solution {
  public String mostCommonWord(String paragraph, String[] banned) {
    Set<String> banSet = new HashSet<String>();
    for (String word : banned)
      banSet.add(word);

    Map<String, Integer> strCount = new HashMap<String, Integer>();
    int n = paragraph.length();
    int left = 0;
    int right = 1;
    if (!Character.isLetter(paragraph.charAt(n - 1))) {
      paragraph += ".";
    }
    char[] charParagraph = paragraph.toCharArray();
    int max = 0;
    String maxWord = "";

    while (left < n) {
      while (Character.isLetter(charParagraph[right]))
        right++;
      String newWord = paragraph.substring(left, right).toLowerCase();
      if (!banSet.contains(newWord)) {
        int newCount = strCount.getOrDefault(newWord, 0) + 1;
        strCount.put(newWord, newCount);
        if (newCount > max) {
          max = newCount;
          maxWord = newWord;
        }
      }
      while (right < n && !Character.isLetter(charParagraph[right]))
        right++;
      left = right;
    }
    return maxWord;
  }
}
