class Solution(object):
    def maxProduct(self, nums):
        max_prev, min_prev, max_global = nums[0], nums[0], nums[0]
        for i in range(1, len(nums)):
            max_tmp = max(max(max_prev*nums[i], min_prev*nums[i]), nums[i])
            min_tmp = min(min(max_prev*nums[i], min_prev*nums[i]), nums[i])
            max_global = max(max_tmp, max_global)
            max_prev, min_prev = max_tmp, min_tmp

        return max_global
