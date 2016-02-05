class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        d = {}
        for i in range(len(nums)):
            if nums[i] in d:
                d[nums[i]].append(i)
            else:
                d[nums[i]] = [i]
        for _, v in d.items():
            if len(v) > 1:
                for i in range(1, len(v)):
                    if v[i] - v[i-1] <= k:
                        return True

        return False
