# slow, heap
import heapq
class Solution(object):
    def nthUglyNumber(self, n):
        if n < 1:
            return 0
        cache = set()
        facts = [2, 3, 5]
        heap = [1]
        heapq.heapify(heap)
        while True:
            curr = heapq.heappop(heap)
            n -= 1
            if n == 0:
                return curr
            for f in facts:
                if curr*f not in cache:
                    cache.add(curr*f)
                    heapq.heappush(heap, curr*f)

# @jmty0083
# smart
class Solution(object):
    def nthUglyNumber(self, n):
        if n <= 0:
            return -1
        if n == 1:
            return 1
        ugly_nums = [0]*n
        p2, p3, p5, ugly_nums[0] = 0, 0, 0, 1
        for i in range(1, n):
            ugly_nums[i] = min(ugly_nums[p2]*2, min(ugly_nums[p3]*3, ugly_nums[p5]*5))
            if ugly_nums[i] == ugly_nums[p2]*2:
                p2 += 1
            if ugly_nums[i] == ugly_nums[p3]*3:
                p3 += 1
            if ugly_nums[i] == ugly_nums[p5]*5:
                p5 += 1
        return ugly_nums[-1]







