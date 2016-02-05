# moore's vote
class Solution(object):
    def majorityElement(self, nums):
        res = nums[0]
        count = 0
        for num in nums:
            if count == 0:
                res = num
                count += 1
            else:
                if res == num:
                    count += 1
                else:
                    count -= 1
        return res
# TODO : divide and couquer, O(nlogn)
