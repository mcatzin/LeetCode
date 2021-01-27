
/*
A string S of lowercase English letters is given. We want to partition this string into as
 many parts as possible so that each letter 
appears in at most one part, and return a list of integers representing the size of these parts.
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
 Time: O(n), Space: O(1) [As both the map and output list will have max 26 items, irrespective of input length]
*/

import java.util.*;

class PartitionLabels {
  public List<Integer> partitionLabels(String S) {
    int[] charLastIndexMap = new int[26];

    for (int i = 0; i < S.length(); i++) {
      charLastIndexMap[S.charAt(i) - 'a'] = i;
    }
    List<Integer> result = new ArrayList<>();

    int start = 0;
    int end = 0;

    for (int i = 0; i < S.length(); i++) {
      end = Math.max(end, charLastIndexMap[S.charAt(i) - 'a']);

      if (end == i) {
        result.add(end - start + 1);
        start = i + 1;
        end = i + 1;
      }
    }

    return result;
  }
}