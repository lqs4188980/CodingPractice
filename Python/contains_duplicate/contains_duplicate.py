# ?
class Solution(object):
	def containsDuplicate(self, nums):
		return len(set(nums)) == len(nums)

class Solution(object):
	def containsDuplicate(self, nums):
        if nums == []:
            return False
        len_set = len(set(nums))
        len_nums = len(nums)
        if len_set == len_nums:
            return False
        else:
            return True