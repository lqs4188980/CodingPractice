class Solution(object):
    def findMin(self, nums):
        return self.helper(0, len(nums)-1, nums)

    def helper(self, start, end, nums):
        if start == end:
            return nums[start]
        median = (start + end) // 2
        if nums[median] > nums[end]:
            return self.helper(median+1, end, nums)
        else:
            return self.helper(start, median, nums)
