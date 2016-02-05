from pdb import set_trace as bp

class Solution(object):
    def subsets(self, nums):
        nums = sorted(nums)
        results = []
        self.helper(0, nums, [], results)
        return results

    def helper(self, idx, nums, curr, results):
        results.append(curr)
        if idx == len(nums):
            return
        for i in range(idx, len(nums)):
            if curr == []:
                new_curr = [nums[i]]
            else:
                new_curr = curr + [nums[i]]
            self.helper(i+1, nums, new_curr, results)
