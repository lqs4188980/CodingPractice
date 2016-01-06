class Solution(object):
	def moveZeroes(self, nums):
		idx = 0
		for i in range(len(nums)):
			if nums[i] != 0:
				idx += 1
			else:
				break
		for i in range(idx+1, len(nums)):
			if nums[i] == 0:
				continue
			else:
				nums[idx] = nums[i]
				idx += 1
		for i in range(idx, len(nums)):
			nums[i] = 0
