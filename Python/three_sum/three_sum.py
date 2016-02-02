class Solution(object):
    def threeSum(self, nums):
        # using a set to dedup
        nums = sorted(nums)
        res = []
        for i in range(len(nums)):
            # !(A&B) = !A & !B
            if not (i > 0 and nums[i] == nums[i-1]):
                j, k = i+1, len(nums) - 1
                while j < k:
                    if nums[i] + nums[j] + nums[k] == 0:
                        res.append([nums[i], nums[j], nums[k]])
                        # advance/decrease pointer if same
                        while j < k and nums[j] == nums[j+1]:
                            j += 1
                        while j < k and nums[k] == nums[k-1]:
                            k -= 1
                        j += 1
                        k -= 1
                    elif nums[i] + nums[j] + nums[k] > 0:
                        # go through the same process
                        # if hit the same elem
                        k -= 1
                    else:
                        j += 1

        return res