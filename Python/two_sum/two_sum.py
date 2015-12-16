class Solution(object):
	def twoSum(self, nums, target):
		d = {}
		for i, num in enumerate(nums):
			d[target-num] = i
		for i, num in enumerate(nums):
			if num in d and i != d[num]:
				return [i, d[num]]
