# move backwards
class Solution(object):
    def canJump(self, nums):
        max_idx = len(nums)-1
        for i in reversed(range(len(nums)-1)):
            if nums[i] + i >= max_idx:
                max_idx = i
        return max_idx == 0

