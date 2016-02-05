class Solution(object):
    def summaryRanges(self, nums):
        ranges = []
        i = 0
        while i < len(nums):
            if i == len(nums) - 1:
                ranges.append(str(nums[i]))
                break
            j = i + 1
            while j < len(nums) and nums[j] - nums[j-1] == 1:
                j += 1
            if j - i > 1:
                ranges.append(str(nums[i]) + '->' + str(nums[j-1]))
            else:
                ranges.append(str(nums[i]))
            i = j

        return ranges
