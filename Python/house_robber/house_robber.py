# formula:
# r[i] = max(r[i-2] + nums[i], r[i-1])
class Solution(object):
    def rob(self, nums):
        prev = 0
        curr = 0
        for i in range(len(nums)):
            _next = max(prev + nums[i], curr)
            prev = curr
            curr = _next
        return curr
