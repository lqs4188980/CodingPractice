class Solution(object):
    def minSubArrayLen(self, s, nums):
        if len(nums) < 1:
            return 0
        # sliding window, messy
        start, end, ws, min_len = 0, 0, 0, len(nums)
        while end != len(nums):
            while ws < s and end != len(nums):
                ws += nums[end]
                end += 1
            while ws > s:
                if ws - nums[start] <= s:
                    break
                ws -= nums[start]
                start += 1
            if ws - nums[start] == s:
                ws -= nums[start]
                start += 1
            min_len = min(end-start, min_len)
            if end < len(nums):
                ws += nums[end]
                end += 1
        while ws > s:
            if ws - nums[start] <= s:
                break
            ws -= nums[start]
            start += 1

        if ws - nums[start] == s:
            ws -= nums[start]
            start += 1
        if ws < s:
            return 0
        else:
            return min(end-start, min_len)
