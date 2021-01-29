"""
Given a string, sort it in decreasing order based on the frequency of characters.
Input:
"tree"

Output:
"eert"

Time O(nlogk) and space O(n)
"""


class Solution:
    def frequencySort(self, s: str) -> str:
        cnt = collections.Counter(s)

        heap = [(-v, k) for k, v in cnt.items()]
        heapq.heapify(heap)

        res = []

        while heap:
            v, k = heapq.heappop(heap)
            res += k * -v
        return ''.join(res)
