# move forwards
class Solution(object):
    def canJump(self, nums):
        max_dist = 0
        for i, num in enumerate(nums):
            if max_dist >= i:
                max_dist = max(max_dist, num+i)
            else:
                break
        return max_dist >= len(nums)-1
# backwards: if(i+num>=last): num=i