# 1. sort list, split, combine
# 2. modify through iteration???
class Solution(object):
    def wiggleSort(self, nums):
        if len(nums) < 2:
            return
        copy_nums = sorted(nums)
        i, j, idx = 0, len(nums)-1, 0
        while idx < len(nums):
            nums[idx] = copy_nums[i]
            idx += 1
            # dont like it
            if idx < len(nums):
                nums[idx] = copy_nums[j]
            idx += 1
            i += 1
            j -= 1
