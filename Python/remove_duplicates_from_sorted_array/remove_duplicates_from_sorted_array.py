class Solution(object):
    def removeDuplicates(self, nums):
        if len(nums) < 2:
            return len(nums)
        i = 0
        j = i
        while i < len(nums):
            j = i + 1
            while j < len(nums) and nums[i] == nums[j]:
                nums.pop(j)
            i = j
        return len(nums)

# TODO: O(n)
