# asymptotic

class Solution(object):
    def threeSumSmaller(self, nums, target):
        if len(nums) < 3:
            return 0

        nums.sort()
        count = 0
        i = 0
        while i < len(nums) - 2:
            if nums[i] + nums[i+1] + nums[i+2] >= target:
                break
            j = i+1
            k = len(nums) - 1
            while j < k:
                while j < k and \
                    nums[i] + nums[j] + nums[k] >= target:
                    k -= 1
                count += k-j
                j += 1
            i += 1
        return count
